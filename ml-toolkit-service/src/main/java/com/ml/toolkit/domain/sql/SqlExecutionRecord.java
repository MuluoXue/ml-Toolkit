package com.ml.toolkit.domain.sql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ml.toolkit.domain.sys.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SqlExecutionRecord extends BaseEntity {

    private static final long serialVersionUID = 485076026628703963L;

    private String executionName;

    /**
     * 0执行成功 1.执行失败
     */
    private int state;

    private String errorSql;

    private String errorMsg;
}
