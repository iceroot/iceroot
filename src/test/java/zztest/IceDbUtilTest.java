package zztest;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.icexxx.util.IceDbUtil;

public class IceDbUtilTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/test";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "root";
        Connection connection = IceDbUtil.getConnection(driver, url, username, password);
        System.out.println(connection);
        String sql = "select * from t_test";
        // Object params;
        List<Map<String, Object>> query = IceDbUtil.query(connection, sql);
        for (int i = 0; i < query.size(); i++) {
            Map<String, Object> map = query.get(i);
            System.out.println(map);
        }
        String sql2 = "select * from t_user";
        // Object params;
        List<Map<String, Object>> query2 = IceDbUtil.query(connection, sql2);
        for (int i = 0; i < query2.size(); i++) {
            Map<String, Object> map = query2.get(i);
            System.out.println(map);
        }
        connection = IceDbUtil.getConnection(driver, url, username, password);
        Long count = IceDbUtil.count(connection, "t_test", false);
        Long count2 = IceDbUtil.count(connection, "t_user", false);
        System.out.println(count);
        System.out.println(count2);
    }
}
