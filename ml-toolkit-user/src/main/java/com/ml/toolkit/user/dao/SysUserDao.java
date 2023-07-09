package com.ml.toolkit.user.dao;

import com.ml.toolkit.mybatis.plus.base.BaseDao;
import com.ml.toolkit.user.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ml
 * @date 2022年12月21日 21:48
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUser> {

    List<SysUser> listByEntity(@Param("user") SysUser user);
}
