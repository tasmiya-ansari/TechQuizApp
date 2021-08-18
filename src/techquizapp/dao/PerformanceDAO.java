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
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScore;

/**
 *
 * @author tasmi
 */
public class PerformanceDAO {
    public static void addPerformance(Performance p)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into performance values(?,?,?,?,?,?,?)");
        ps.setString(1,p.getUserId());
        ps.setString(2,p.getExamId());
        ps.setInt(3,p.getRight());
        ps.setInt(4,p.getWrong());
        ps.setInt(5,p.getUnattempted());
        ps.setDouble(6,p.getPer());
        ps.setString(7,p.getLang());
        ps.executeUpdate();
        }
    
     public static ArrayList<Performance> getAllData()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ArrayList<Performance> performanceList=new ArrayList<>();
        ResultSet rs=st.executeQuery("select * from performance");
        while(rs.next())
        {
          String userid=rs.getString(1);
          String examid=rs.getString(2);
          int right=rs.getInt(3);
          int wrong=rs.getInt(4);
          int unattempted=rs.getInt(5);
          double percentage=rs.getDouble(6);
          String language=rs.getString(7);
          Performance p=new Performance(userid,examid,right,wrong,unattempted,percentage, language);
          performanceList.add(p);
        }
        return performanceList;
    }
      public static ArrayList<String> getAllStudentId()throws SQLException
      {
          Connection conn=DBConnection.getConnection();
          Statement st=conn.createStatement();
          ArrayList<String> studentIdList=new ArrayList<>();
          ResultSet rs=st.executeQuery("select distinct userid from performance");//qk ek student ne ek e zyada test diye honge
          while(rs.next())
          {
            String id=rs.getString(1);
            studentIdList.add(id);
          }
          return studentIdList;
      }
      
      public static ArrayList<String> getAllExamId(String studentid)throws SQLException
        {
          Connection conn=DBConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement("select examid from performance where userid=?");//examid is being pulled on the basis of userid thus iteself unique
          ps.setString(1,studentid);
          ArrayList<String> examIdList=new ArrayList<>();
          ResultSet rs=ps.executeQuery();
          while(rs.next())
          {
            String id=rs.getString(1);
            examIdList.add(id);
          }
          return examIdList;
      }
      public static StudentScore getScore(String studentid,String examid)throws SQLException
      {
          Connection conn=DBConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement("select language,per from performance where userid=? and examid=?");//examid is being pulled on the basis of userid thus iteself unique
          ps.setString(1,studentid);
          ps.setString(2, examid);
          ResultSet rs=ps.executeQuery();
          rs.next();//guarantee hai rec milega hi db se hi to pull kr rhe h
          StudentScore obj=new StudentScore();
          obj.setLanguage(rs.getString(1));
          obj.setPer(rs.getDouble(2));
          return obj;
      }
}
    
