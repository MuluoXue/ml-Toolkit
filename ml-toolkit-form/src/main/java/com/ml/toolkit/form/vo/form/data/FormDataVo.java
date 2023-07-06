package com.ml.toolkit.form.vo.form.data;

import com.ml.toolkit.form.domain.FormField;
import com.ml.toolkit.form.domain.data.FormData;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FormDataVo implements Serializable {
    private static final long serialVersionUID = 2268970460965288844L;

    private FormData formData;

    private List<FormField> formFieldList;
}
