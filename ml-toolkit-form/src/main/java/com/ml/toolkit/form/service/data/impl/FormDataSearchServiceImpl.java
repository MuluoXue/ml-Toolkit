package com.ml.toolkit.form.service.data.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ml.toolkit.common.collection.ListUtil;
import com.ml.toolkit.common.util.Assert;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.form.domain.data.FormData;
import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.ml.toolkit.form.dto.form.data.FormDataDto;
import com.ml.toolkit.form.service.data.FormDataDetailService;
import com.ml.toolkit.form.service.data.FormDataSearchService;
import com.ml.toolkit.form.service.data.FormDataService;
import com.ml.toolkit.form.vo.form.data.FormDataVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class FormDataSearchServiceImpl implements FormDataSearchService {
    @Resource
    private FormDataService formDataService;

    @Resource
    private FormDataDetailService formDataDetailService;

    @Override
    public Page<FormData> pageByEntity(FormDataDto param) {
        Assert.notEmpty("params is empty", param.getFormId());
        Page<FormData> page = new Page<>(param.getPage(), param.getLimit());
        QueryWrapper<FormData> wr = new QueryWrapper<>();
        wr.lambda().eq(FormData::getForm, param.getFormId());
        page = formDataService.page(page, wr);
        List<FormData> formDataList = page.getRecords();
        if (ObjectUtil.isNotEmpty(formDataList)) {
            List<FormDataDetail> formDataDetails = formDataDetailService.listByFormDataIdList(ListUtil.listToList(formDataList, FormData::getId));
            if (ObjectUtil.isNotEmpty(formDataDetails)) {
                Map<Long, List<FormDataDetail>> longListMap = ListUtil.listToMapList(formDataDetails, FormDataDetail::getDataId, Function.identity());
                formDataList.forEach(formData -> formData.setFormDataDetailList(longListMap.getOrDefault(formData.getId(), new ArrayList<>())));
            }
        }
        page.setRecords(formDataList);
        return page;
    }
}
