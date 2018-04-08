package com.charms.common.handler;

import com.charms.common.enums.BaseCodeEnum;
import com.charms.common.utils.CodeEnumUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeEnumTypeHandler<E extends Enum<?> & BaseCodeEnum> extends BaseTypeHandler<BaseCodeEnum> {
    private Class<E> type;

    public CodeEnumTypeHandler(Class<E> type) {
        if(type == null){
            throw new IllegalArgumentException("type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, BaseCodeEnum baseCodeEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,baseCodeEnum.getCode());
    }

    @Override
    public BaseCodeEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {

        return resultSet.wasNull() ? null : codeOf(resultSet.getInt(s));
    }

    @Override
    public BaseCodeEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {

        return resultSet.wasNull() ? null : codeOf(resultSet.getInt(i));
    }

    @Override
    public BaseCodeEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {

        return callableStatement.wasNull() ? null : codeOf(callableStatement.getInt(i));
    }

    private E codeOf(int code){
        try{
            return CodeEnumUtil.codeOf(type,code);
        }catch (Exception ex){
            throw new IllegalArgumentException("Cannot convert " + code + "to " + type.getSimpleName() + " by code value.",ex);
        }
    }
}
