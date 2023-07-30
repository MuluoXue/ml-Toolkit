package com.ml.toolkit.form.domain.data;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ml.toolkit.form.domain.base.FormBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName(resultMap = "resultMap")
public class FormDataDetail extends FormBaseEntity {

    private static final long serialVersionUID = -8565805993593287469L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long dataId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long fieldId;

    private String content;
}
