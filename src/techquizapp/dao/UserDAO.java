/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.User;

/**
 *
 * @author tasmi
 */
public class UserDAO {
    public static boolean validateUser(User user)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUsertype());
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
   
    public static String getPassword(String userid,String usertype)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select password from users where userid=? and usertype=?");
        ps.setString(1,userid);
        ps.setString(2, usertype);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return (rs.getString(1));
    }
    
    public static boolean updatePassword(String userid,String password,String usertype)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update users set password=? where userid=? and usertype=?");
        ps.setString(1,password);
        ps.setString(2,userid);
        ps.setString(3, usertype);
        int ans=ps.executeUpdate();
        return (ans==1);
    }
    public static boolean userIdExists(String userid)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=?");
        ps.setString(1,userid);
        ResultSet rs=ps.executeQuery();
        return (rs.next());
    }
    public static boolean addUser(String userid,String password,String usertype)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?)");
        ps.setString(1,userid);
        ps.setString(2,password);
        ps.setString(3,usertype);
        int ans=ps.executeUpdate();
        return (ans==1);
    }
}
