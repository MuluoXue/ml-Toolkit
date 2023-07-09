package com.ml.toolkit.user.domain;

import com.ml.toolkit.bean.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ml
 * @date 2022年12月21日 21:38
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = 1901362256556561803L;

    /**
     * 名称
     */
    private String name;

    /**
     *  账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态 0正常， 1 禁用
     */
    private int status;

    public boolean isDisable() {
        return this.status == 1;
    }

}
