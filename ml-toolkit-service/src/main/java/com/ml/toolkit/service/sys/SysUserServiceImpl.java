package com.ml.toolkit.service.sys;

import com.ml.toolkit.common.generate.LongIdGenerator;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.dao.sys.SysUserDao;
import com.ml.toolkit.domain.sys.SysUser;
import com.ml.toolkit.exception.sys.UserException;
import com.ml.toolkit.exception.sys.UserResultCode;
import com.ml.toolkit.mybatis.plus.base.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ml
 * @date 2022年12月21日 21:50
 */
@Slf4j
@Component
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;


    @Override
    public void register(SysUser user) {
        user.setStatus(0);
        user.setId(LongIdGenerator.generate());
        user.setCreateTime(new Date());
        sysUserDao.insert(user);
    }

    @Override
    public SysUser login(SysUser user) {
        List<SysUser> sysUsers = sysUserDao.listByEntity(user);
        if (ObjectUtil.isEmpty(sysUsers)) {
            throw new UserException(UserResultCode.ACCOUNT_NOT_FIND);
        }
        SysUser sysUser = sysUsers.get(0);
        if (!sysUser.getPassword().equalsIgnoreCase(user.getPassword())) {
            throw new UserException(UserResultCode.PASSWORD_ERROR);
        }
        if (sysUser.isDisable()) {
            throw new UserException(UserResultCode.ACCOUNT_DISABLE);
        }
        return sysUser;
    }
}
