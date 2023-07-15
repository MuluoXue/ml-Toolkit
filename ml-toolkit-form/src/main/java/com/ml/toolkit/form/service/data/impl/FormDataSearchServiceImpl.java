package com.ml.toolkit.form.service.data.impl;

import com.ml.toolkit.common.collection.ListUtil;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.form.domain.data.FormData;
import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.ml.toolkit.form.service.data.FormDataDetailService;
import com.ml.toolkit.form.service.data.FormDataSearchService;
import com.ml.toolkit.form.service.data.FormDataService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FormDataSearchServiceImpl implements FormDataSearchService {
    @Resource
    private FormDataService formDataService;

    @Resource
    private FormDataDetailService formDataDetailService;

    @Override
    public Map<String, Object> listByEntity(FormData formData) {
        Map<String,Object> formDataParam = new HashMap<>();
        formDataParam.put("form_id", formData.getFormId());
        List<FormData> formDataList = formDataService.listByMap(formDataParam);

        Map<String, Object> result = new HashMap<>();
        result.put("formDataList", formDataList);
        if (ObjectUtil.isNotEmpty(formDataList)) {
            List<FormDataDetail> formDataDetails = formDataDetailService.listByFormDataIdList(ListUtil.listToList(formDataList, FormData::getId));
            if (ObjectUtil.isNotEmpty(formDataDetails)) {
                result.put("formDataDetails", formDataDetails);
            }
        }
        return result;
    }
}
