package com.ml.toolkit.form.dto.form.data;

import com.ml.toolkit.form.domain.PageEntity;
import com.ml.toolkit.form.domain.data.FormDataDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormDataDto extends PageEntity {
    private static final long serialVersionUID = -4600696851108861021L;

    private Long formId;

    private Long dataId;

    private List<Long> ids;

    private List<FormDataDetail> formDataDetailList;


}
