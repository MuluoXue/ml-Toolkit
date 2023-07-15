package com.ml.toolkit.form.domain;

import com.ml.toolkit.form.domain.base.FormBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormField extends FormBaseEntity {
    private static final long serialVersionUID = -5949839660728403782L;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 表单ID
     */
    private Long formId;
}
