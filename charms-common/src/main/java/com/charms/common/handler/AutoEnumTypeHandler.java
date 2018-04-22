package com.charms.common.handler;

import com.charms.common.enums.BaseCodeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoEnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {
    private BaseTypeHandler typeHandler = null;

    public AutoEnumTypeHandler(Class<E> type) {
        if(type == null){
            throw new IllegalArgumentException("Type can not be null");
        }
        if(BaseCodeEnum.class.isAssignableFrom(type)){
            typeHandler = new CodeEnumTypeHandler(type);
        }else {
            typeHandler = new EnumTypeHandler<>(type);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        typeHandler.setNonNullParameter(preparedStatement,i,e,jdbcType);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {

        return (E)typeHandler.getNullableResult(resultSet,s);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {

        return (E)typeHandler.getNullableResult(resultSet,i);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {

        return (E)typeHandler.getNullableResult(callableStatement,i);
    }
}
