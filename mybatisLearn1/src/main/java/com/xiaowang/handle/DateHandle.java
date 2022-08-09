package com.xiaowang.handle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateHandle extends BaseTypeHandler<Date> {

    /**
     * 将java类型转换成数据库需要的类型
     * @param preparedStatement
     * @param i
     * @param date
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i,time);
    }

    /**
     * 后面三个方法讲数据库类型转换成java类型
     * @param resultSet  查询出的结果集
     * @param s 数据库表字段的名称
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
//        将结果集中需要的数据转换成date类型并返回
        long aLong = resultSet.getLong(s);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        //        将结果集中需要的数据转换成date类型并返回
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        //        将结果集中需要的数据转换成date类型并返回
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
}
