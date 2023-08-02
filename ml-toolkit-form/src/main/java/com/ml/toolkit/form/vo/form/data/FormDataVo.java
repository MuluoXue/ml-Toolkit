package com.ml.toolkit.form.vo.form.data;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ml.toolkit.form.domain.data.FormDataDetail;
import com.ml.toolkit.form.domain.form.field.FormField;
import com.ml.toolkit.form.domain.data.FormData;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FormDataVo implements Serializable {
    private static final long serialVersionUID = 2268970460965288844L;

    private FormData formData;

    private List<FormField> formFieldList;

    private List<FormDataDetail> formDataDetailList;

    private Page<FormData> page;
}
