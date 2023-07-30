package com.ml.toolkit.service.kzz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.ml.toolkit.form.domain.sys.SimpleUser;
import com.ml.toolkit.form.dto.form.data.FormDataDto;
import com.ml.toolkit.form.service.data.FormDataDetailService;
import com.ml.toolkit.form.service.data.FormDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ml
 */
@Slf4j
@Component
public class KzzServiceImpl implements KzzService {

    private static final Long FORM_ID = 4549046974911737742L;

    @Resource
    private FormDataService formDataService;

    @Resource
    private FormDataDetailService formDataDetailService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void gradJiSiLuData() throws Exception {
        JslDataInfo instance = JslDataInfo.getInstance();
        List<FormDataDto> list = instance.listKzz(true);
        if (ObjectUtil.isNotEmpty(list)) {
            SimpleUser user = new SimpleUser();
            user.setId(1L);
            list.forEach(formData -> {
                formData.setFormId(FORM_ID);
                // 根据 编码进行搜索，如果搜索到了，证明存在,进行修改， 搜索不到， 进行新增
                List<FormDataDetail> formDataDetailList = null;
                for (FormDataDetail detail : formData.getFormDataDetailList()) {
                    if (detail.getFieldId().equals(4549046977173837744L)) {
                        QueryWrapper<FormDataDetail> wrapper = new QueryWrapper<>();
                        wrapper.lambda().eq(FormDataDetail::getContent, detail.getContent());
                        formDataDetailList = formDataDetailService.list(wrapper);
                    }
                }
                if (ObjectUtil.isNotEmpty(formDataDetailList)) {
                    formData.setDataId(formDataDetailList.get(0).getDataId());
                }
                formDataService.saveData(formData, user);
            });
        }
    }
}
