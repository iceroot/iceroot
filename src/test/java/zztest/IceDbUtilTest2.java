package zztest;

import java.sql.Connection;
import java.util.List;

import com.icexxx.util.IceColumn;
import com.icexxx.util.IceDbUtil;
import com.icexxx.util.IceTable;

public class IceDbUtilTest2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1/test";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "root";
        Connection connection = IceDbUtil.getConnection(driver, url, username, password);
        System.out.println(connection);
        String tableName = "t_test";
        IceTable query = IceDbUtil.metaColumn(connection, tableName, false);
        System.out.println(query);
        List<IceColumn> columnList = query.getColumnList();
        for (int i = 0; i < columnList.size(); i++) {
            System.out.println(columnList.get(i));
        }
    }
}
