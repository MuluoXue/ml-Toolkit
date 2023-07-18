package com.ml.toolkit.form.domain.form.field;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ml.toolkit.form.domain.base.FormBaseEntity;
import com.ml.toolkit.form.domain.form.Form;
import com.ml.toolkit.form.handler.form.FormTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@TableName(resultMap = "resultMap")
@EqualsAndHashCode(callSuper = true)
@Data
public class FormField extends FormBaseEntity {
    private static final long serialVersionUID = -5949839660728403782L;

    /**
     * 字段名称
     */
    @NotNull
    private String name;

    /**
     * 字段类型
     */
    @NotNull
    private FieldType type;

    /**
     * 所属表单
     */
    @NotNull
    @TableField(value = "form_id", typeHandler = FormTypeHandler.class)
    private Form form;
}
