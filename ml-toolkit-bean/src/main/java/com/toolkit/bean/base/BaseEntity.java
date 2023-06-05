package com.toolkit.bean.base;

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

    private Long id;

    private Date createTime;

}
