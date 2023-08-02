package com.ml.toolkit.form.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageEntity implements Serializable {
    private static final long serialVersionUID = -8454680939668585175L;

    private int page;

    private int limit;
}
