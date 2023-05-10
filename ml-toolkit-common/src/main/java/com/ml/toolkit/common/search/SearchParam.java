package com.ml.toolkit.common.search;

import com.ml.toolkit.common.search.enums.SearchTerm;
import com.ml.toolkit.common.util.ObjectUtil;

import java.io.Serializable;

/**
 * @author ml
 * @date 2023年04月12日 23:15
 */
public class SearchParam implements Serializable {

    private static final long serialVersionUID = 3989090951117098924L;

    /**
     * 字段ID
     */
    private String field;

    /**
     * 字段条件
     */
    private SearchTerm term;

    /**
     * 内容
     */
    private String content;

    private NumberParam number;


    public String toSqlString() {
        StringBuilder sb = new StringBuilder();
        if (ObjectUtil.isNotEmpty(number)) {
            if (SearchTerm.NULL.equals(this.term) || SearchTerm.NOT_NULL.equals(this.term)) {
                sb.append(this.field).append(" ").append(this.term.getType());
            } else if (SearchTerm.LIKE.equals(this.term)) {
                if (ObjectUtil.isNotEmpty(number.getMax()) && ObjectUtil.isNotEmpty(number.getMin())) {
                    sb.append("( ").append(this.field).append(" >= ").append(number.getMin()).
                            append(" and ").append(this.field).append(" <= ").append(number.getMax())
                            .append(")");
                }
            } else {
                if (ObjectUtil.isNotEmpty(number.getContent())) {
                    sb.append(this.field).append(" ").append(this.term).append(number.getContent());
                }
            }
            return sb.toString();
        }

        //文本
        if (SearchTerm.LIKE.equals(this.term)) {
            sb.append(" locate(").append(this.content).append(",").append(this.field).append(")");
            return sb.toString();
        } else if (SearchTerm.NULL.equals(this.term) || SearchTerm.NOT_NULL.equals(this.term)) {
            return this.field + " " + this.term.getType();
        }
        return "";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public SearchTerm getTerm() {
        return term;
    }

    public void setTerm(SearchTerm term) {
        this.term = term;
    }
}
