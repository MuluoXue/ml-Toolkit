package com.ml.toolkit.form.domain;

import com.ml.toolkit.form.domain.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormField extends BaseEntity {
    private static final long serialVersionUID = -5949839660728403782L;

    private String name;

    private Long formId;
}
