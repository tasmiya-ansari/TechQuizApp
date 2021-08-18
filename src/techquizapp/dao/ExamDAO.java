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
import techquizapp.pojo.Exam;

/**
 *
 * @author tasmi
 */
public class ExamDAO {
    public static String getExamId()throws SQLException
    {
        int count;
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select count(*) from exam ");//agr table blank bhi hui to 0 milega thus rs empty nhi hoga
        rs.next();//qk rs kbhi bhi empty nhi hoga
        count=rs.getInt(1);
        String newId="EX-"+(count+1);
        return newId;
    }
    public static boolean addExam(Exam exam)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into exam values(?,?,?)");
        ps.setString(1,exam.getExamId());
        ps.setString(2,exam.getLang());
        ps.setInt(3,exam.getTotQues());
        int ans=ps.executeUpdate();
        return ans==1;
    }
    
    public static ArrayList<String> getExamIdBySubject(String subject)throws SQLException{
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("Select examid from exam where language=?");
       ps.setString(1,subject);
       ResultSet rs=ps.executeQuery();
       ArrayList<String> examIdList=new ArrayList<>();
       while(rs.next())
       {
           examIdList.add(rs.getString(1));
       }
       return examIdList;
    }
    
    public static int getQuestionCountByExam(String examId)throws SQLException{
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("Select total_questions from exam where examid=?");
       ps.setString(1,examId);
       ResultSet rs=ps.executeQuery();
       rs.next();//false ho hi nhi skta
       return  rs.getInt(1);
    }
    
    public static boolean isPaperSet(String subject)throws SQLException{
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("Select examid from exam where language=?");//or select 1 from exam where language=?
       ps.setString(1,subject);
       ResultSet rs=ps.executeQuery();
       return  rs.next();
    }
    
    public static ArrayList<String> getExamIdBySubject(String userid,String subject)throws SQLException{
        String qry="Select examid from exam where language=? minus select examid from performance where userId=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,subject);
        ps.setString(2,userid);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examIdList=new ArrayList<>();
        while(rs.next())
        {
            examIdList.add(rs.getString(1));
        }
        return  examIdList;
    }
}
