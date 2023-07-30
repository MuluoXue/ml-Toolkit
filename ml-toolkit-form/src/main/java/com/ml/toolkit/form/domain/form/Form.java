package com.ml.toolkit.form.domain.form;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ml.toolkit.form.domain.base.FormBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ml
 * @date 2023年05月11日 20:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(resultMap = "resultMap")
public class Form extends FormBaseEntity {

    private static final long serialVersionUID = -7883088166454023696L;

    /**
     * 表单名称
     */
    private String name;

    public Form() {
    }

    public Form(Long id) {
        this.setId(id);
    }
}
