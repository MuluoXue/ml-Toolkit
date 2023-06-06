package com.ml.toolkit.log.domain;

import com.ml.toolkit.bean.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
public class MlLog implements Serializable {

    private static final long serialVersionUID = 4362507095422731994L;

    /**
     * id
     */
    private Long id;

    private String operator;

    private Date operateTime;

    /**
     * 日志名称
     */
    private String logName;

    /**
     * 日志描述、方法描述
     */
    private String  logDescribe;

    /**
     * 来源ip
     */
    private String ip;

    /**
     * 日志记录方法路径
     */
    private String path;
}
