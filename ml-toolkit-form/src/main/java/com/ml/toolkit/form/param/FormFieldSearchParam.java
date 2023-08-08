package com.ml.toolkit.form.param;

import com.ml.toolkit.form.domain.PageEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hxd
 * @date 2023年08月08日 23:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FormFieldSearchParam extends PageEntity {

    private static final long serialVersionUID = 6325770184313533250L;

    private Long formId;

    private boolean noPage;
}
