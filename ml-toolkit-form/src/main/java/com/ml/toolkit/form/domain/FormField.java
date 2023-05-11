package com.ml.toolkit.form.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ml
 * @date 2023年05月11日 20:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormField extends BaseEntity{
    private static final long serialVersionUID = -4160443730215713001L;

    private String name;

    private Long formId;

    /**
     * 字段列名
     */
    private String fieldKey;
}
