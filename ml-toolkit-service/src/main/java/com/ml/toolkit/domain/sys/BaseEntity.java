package com.ml.toolkit.domain.sys;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用base 实体类
 * @author ml
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8604755723878533734L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private Date createTime;

    private Date updateTime;

}
