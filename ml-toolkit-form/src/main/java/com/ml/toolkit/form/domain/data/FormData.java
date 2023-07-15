package com.ml.toolkit.form.domain.data;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ml.toolkit.form.domain.base.FormBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormData extends FormBaseEntity {
    private static final long serialVersionUID = -652004015884665686L;

    private Long formId;

    @TableField(exist = false)
    private List<FormDataDetail> formDataDetailList;

}
