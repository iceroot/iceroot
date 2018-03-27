package com.icexxx.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作相关工具类
 * 
 * @author IceWater
 * @version 1.0
 */
public class IceDbUtil {
    /**
     * 获取数据库连接
     * 
     * @param driver 数据库驱动名称
     * @param url 数据库url
     * @param username 用户名
     * @param password 密码
     * @return 获取的数据库连接
     * @since 1.0
     */
    public static Connection getConnection(String driver, String url, String username, String password) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("数据库驱动jar包无法加载");
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(driver, username, password);
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            if (errorMessage.indexOf("No suitable driver found for com.mysql.jdbc.Driver") != -1) {
                if (url.indexOf("?") != -1) {
                    url = url.substring(0, url.indexOf("?"));
                }
                url = url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8";
                try {
                    connection = DriverManager.getConnection(url);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return connection;
    }

    /**
     * 执行sql语句
     * 
     * @param connection 数据库连接
     * @param sql 需要执行的sql语句
     * @param isClose 是否关闭连接
     * @return 成功执行的sql条数
     * @since 1.0
     */
    public static int exeSql(Connection connection, String sql, boolean isClose) {
        Statement createStatement = null;
        int executeUpdate = 0;
        try {
            sql = sql.replace("&lt;", "<");
            sql = sql.replace("&gt;", ">");
            sql = sql.replace("&amp;", "&");
            sql = sql.replace("&quot;", "\"");
            sql = sql.replace("&apos;", "'");
            createStatement = connection.createStatement();
            executeUpdate = createStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (createStatement != null) {
                try {
                    createStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return executeUpdate;
    }

    /**
     * 执行sql语句
     * 
     * @param connection 数据库连接
     * @param sql 需要执行的sql
     * @param params sql中的参数
     * @param isClose 是否关闭连接
     * @return 执行成功的条数
     * @since 1.0
     */
    public static int exeSql(Connection connection, String sql, Object[] params, boolean isClose) {
        PreparedStatement prepareStatement = null;
        int executeUpdate = 0;
        try {
            sql = sql.replace("&lt;", "<");
            sql = sql.replace("&gt;", ">");
            sql = sql.replace("&amp;", "&");
            sql = sql.replace("&quot;", "\"");
            sql = sql.replace("&apos;", "'");
            prepareStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                Object param = params[i];
                if (param instanceof String) {
                    prepareStatement.setString(i + 1, (String) param);
                } else if (param instanceof Integer) {
                    prepareStatement.setInt(i + 1, (Integer) param);
                } else if (param instanceof Long) {
                    prepareStatement.setLong(i + 1, (Long) param);
                } else if (param instanceof Boolean) {
                    prepareStatement.setBoolean(i + 1, (Boolean) param);
                } else if (param instanceof java.sql.Date) {
                    prepareStatement.setDate(i + 1, (java.sql.Date) param);
                } else if (param instanceof Date) {
                    prepareStatement.setDate(i + 1, new java.sql.Date(((Date) param).getTime()));
                } else if (param instanceof Double) {
                    prepareStatement.setDouble(i + 1, (Double) param);
                } else if (param instanceof Byte) {
                    prepareStatement.setByte(i + 1, (Byte) param);
                } else if (param instanceof Short) {
                    prepareStatement.setShort(i + 1, (Short) param);
                }
            }
            prepareStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return executeUpdate;
    }

    /**
     * 执行查询
     * 
     * @param connection 数据库连接
     * @param sql SQL语句
     * @param isClose 是否关闭连接
     * @param params SQL语句参数
     * @return 查询结果
     * @since 2.0
     */
    public static List<Map<String, Object>> query(Connection connection, String sql, boolean isClose,
            Object... params) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        PreparedStatement prepareStatement = null;
        try {
            sql = sql.replace("&lt;", "<");
            sql = sql.replace("&gt;", ">");
            sql = sql.replace("&amp;", "&");
            sql = sql.replace("&quot;", "\"");
            sql = sql.replace("&apos;", "'");
            prepareStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                Object param = params[i];
                if (param instanceof String) {
                    prepareStatement.setString(i + 1, (String) param);
                } else if (param instanceof Integer) {
                    prepareStatement.setInt(i + 1, (Integer) param);
                } else if (param instanceof Long) {
                    prepareStatement.setLong(i + 1, (Long) param);
                } else if (param instanceof Boolean) {
                    prepareStatement.setBoolean(i + 1, (Boolean) param);
                } else if (param instanceof java.sql.Date) {
                    prepareStatement.setDate(i + 1, (java.sql.Date) param);
                } else if (param instanceof Date) {
                    prepareStatement.setDate(i + 1, new java.sql.Date(((Date) param).getTime()));
                } else if (param instanceof Double) {
                    prepareStatement.setDouble(i + 1, (Double) param);
                } else if (param instanceof Byte) {
                    prepareStatement.setByte(i + 1, (Byte) param);
                } else if (param instanceof Short) {
                    prepareStatement.setShort(i + 1, (Short) param);
                }
            }
            ResultSet executeQuery = prepareStatement.executeQuery();
            ResultSetMetaData metaData = executeQuery.getMetaData();
            while (executeQuery.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    Object value = null;
                    try {
                        value = executeQuery.getObject(columnLabel);
                    } catch (SQLException e) {
                        String message = e.getMessage();
                        if ("Value '0000-00-00' can not be represented as java.sql.Date".equals(message)) {
                            value = null;
                        }
                    }
                    map.put(columnLabel, value);
                }
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (isClose) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 查询表的总记录数
     * 
     * @param connection 数据库连接
     * @param tableName 表名称
     * @param isClose 是否关闭连接
     * @return 记录总数
     * @since 2.0
     */
    public static Long count(Connection connection, String tableName, boolean isClose) {
        PreparedStatement prepareStatement = null;
        try {
            String sql = "select count(*) as cou from " + tableName;
            prepareStatement = connection.prepareStatement(sql);
            ResultSet executeQuery = prepareStatement.executeQuery();
            ResultSetMetaData metaData = executeQuery.getMetaData();
            if (executeQuery.next()) {
                Long coun = executeQuery.getLong(metaData.getColumnLabel(1));
                return coun;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (isClose) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 获取表中列的元数据
     * 
     * @param connection 数据库连接
     * @param tableName 表名称
     * @param isClose 是否关闭数据库连接
     * @return 获取的数据库表列的元信息
     */
    public static IceTable metaColumn(Connection connection, String tableName, boolean isClose) {
        PreparedStatement prepareStatement = null;
        try {
            DatabaseMetaData metaDataConnection = connection.getMetaData();
            String databaseName = metaDataConnection.getDatabaseProductName();
            String sql = "select * from " + tableName + " limit 1";
            if ("oracle".equalsIgnoreCase(databaseName)) {
                sql = "select * from " + tableName + " where rownum <= 1";
            } else if (databaseName.toLowerCase().contains("sqlserver")) {
                sql = "select top 1 * from " + tableName;
            }
            String sqlMeta = "select TABLE_NAME,COLUMN_NAME,COLUMN_COMMENT from information_schema.columns where TABLE_NAME='"
                    + tableName + "'";
            PreparedStatement prepareStatementMeta = null;
            Map<String, String> remarkMap = new HashMap<String, String>();

            try {
                prepareStatementMeta = connection.prepareStatement(sqlMeta);
                ResultSet executeQueryMeta = prepareStatementMeta.executeQuery();
                while (executeQueryMeta.next()) {
                    String key = executeQueryMeta.getString("COLUMN_NAME");
                    String value = executeQueryMeta.getString("COLUMN_COMMENT");
                    remarkMap.put(key, value);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (prepareStatementMeta != null) {
                    try {
                        prepareStatementMeta.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            prepareStatement = connection.prepareStatement(sql);
            ResultSet executeQuery = prepareStatement.executeQuery();
            ResultSetMetaData metaData = executeQuery.getMetaData();
            IceTable iceTable = new IceTable();
            iceTable.setTableName(tableName);
            List<IceColumn> columnList = new ArrayList<IceColumn>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnLabel = metaData.getColumnLabel(i);
                String columnTypeName = metaData.getColumnTypeName(i);
                int columnType = metaData.getColumnType(i);
                int columnDisplaySize = metaData.getColumnDisplaySize(i);
                int scale = metaData.getScale(i);
                String columnClassName = metaData.getColumnClassName(i);
                String tableNameExtraction = metaData.getTableName(i);
                String schemaName = metaData.getSchemaName(i);
                String catalogName = metaData.getCatalogName(i);
                int precision = metaData.getPrecision(i);
                int nullable = metaData.isNullable(i);
                String remark = remarkMap.get(columnName);
                IceColumn iceColumn = new IceColumn();
                iceColumn.setColumnName(columnName);
                iceColumn.setColumnLabel(columnLabel);
                iceColumn.setColumnTypeName(columnTypeName);
                iceColumn.setColumnType(columnType);
                iceColumn.setColumnDisplaySize(columnDisplaySize);
                iceColumn.setColumnCount(columnCount);
                iceColumn.setScale(scale);
                iceColumn.setColumnClassName(columnClassName);
                iceColumn.setTableName(tableNameExtraction);
                iceColumn.setSchemaName(schemaName);
                iceColumn.setCatalogName(catalogName);
                iceColumn.setPrecision(precision);
                iceColumn.setRemark(remark);
                iceColumn.setNullable(nullable == 1 ? true : false);
                columnList.add(iceColumn);
            }

            iceTable.setColumnList(columnList);
            return iceTable;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prepareStatement != null) {
                try {
                    prepareStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (isClose) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 
     * @param connection 数据库连接
     * @param sql sql语句
     * @return 执行条数
     * @since 2.0
     */
    public static int exeSql(Connection connection, String sql) {
        return exeSql(connection, sql, false);
    }

    /**
     * 
     * @param connection 数据库连接
     * @param sql sql语句
     * @param params sql语句参数
     * @return 执行条数
     * @since 2.0
     */
    public static int exeSql(Connection connection, String sql, Object[] params) {
        return exeSql(connection, sql, params, false);
    }

    /**
     * 
     * @param connection 数据库连接
     * @param sql sql语句
     * @param params sql语句参数
     * @return 查询结果
     * @since 2.0
     */
    public static List<Map<String, Object>> query(Connection connection, String sql, Object... params) {
        return query(connection, sql, false, params);
    }

    /**
     * 
     * @param connection 数据库连接
     * @param tableName 表名称
     * @return 表记录数
     * @since 2.0
     */
    public static Long count(Connection connection, String tableName) {
        return count(connection, tableName, false);
    }

    /**
     * 获取表中列的元数据
     * 
     * @param connection 数据库连接
     * @param tableName 表名称
     * @return 获取的表的元信息
     * @since 2.0
     */
    public static IceTable metaColumn(Connection connection, String tableName) {
        return metaColumn(connection, tableName, false);
    }

    /**
     * 关闭连接
     * 
     * @param connection 数据库连接
     * @since 2.0
     */
    public void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建数据库
     * 
     * @param databaseName 数据库名称
     * @param username 用户名
     * @param password 密码
     * @param url url
     * @param driver 数据库驱动类名
     * @return 是否创建成功
     * @since 2.1
     */
    public static boolean createDatabase(String databaseName, String username, String password, String url,
            String driver) {
        if (databaseName == null || "".equals(databaseName)) {
            return false;
        }
        databaseName = databaseName.replaceAll("\\s+", "");
        databaseName = databaseName.replace("\"", "");
        databaseName = databaseName.replace("'", "");
        String sql = "CREATE DATABASE ${databaseName} DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci";
        sql = sql.replace("${databaseName}", databaseName);
        if (!url.startsWith("jdbc:mysql://")) {
            url = "jdbc:mysql://" + url;
        }
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            boolean execute = statement.execute(sql);
            return execute;
        } catch (SQLException e) {
            String message = e.getMessage();
            if (message.startsWith("Can't create database ") && message.endsWith("database exists")) {
                return true;
            } else {
                e.printStackTrace();
                return false;
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
