package com.ml.toolkit.mybatis.plus.demo;

import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ml
 * @date 2023年05月06日 22:44
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DemoServiceImpl extends BaseServiceImpl<DemoDao, Demo> implements DemoService {

}
