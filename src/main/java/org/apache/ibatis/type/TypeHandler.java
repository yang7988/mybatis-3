/**
 * Copyright 2009-2015 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对应的sql语句的字段的java属性的类型处理器，其实现类为各基本类型、包装类型、对象类型处理器等
 * （IntegerTypeHandler、StringTypeHandler、ObjectTypeHandler、。。。）
 */
public interface TypeHandler<T> {

    /**
     * 为参数解析复制处理由各子类实现，例如IntegerTypeHandler#ps.setInt(i, parameter);
     *
     * @param ps        PreparedStatement
     * @param i         参数索引
     * @param parameter 参数值
     * @param jdbcType  参数对应的jdbc类型
     * @throws SQLException sql异常
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

    /**
     * 从ResultSet集合中获取值类型处理,例如例如IntegerTypeHandler#rs.getInt(columnName);
     *
     * @param rs         ResultSet
     * @param columnName 列名
     * @return 返回子类型处理的结果
     * @throws SQLException sql异常
     */
    T getResult(ResultSet rs, String columnName) throws SQLException;

    /**
     * 从ResultSet集合中获取值类型处理,例如例如IntegerTypeHandler#rs.getInt(columnIndex);
     *
     * @param rs          ResultSet
     * @param columnIndex 列所处的sql字段的索引
     * @return 返回子类型处理的结果
     * @throws SQLException sql异常
     */
    T getResult(ResultSet rs, int columnIndex) throws SQLException;

    /**
     * 从ResultSet集合中获取值类型处理,例如例如IntegerTypeHandler#rs.getInt(columnIndex);
     *
     * @param cs          CallableStatement
     * @param columnIndex 列所处的sql字段的索引
     * @return 返回子类型处理的结果
     * @throws SQLException sql异常
     */
    T getResult(CallableStatement cs, int columnIndex) throws SQLException;

}
