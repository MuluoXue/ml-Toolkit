package com.ml.toolkit.form.domain.data;

import com.ml.toolkit.bean.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormData extends BaseEntity {
    private static final long serialVersionUID = -652004015884665686L;

    private Long formId;

    private List<FormDataDetail> formDataDetailList;

}
