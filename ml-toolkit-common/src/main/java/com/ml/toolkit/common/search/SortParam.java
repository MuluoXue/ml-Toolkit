package com.ml.toolkit.common.search;

import java.io.Serializable;

/**
 * 排序sql 封装
 * @author ml
 * @date 2023年04月12日 23:21
 */
public class SortParam implements Serializable {

    private static final long serialVersionUID = 3284979703545467254L;

    private String field;

    private String order;

    public String toSqlString() {
        return this.field + " " + getOrder();
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
