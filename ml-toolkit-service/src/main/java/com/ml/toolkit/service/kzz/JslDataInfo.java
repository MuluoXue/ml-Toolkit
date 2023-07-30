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
//        if (ObjectUtil.isEmpty(cookies)) {
//            login();
//        }
//        Map<String, String> param = new HashMap<>(8);
//        param.put("is_search", "N");
//        param.put("listed", "Y");
//        param.put("qflag", "N");
//        param.put("rp", "50");
//        param.put("page", "1");
//
//        Map<String, String> headerMap = new HashMap<>(8);
//        StringBuilder cookie = new StringBuilder();
//        for (String s : cookies.keySet()) {
//            cookie.append(s).append("=").append(cookies.get(s)).append(";");
//        }
//        cookie.append("kbz_newcookie=1");
//        headerMap.put("cookie", cookie.toString());

//        String responseContent = HttpUtil.post(KZZ_URL, param, headerMap, HttpUtil::findResponseContent);
//        log.info("responseContent  {}", responseContent);

        String responseContent = "{\"page\":1,\"rows\":[{\"id\":\"123015\",\"cell\":{\"bond_id\":\"123015\",\"bond_nm\":\"Z蓝转退\",\"bond_py\":\"ldzz\",\"price\":26.93,\"increase_rt\":5.91,\"stock_id\":\"300297\",\"stock_nm\":\"蓝盾退\",\"stock_py\":\"ldgf\",\"sprice\":0.23,\"sincrease_rt\":4.55,\"pb\":-0.32,\"convert_price\":\"0.840\",\"convert_value\":27.38,\"convert_dt\":0,\"premium_rt\":-1.65,\"dblow\":25.28,\"sw_cd\":\"710301\",\"market_cd\":\"szcy\",\"btype\":\"C\",\"list_dt\":\"2018-09-13\",\"qflag2\":\"N\",\"owned\":0,\"hold\":0,\"bond_value\":\"buy\",\"rating_cd\":\"CC\",\"option_value\":null,\"put_convert_price\":0.59,\"force_redeem_price\":1.09,\"convert_amt_ratio\":34.3,\"fund_rt\":\"buy\",\"maturity_dt\":\"2024-08-13\",\"year_left\":1.047,\"curr_iss_amt\":0.983,\"volume\":1310.77,\"svolume\":2779.43,\"turnover_rt\":49.92,\"ytm_rt\":301.03,\"put_ytm_rt\":null,\"noted\":0,\"bond_nm_tip\":\"\",\"redeem_icon\":\"\",\"last_time\":\"15:34:33\",\"qstatus\":\"00\",\"margin_flg\":\"\",\"sqflag\":\"Y\",\"pb_flag\":\"N\",\"adj_cnt\":5,\"adj_scnt\":\"4\",\"convert_price_valid\":\"Y\",\"convert_price_tips\":\"转股价下修5次，成功下修4次\",\"convert_cd_tip\":\"2019-02-18 开始转股\",\"ref_yield_info\":\"计算使用1.1年期 评级为CC 债参考YTM：99.3337\",\"adjusted\":\"N\",\"orig_iss_amt\":5.38,\"price_tips\":\"全价：26.930 最后更新：15:34:33\",\"redeem_dt\":null,\"real_force_redeem_price\":null,\"option_tip\":\"\",\"notes\":null,\"volatility_rate\":\"buy\"}},{\"id\":\"113057\",\"cell\":{\"bond_id\":\"113057\",\"bond_nm\":\"中银转债\",\"bond_py\":\"zyzz\",\"price\":144.955,\"increase_rt\":5.81,\"stock_id\":\"601881\",\"stock_nm\":\"中国银河\",\"stock_py\":\"zgyh\",\"sprice\":14.17,\"sincrease_rt\":10.02,\"pb\":1.39,\"convert_price\":\"9.700\",\"convert_value\":146.08,\"convert_dt\":0,\"premium_rt\":-0.77,\"dblow\":144.19,\"sw_cd\":\"490101\",\"market_cd\":\"shmb\",\"btype\":\"C\",\"list_dt\":\"2022-05-10\",\"qflag2\":\"N\",\"owned\":0,\"hold\":0,\"bond_value\":\"buy\",\"rating_cd\":\"AAA\",\"option_value\":null,\"put_convert_price\":null,\"force_redeem_price\":12.61,\"convert_amt_ratio\":5.7,\"fund_rt\":\"buy\",\"maturity_dt\":\"2028-03-24\",\"year_left\":4.66,\"curr_iss_amt\":54.214,\"volume\":368986.22,\"svolume\":372877.47,\"turnover_rt\":47.71,\"ytm_rt\":-5.86,\"put_ytm_rt\":null,\"noted\":0,\"bond_nm_tip\":\"\",\"redeem_icon\":\"\",\"last_time\":\"14:59:59\",\"qstatus\":\"00\",\"margin_flg\":\"R\",\"sqflag\":\"Y\",\"pb_flag\":\"N\",\"adj_cnt\":0,\"adj_scnt\":0,\"convert_price_valid\":\"Y\",\"convert_price_tips\":\"\",\"convert_cd_tip\":\"2022-09-30 开始转股\",\"ref_yield_info\":\"计算使用4.7年期 评级为AAA 债参考YTM：2.9787\",\"adjusted\":\"N\",\"orig_iss_amt\":78,\"price_tips\":\"全价：144.955 最后更新：14:59:59\",\"redeem_dt\":null,\"real_force_redeem_price\":null,\"option_tip\":\"\",\"notes\":null,\"volatility_rate\":\"buy\"}},{\"id\":\"128114\",\"cell\":{\"bond_id\":\"128114\",\"bond_nm\":\"正邦转债\",\"bond_py\":\"zbzz\",\"price\":81.92,\"increase_rt\":2.4,\"stock_id\":\"002157\",\"stock_nm\":\"*ST正邦\",\"stock_py\":\"zbkj\",\"sprice\":2.52,\"sincrease_rt\":0.4,\"pb\":-0.87,\"convert_price\":\"3.060\",\"convert_value\":82.35,\"convert_dt\":0,\"premium_rt\":-0.53,\"dblow\":81.39,\"sw_cd\":\"110702\",\"market_cd\":\"szmb\",\"btype\":\"C\",\"list_dt\":\"2020-07-15\",\"qflag2\":\"N\",\"owned\":1,\"hold\":0,\"bond_value\":\"buy\",\"rating_cd\":\"CCC\",\"option_value\":null,\"put_convert_price\":2.14,\"force_redeem_price\":3.98,\"convert_amt_ratio\":6.8,\"fund_rt\":\"buy\",\"maturity_dt\":\"2026-06-17\",\"year_left\":2.89,\"curr_iss_amt\":4.562,\"volume\":24288.77,\"svolume\":18337.85,\"turnover_rt\":66.4,\"ytm_rt\":12.09,\"put_ytm_rt\":null,\"noted\":0,\"bond_nm_tip\":\"\",\"redeem_icon\":\"\",\"last_time\":\"15:34:15\",\"qstatus\":\"00\",\"margin_flg\":\"\",\"sqflag\":\"Y\",\"pb_flag\":\"N\",\"adj_cnt\":4,\"adj_scnt\":\"4\",\"convert_price_valid\":\"Y\",\"convert_price_tips\":\"转股价下修4次，成功下修4次\",\"convert_cd_tip\":\"2020-12-23 开始转股\",\"ref_yield_info\":\"计算使用2.9年期 评级为CCC 债参考YTM：45.5372\",\"adjusted\":\"N\",\"orig_iss_amt\":16,\"price_tips\":\"全价：81.920 最后更新：15:34:15\",\"redeem_dt\":null,\"real_force_redeem_price\":null,\"option_tip\":\"\",\"notes\":null,\"volatility_rate\":\"buy\"}}],\"total\":503}";

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
