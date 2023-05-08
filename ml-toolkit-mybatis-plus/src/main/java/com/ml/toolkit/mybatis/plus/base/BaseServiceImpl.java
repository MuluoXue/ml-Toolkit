package com.ml.toolkit.mybatis.plus.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.io.Serializable;

/**
 * 通用service实现类
 *
 * @author ml
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends Serializable> extends ServiceImpl<M, T> implements BaseService<T> {

}
