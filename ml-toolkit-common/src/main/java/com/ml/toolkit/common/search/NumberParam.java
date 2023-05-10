package com.ml.toolkit.common.search;

import com.ml.toolkit.common.search.enums.SearchTerm;
import com.ml.toolkit.common.util.ObjectUtil;

import java.io.Serializable;

/**
 * @author ml
 * @date 2023年04月12日 23:19
 */
public class NumberParam implements Serializable {

    private static final long serialVersionUID = 5277185292721858383L;

    private Double min;

    private Double max;

    private String content;


    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
