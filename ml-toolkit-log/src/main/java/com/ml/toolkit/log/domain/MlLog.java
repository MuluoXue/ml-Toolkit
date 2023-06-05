package com.ml.toolkit.log.domain;

import com.ml.toolkit.bean.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MlLog extends BaseEntity {

    private static final long serialVersionUID = 4362507095422731994L;

    private String name;

    private String  logDescribe;

    private String ip;

    private String path;
}
