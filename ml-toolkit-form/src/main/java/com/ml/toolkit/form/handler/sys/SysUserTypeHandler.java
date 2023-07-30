package com.ml.toolkit.form.handler.sys;

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
        Long id = rs.getLong(columnName);
        SimpleUser user = new SimpleUser();
        user.setId(id);
        // 其他属性的处理，根据实际情况设置其他属性
        return user;
    }

    @Override
    public SimpleUser getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Long id = rs.getLong(columnIndex);
        SimpleUser user = new SimpleUser();
        user.setId(id);
        // 其他属性的处理，根据实际情况设置其他属性
        return user;
    }

    @Override
    public SimpleUser getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Object obj = cs.getObject(columnIndex);
        SimpleUser user = new SimpleUser();
        user.setId(Long.parseLong(obj.toString()));
        // 其他属性的处理，根据实际情况设置其他属性
        return user;
    }
}
