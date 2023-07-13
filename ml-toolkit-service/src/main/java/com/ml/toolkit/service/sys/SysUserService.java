package com.ml.toolkit.service.sys;

import com.ml.toolkit.domain.sys.SysUser;
import com.ml.toolkit.mybatis.plus.base.BaseService;

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
