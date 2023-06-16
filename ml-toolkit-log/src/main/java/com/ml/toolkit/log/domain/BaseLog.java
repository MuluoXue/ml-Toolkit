package com.ml.toolkit.log.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseLog implements Serializable {

    private static final long serialVersionUID = 4362507095422731994L;

    /**
     * id
     */
    private Long id;

    /**
     * 操作类型
     */
    private String operateType;

    /**
     * 日志名称
     */
    private String logName;

    /**
     * 方法名称
     */
    private String  functionName;

    /**
     * 日志记录方法路径
     */
    private String functionPath;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date operateTime;
}
