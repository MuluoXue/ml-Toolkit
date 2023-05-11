package com.ml.toolkit.form.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ml
 * @date 2023年05月11日 20:30
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormTable extends BaseEntity{
    private static final long serialVersionUID = 6361917910545791889L;

    private Long formId;

    /**
     * 物理表名称
     */
    private String tableName;

    /**
     * 数据库表名
     */
    private String physicsName;
}
