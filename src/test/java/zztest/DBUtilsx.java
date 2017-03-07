package zztest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtilsx {
private static DBUtilsx d = new DBUtilsx();
private static Properties p = new Properties();
static{
//try {
//p.load(d.getClass().getResourceAsStream("init.properties"));
//} catch (IOException e) {
//System.out.println("加载配置文件的时候出错了" + e.getMessage());
//}
}
public static void main(String[] args) {
	System.out.println(getConnection());
}
/**
 * 与数据库建立链接
 */
public static Connection getConnection(){
Connection con = null;
String dbtype= "mysql";
String dbname = "test";
String username = "root";
String password = "root";
String ip = "120.77.168.244";
String port ="3306";
if(dbtype.equalsIgnoreCase("oracle")){
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
System.out.println("驱动类未找到，注意：驱动包是否导入了" + e.getMessage());
} 
String url="jdbc:oracle:thin:@"+ip+":"+port+":"+dbname; 
try {
con = DriverManager.getConnection(url,username,password);
} catch (SQLException e) {
System.out.println("数据库链接失败，配置项有异常" + e.getMessage());
} 
}
if(dbtype.equalsIgnoreCase("mysql")){
try {
Class.forName("org.gjt.mm.mysql.Driver");
} catch (ClassNotFoundException e) {
System.out.println("驱动类未找到，注意：驱动包是否导入了" + e.getMessage());
} 
String url ="jdbc:mysql://"+ip+":"+port+"/"+dbname+"?user="+username+"&password="+password+"&useUnicode=true&characterEncoding=utf-8" ;
//myDB为数据库名 
try {
con = DriverManager.getConnection(url);
} catch (SQLException e) {
System.out.println("数据库链接失败，配置项有异常" + e.getMessage());
} 
}
if(dbtype.equalsIgnoreCase("sqlserver")){
try {
Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
} catch (ClassNotFoundException e) {
System.out.println("驱动类未找到，注意：驱动包是否导入了" + e.getMessage());
} 
String url="jdbc:microsoft:sqlserver://"+ip+":"+port+";DatabaseName="+dbname; 
try {
con= DriverManager.getConnection(url,username,password);
} catch (SQLException e) {
System.out.println("数据库链接失败，配置项有异常" + e.getMessage());
} 
}
System.out.println(con);
return con;

}
/**
 * 断开与数据库的链接
 */
public static void close(Connection con,PreparedStatement pstam,ResultSet rs){
if(con != null){
try {
con.close();
} catch (SQLException e) {
System.out.println(e.getMessage());
}
}
if(pstam != null){
try {
pstam.close();
} catch (SQLException e) {
System.out.println(e.getMessage());
}
}
if(rs != null){
try {
rs.close();
} catch (SQLException e) {
System.out.println(e.getMessage());
}
}
}
}
