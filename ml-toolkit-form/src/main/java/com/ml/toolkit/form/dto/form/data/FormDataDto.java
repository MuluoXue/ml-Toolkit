package com.ml.toolkit.form.dto.form.data;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FormDataDto implements Serializable {
    private static final long serialVersionUID = -4600696851108861021L;

    private Long formId;

    private Long dataId;

    private List<Long> ids;


}
