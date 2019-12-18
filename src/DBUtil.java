

import java.sql.*;
import java.util.*;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/vip?useUnicode=true&characterEncoding=UTF-8";
    private static final String NAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws Exception {

//        System.out.println(add_vip("223", "2", "12", "23", "232"));
        update_vip("1","asd ");
    }

    public static boolean login(String username, String password) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("select * from 管理员表 where 姓名 = ? and 密码 = ?");//创建准备语句对象

        pstmt.setString(1, username);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(2, password);//并且性别为男
        ResultSet rs = pstmt.executeQuery();
        //ResultSet rs = stmt.executeQuery();//选择import java.sql.ResultSet;
        while (rs.next()) {//如果对象中有数据，就会循环打印出来
            System.out.println(rs.getString("username"));
            return true;
        }
        return false;
    }

    public static boolean register(String username, String password, String phone, String sex, String id_card) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("insert into 管理员表 (姓名, 密码, 电话, 性别, 身份证) values (?, ?, ?, ?, ?)");//创建准备语句对象

        pstmt.setString(1, username);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(2, password);
        pstmt.setString(3, phone);
        pstmt.setString(4, sex);
        pstmt.setString(5, id_card);
        pstmt.executeUpdate();

        return true;
    }
    public static boolean add_vip(String name, String sex, String birthday, String id_card, String phone) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("insert into 会员信息表 (姓名, 性别, 出生日期, 身份证号, 电话) values (?, ?, ?, ?, ?)");//创建准备语句对象

        pstmt.setString(1, name);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(2, sex);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(3, birthday);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(4, id_card);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(5, phone);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.executeUpdate();

        return true;
    }
    public static Map<String, String>  query_vip_by_name(String name) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("select * from 会员信息表 where name = ? ");//创建准备语句对象

        pstmt.setString(1, name);//查询条件，名字以“小”开头。%通配符，指示所有。
        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int fieldCount = rsmd.getColumnCount();
        //ResultSet rs = stmt.executeQuery();//选择import java.sql.ResultSet;
        Map<String, String> valueMap = new LinkedHashMap<String, String>();
        while (rs.next()) {//如果对象中有数据，就会循环打印出来
            for (int i = 1; i <= fieldCount; i++)
            {

                String fieldName = rsmd.getColumnName(i);
                String field = rs.getString(i);
                valueMap.put(fieldName, field);

//                System.out.println(fieldName);
//                System.out.println(field);
//                System.out.println(valueMap.get(fieldName));
            }
            break;
        }
        return valueMap;
    }
    public static boolean delete_vip(String id) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("delete from 会员信息表 where id = ?");//创建准备语句对象

        pstmt.setString(1, id);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.executeUpdate();

        return true;
    }

    public static boolean update_vip(String id, String name) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("update 会员信息表 set name = ? where id = ? ");//创建准备语句对象

        pstmt.setString(1, name);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(2, id);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.executeUpdate();

        return true;
    }
    public static boolean add_service(String name, String money) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("insert into service (name, money) values (?, ?)");//创建准备语句对象

        pstmt.setString(1, name);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(2, money);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.executeUpdate();

        return true;
    }
    public static boolean delete_service(String id) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("delete from service where id = ?");//创建准备语句对象

        pstmt.setString(1, id);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.executeUpdate();
        return true;
    }
    public static boolean update_service(String id, String money) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("update service set money = ? where id = ? ");//创建准备语句对象

        pstmt.setString(1, money);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(2, id);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.executeUpdate();

        return true;
    }
    public static Map<String, String>  query_service_by_name(String name) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("select * from service where name = ? ");//创建准备语句对象

        pstmt.setString(1, name);//查询条件，名字以“小”开头。%通配符，指示所有。
        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int fieldCount = rsmd.getColumnCount();
        //ResultSet rs = stmt.executeQuery();//选择import java.sql.ResultSet;
        Map<String, String> valueMap = new LinkedHashMap<String, String>();
        while (rs.next()) {//如果对象中有数据，就会循环打印出来
            for (int i = 1; i <= fieldCount; i++)
            {

                String fieldName = rsmd.getColumnName(i);
                String field = rs.getString(i);
                valueMap.put(fieldName, field);

//                System.out.println(fieldName);
//                System.out.println(field);
//                System.out.println(valueMap.get(fieldName));
            }
            break;
        }
        return valueMap;
    }
    public static Map<String, String>  query_vip_by_name_sex_id_card(String name, String sex, String id_card) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("select * from vip where name = ? and sex =? and id_card = ? ");//创建准备语句对象

        pstmt.setString(1, name);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(2, sex);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(3, id_card);//查询条件，名字以“小”开头。%通配符，指示所有。

        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int fieldCount = rsmd.getColumnCount();
        //ResultSet rs = stmt.executeQuery();//选择import java.sql.ResultSet;
        Map<String, String> valueMap = new LinkedHashMap<String, String>();
        while (rs.next()) {//如果对象中有数据，就会循环打印出来
            for (int i = 1; i <= fieldCount; i++)
            {

                String fieldName = rsmd.getColumnName(i);
                String field = rs.getString(i);
                valueMap.put(fieldName, field);

//                System.out.println(fieldName);
//                System.out.println(field);
//                System.out.println(valueMap.get(fieldName));
            }
            break;
        }
        return valueMap;
    }
    public static Map<String, String>  query_admin_by_username_password(String username, String password) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库的连接
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查
        //Statement stmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
        PreparedStatement pstmt = conn.prepareStatement("select * from admin where username = ? and password =?");//创建准备语句对象

        pstmt.setString(1, username);//查询条件，名字以“小”开头。%通配符，指示所有。
        pstmt.setString(2, password);//查询条件，名字以“小”开头。%通配符，指示所有。

        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int fieldCount = rsmd.getColumnCount();
        //ResultSet rs = stmt.executeQuery();//选择import java.sql.ResultSet;
        Map<String, String> valueMap = new LinkedHashMap<String, String>();
        while (rs.next()) {//如果对象中有数据，就会循环打印出来
            for (int i = 1; i <= fieldCount; i++)
            {

                String fieldName = rsmd.getColumnName(i);
                String field = rs.getString(i);
                valueMap.put(fieldName, field);

//                System.out.println(fieldName);
//                System.out.println(field);
//                System.out.println(valueMap.get(fieldName));
            }
            break;
        }
        return valueMap;
    }
}