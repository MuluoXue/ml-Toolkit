package com.ml.toolkit.common.search;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ml
 * @date 2023年05月10日 22:13
 */
@Data
public class SearchDto implements Serializable {

    private static final long serialVersionUID = -2131511112724274399L;



   private List<SearchParam> paramList;

   private String condition;
}
