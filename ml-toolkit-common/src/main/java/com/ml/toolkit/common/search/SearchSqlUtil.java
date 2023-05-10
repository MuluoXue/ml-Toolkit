package com.ml.toolkit.common.search;

import com.ml.toolkit.common.util.ObjectUtil;

import java.io.Serializable;
import java.util.List;

/**
 * @author ml
 * @date 2023年05月10日 21:51
 */
public class SearchSqlUtil implements Serializable {
    private static final long serialVersionUID = -5257710804268368102L;

    public static String generateSql(List<SearchParam> list, String condition) {
        if (ObjectUtil.isEmpty(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(param -> sb.append(" ").append(param.toSqlString()).append(" ").append(condition).append(" "));
        if (sb.length() > 0) {
            sb.delete(sb.length() - (2 + condition.length()), sb.length());
        }
        return sb.toString();
    }

    public static String generateOrderSql(SortParam param) {
        return param.toSqlString();
    }
}
