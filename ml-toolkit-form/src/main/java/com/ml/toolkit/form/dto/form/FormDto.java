package com.ml.toolkit.form.dto.form;

import com.ml.toolkit.form.dto.form.field.FormFieldDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FormDto implements Serializable {
    private static final long serialVersionUID = -4033023141994444630L;

    private String name;

    private List<FormFieldDto> formFieldList;
}
