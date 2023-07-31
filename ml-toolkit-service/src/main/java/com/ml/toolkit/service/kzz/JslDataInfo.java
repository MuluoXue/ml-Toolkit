package com.ml.toolkit.service.kzz;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.form.domain.data.FormData;
import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.ml.toolkit.form.dto.form.data.FormDataDto;
import com.ml.toolkit.util.http.HttpFun;
import com.ml.toolkit.util.http.HttpUtil;

import java.io.Serializable;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;

/**
 * @author ml
 * @date 2023年02月08日 19:51
 */
@Slf4j
public class JslDataInfo implements Serializable {

    private static final long serialVersionUID = -7371870366065888193L;

    /**
     * 集思录登录接口
     */
    private static final String LOGIN_URL = "https://www.jisilu.cn/webapi/account/login_process/";

    /**
     * 可转债获取接口
     */
    private static final String KZZ_URL = "https://www.jisilu.cn/data/cbnew/cb_list_new/?___jsl=LST___t=1675782700158";
    public static final String WARN = "warn";

    private static HashMap<String, String> cookies = null;

    private static final HashMap<Long, String> FIELD_MAP = new HashMap<Long, String>() {
        private static final long serialVersionUID = 1501584139181087676L;

        {
            //编码
            put(4549046977173837744L, "bond_id");
            //名称
            put(4549046976491037743L, "bond_nm");
            // 价格
            put(4549046977768837745L, "price");
            // 溢价率
            put(6229070984589733312L, "premium_rt");
            // 到期时间
            put(6229070989432433313L, "short_maturity_dt");
            //剩余年限
            put(6229070993822733314L, "year_left");
            //剩余规模
            put(6229071000047533315L, "curr_iss_amt");
            //到期税前收益
            put(6229071005132233316L, "ytm_rt");
            //强赎日期
            put(6229071008789933317L, "redeem_dt");

//                        kzz.setDBlow(cell.getString("dblow"));
//                        kzz.setAdjScnt(cell.getString("adj_scnt"));
//                        kzz.setConvertValue(cell.containsKey("convert_value") ? cell.getString("convert_value") : "");
//                        kzz.setIncreaseRt(cell.getString("increase_rt"));
////                        kzz.setStockId(cell.getString("stock_id"));
////                        kzz.setStockNm(cell.getString("stock_nm"));
////                        kzz.setSPrice(cell.getString("sprice"));
////                        kzz.setPb(cell.getString("pb"));
        }
    };


    private JslDataInfo() {
    }

    private static final class DataInfoHolder {
        static final JslDataInfo DATA_INFO = new JslDataInfo();
    }

    public static JslDataInfo getInstance() {
        return DataInfoHolder.DATA_INFO;
    }

    private void login() throws Exception {
        Map<String, String> param = new HashMap<>(4);
        param.put("return_url", "https://www.jisilu.cn/");
        param.put("user_name", "7bf44048d3f4005890f0d8b3b3875275");
        param.put("password", "4c9f9b528b1be360781a2f3a24fb7d00");
        param.put("auto_login", "1");
        param.put("aes", "1");

        HttpUtil.post(LOGIN_URL, param, null, (HttpFun<String>) response -> {
            Header[] headers = response.getHeaders("Set-Cookie");
            cookies = new HashMap<>(2);
            for (Header header : headers) {
                if (header.getValue().contains("kbzw__user_login")) {
                    String token = header.getValue()
                            .substring(header.getValue().indexOf("=") + 1, header.getValue().indexOf(';'));
                    cookies.put("kbzw__user_login", token);
                } else if (header.getValue().contains("kbzw__Session")) {
                    String token = header.getValue()
                            .substring(header.getValue().indexOf("=") + 1, header.getValue().indexOf(';'));
                    cookies.put("kbzw__Session", token);
                }
            }
            return null;
        });
    }

    public List<FormDataDto> listKzz(boolean first) throws Exception {
        if (ObjectUtil.isEmpty(cookies)) {
            login();
        }
        Map<String, String> param = new HashMap<>(8);
        param.put("is_search", "N");
        param.put("listed", "Y");
        param.put("qflag", "N");
        param.put("rp", "50");
        param.put("page", "1");

        Map<String, String> headerMap = new HashMap<>(8);
        StringBuilder cookie = new StringBuilder();
        for (String s : cookies.keySet()) {
            cookie.append(s).append("=").append(cookies.get(s)).append(";");
        }
        cookie.append("kbz_newcookie=1");
        headerMap.put("cookie", cookie.toString());

        String responseContent = HttpUtil.post(KZZ_URL, param, headerMap, HttpUtil::findResponseContent);
        log.info("responseContent  {}", responseContent);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseContent);
        if (ObjectUtil.isNotEmpty(jsonNode)) {
            if (jsonNode.hasNonNull(WARN)) {
                if (first) {
                    cookies = null;
                    listKzz(false);
                } else {
                    return null;
                }
            } else {
                List<FormDataDto> dataList = new ArrayList<>();
                JsonNode rows = jsonNode.get("rows");
                if (rows.isArray()) {
                    // 遍历数组元素
                    Iterator<JsonNode> iterator = rows.elements();
                    while (iterator.hasNext()) {
                        JsonNode element = iterator.next();
                        FormDataDto formData = new FormDataDto();
                        List<FormDataDetail> detailList = new ArrayList<>();
                        JsonNode cell = element.get("cell");
                        for (Map.Entry<Long, String> field : FIELD_MAP.entrySet()) {
                            // 编码
                            FormDataDetail formDataDetail = parseFormDatDetail(cell, field.getKey(), field.getValue());
                            if (formDataDetail != null) {
                                detailList.add(formDataDetail);
                            }
                        }
                        formData.setFormDataDetailList(detailList);
                        dataList.add(formData);
                    }
                }
                return dataList;
            }
        }
        return null;
    }

    private FormDataDetail parseFormDatDetail(JsonNode cell, Long fieldId, String valueKey) {
        if (cell.has(valueKey)) {
            String value = cell.get(valueKey).asText();
            if (ObjectUtil.isNotEmpty(value) && !value.equals("null")) {
                FormDataDetail formDataDetail = new FormDataDetail();
                formDataDetail.setFieldId(fieldId);
                formDataDetail.setContent(value);
                return formDataDetail;
            } else {
                return null;
            }
        }
        return null;
    }
}
