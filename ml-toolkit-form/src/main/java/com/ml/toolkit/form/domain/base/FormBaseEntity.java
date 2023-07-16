package com.ml.toolkit.form.domain.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ml.toolkit.form.domain.sys.SimpleUser;
import com.ml.toolkit.form.handler.sys.SysUserTypeHandler;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用base 实体类
 * @author ml
 */
@Data
public class FormBaseEntity implements Serializable {

    private static final long serialVersionUID = 8604755723878533734L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @TableField(typeHandler = SysUserTypeHandler.class)
    private SimpleUser creator;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
