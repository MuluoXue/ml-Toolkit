package com.ml.toolkit.form.handler.sys;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.ml.toolkit.form.domain.sys.SimpleUser;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * SysUserTypeHandler
 */
public class SysUserTypeHandler extends BaseTypeHandler<SimpleUser> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SimpleUser parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter.getId());
    }

    @Override
    public SimpleUser getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public SimpleUser getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public SimpleUser getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
