package zztest;

import static com.icexxx.util.IceTestUtil.print;

import java.sql.Connection;
import java.util.Date;

import org.junit.Test;

import com.icexxx.util.IceConst;
import com.icexxx.util.IceDbUtil;

public class Dbtest {
    @Test
    public void sql(){
    	String url="jdbc:mysql://120.77.168.244:3306/ice?useUnicode=true&characterEncoding=utf-8";
		String username="root";
		String password="root";
		Connection connection=IceDbUtil.getConnection(IceConst.MYSQL_DRIVER, url, username, password);
		String sql="update t_user set username=? where id=1";
		Object[] params=new Object[]{"hello你好"};
		int result=IceDbUtil.exeSql(connection, sql, params);
//		int result=IceDbUtil.exeSql(connection, sql);
		System.out.println("result="+result);
    }
}
