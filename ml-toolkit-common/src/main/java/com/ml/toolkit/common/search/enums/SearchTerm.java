package com.ml.toolkit.common.search.enums;

/**
 * @author ml
 */

public enum SearchTerm {
    /**
     * 包含
     */
    LIKE("like"),
    /**
     * 等于
     */
    EQ(" = "),
    /**
     * 小于*
     */
    LT(" < "),
    /**
     * 大于
     */
    GT(" > "),
    /**
     * 为空
     */
    NULL(" is null"),
    /**
     * 不为空
     */
    NOT_NULL(" is not null"),
    /**
     * 不包含
     */
    NOT_IN(" not in ");


    /**
     * 查询类型
     */
    private final String type;

    SearchTerm(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
