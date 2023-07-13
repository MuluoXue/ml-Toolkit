package com.ml.toolkit.dao.sys;

import com.ml.toolkit.mybatis.plus.base.BaseDao;
import com.ml.toolkit.domain.sys.SysUser;
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
