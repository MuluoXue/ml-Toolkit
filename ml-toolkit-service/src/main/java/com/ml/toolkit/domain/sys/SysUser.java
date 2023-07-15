package com.ml.toolkit.domain.sys;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private String name;

    /**
     *  账号
     */
    @NotNull
    @Email
    private String account;

    /**
     * 密码
     */
    @NotNull
    private String password;

    /**
     * 状态 0正常， 1 禁用
     */
    private int status;

    public boolean isDisable() {
        return this.status == 1;
    }

}
