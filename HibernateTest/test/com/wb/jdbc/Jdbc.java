package com.wb.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class Jdbc {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static String url;
    
    public static String user;
    
    public static String pwd;
    
    public static String driver;
    
    public static Connection conn;
    
    public static PreparedStatement pst;
    
    public static ResultSet rs;
    
    static
    {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/self";
        user = "root";
        pwd = "";
    }
    
    @BeforeClass
    public static void start()
    {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @AfterClass
    public static void end()
    {
        try {
            if(!pst.isClosed())
                pst.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if(!conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    @Ignore
    @Test
    public void sqlYearTest() throws SQLException
    {
        String sql = "select * from person where year(person_bir)>100";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next())
        {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            Date date = rs.getTimestamp(7);         //..getDate返回年月日，返回的是java.sql的Date，getTime返回时分秒，getTimestamp返回年月日时分秒。
            System.out.println(id + ", " + name + ", " + age + ", " + date);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        }
    }
    
    @Ignore
    @Test
    public void sqlTest() throws SQLException
    {
        String sql = "select * from person";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next())
        {
            String id = rs.getString(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            System.out.println(id + ", " + name + ", " + age);
        }
    }
    
    @Ignore
    @Test
    public void leftJoinTest() throws SQLException
    {
        String sql = "select * from person as a left join planet as b on a.planet_id=b.planet_id where a.person_id>5 order by a.person_id desc";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next())
        {
            String id = rs.getString(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            String tel = rs.getString(4);
            String sex = rs.getString(5);
            int pid = rs.getInt(6);
            int plid = rs.getInt(7);
            String plname = rs.getString(8);
            int plage = rs.getInt(9);
            System.out.println(id + ", " + name + ", " + age + ", "
                    + tel + ", " + sex + ", " + pid + ", " + plid + ", "
                    + plname + ", " + plage);
        }
    }
}









@Deprecated
class JdbcUtil
{

    public static String url;
    
    public static String user;
    
    public static String pwd;
    
    public static String driver;
    
    public static Connection conn;
    
    public static PreparedStatement pst;
    
    static
    {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost/self";
        user = "root";
        pwd = "";
    }
    
    public void start(String sql)
    {
        try {
            if (conn.isValid(1)) {
                pst = conn.prepareStatement(sql);
            } else {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pwd);
                pst = conn.prepareStatement(sql);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void end()
    {
        try {
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            if(!pst.isClosed())
//                pst.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        try {
//            if(!conn.isClosed())
//                conn.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
    
}
