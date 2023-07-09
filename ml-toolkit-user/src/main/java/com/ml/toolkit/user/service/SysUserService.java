package com.ml.toolkit.user.service;

import com.ml.toolkit.mybatis.plus.base.BaseService;
import com.ml.toolkit.user.domain.SysUser;

/**
 * @author ml
 * @date 2022年12月21日 21:49
 */
public interface SysUserService extends BaseService<SysUser> {

    void register(SysUser user);

    /**
     * 用户登录
     * @param user 登录对象
     * @return 成功登录后的信息
     */
    SysUser login(SysUser user);
}
