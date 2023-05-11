package com.ml.toolkit.form.service;

import com.ml.toolkit.form.dao.FormDao;
import com.ml.toolkit.form.domain.Form;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author ml
 * @date 2023年05月11日 20:34
 */
@Service
public class FormServiceImpl extends BaseServiceImpl<FormDao, Form> implements FormService{
}
