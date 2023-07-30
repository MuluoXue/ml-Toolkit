package com.ml.toolkit.form.handler.form;

import com.ml.toolkit.form.domain.form.Form;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * SysUserTypeHandler
 */
@Slf4j
public class FormTypeHandler implements TypeHandler<Form> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Form parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter.getId());
    }

    @Override
    public Form getResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public Form getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Form getResult(CallableStatement cs, int columnIndex) throws SQLException {
        log.info("3");
        return null;
    }
}
