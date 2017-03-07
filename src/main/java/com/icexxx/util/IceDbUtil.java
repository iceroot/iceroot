package com.icexxx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
/**
 * 数据库操作相关工具类
 * @author IceWater
 * @date 2017-03-03
 * @version 1.0
 */
public class IceDbUtil {
    /**
     * 获取数据库连接
     * @param driver 数据库驱动名称
     * @param url 数据库url
     * @param username 用户名
     * @param password 密码
     * @return
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
     * @param connection
     *            数据库连接
     * @param sql
     *            需要执行的sql语句
     * @return 成功执行的sql条数
     */
    public static int exeSql(Connection connection, String sql) {
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
     * @param connection
     *            数据库连接
     * @param sql
     *            需要执行的sql
     * @param params
     *            sql中的参数
     * @return 执行成功的条数
     */
    public static int exeSql(Connection connection, String sql, Object[] params) {
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
}
