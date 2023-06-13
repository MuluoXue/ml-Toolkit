package com.ml.toolkit.log.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LogContext extends BaseLog {

    /**
     * 老内容
     */
    Object oldObject;

    /**
     * 新内容
     */
    Object newObject;
}
