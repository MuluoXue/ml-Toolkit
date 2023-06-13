package com.ml.toolkit.log.service.impl;

import com.ml.toolkit.log.dao.BaseLogDao;
import com.ml.toolkit.log.domain.BaseLog;
import com.ml.toolkit.log.service.BaseLogService;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class BaseLogServiceImpl extends BaseServiceImpl<BaseLogDao, BaseLog> implements BaseLogService {


}
