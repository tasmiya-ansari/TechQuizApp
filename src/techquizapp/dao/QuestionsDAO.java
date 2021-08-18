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
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;

/**
 *
 * @author tasmi
 */
public class QuestionsDAO {
    public static void addQuestions(QuestionStore qstore)throws SQLException//bht sare questions h hr ek ko check nhi krenge isliye void
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into questions values(?,?,?,?,?,?,?,?,?)");
        ArrayList <Question>quesList=qstore.getAllQuestions();
        for (Question q:quesList)
        {
            ps.setString(1,q.getExamId());
            ps.setInt(2,q.getQuesno());
            ps.setString(3,q.getQues());
            ps.setString(4, q.getAns1());
            ps.setString(5, q.getAns2());
            ps.setString(6, q.getAns3());
            ps.setString(7, q.getAns4());
            ps.setString(8,q.getCorrectAns());
            ps.setString(9,q.getLang());
            ps.executeUpdate();
        }
    }
    
    public static ArrayList<Question> getQuestionsByExamId(String examId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from questions where examId=?");
        ps.setString(1,examId);
        ResultSet rs=ps.executeQuery();
        ArrayList<Question>quesList=new ArrayList<>();
        while(rs.next())
        {
            int quesno=rs.getInt(2);
            String ques=rs.getString(3);
            String ans1=rs.getString(4);
            String ans2=rs.getString(5);
            String ans3=rs.getString(6);
            String ans4=rs.getString(7);
            String correctAns=rs.getString(8);
            String lang=rs.getString(9);
            Question q=new Question(examId,quesno,ques,ans1,ans2,ans3,ans4,correctAns,lang);
            quesList.add(q);      
        }
        return quesList;
    }
    
    public static void updateQuestions(QuestionStore qstore)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        ArrayList <Question> questionList=qstore.getAllQuestions();
        PreparedStatement ps=conn.prepareStatement("update questions set question=?,answer1=?,answer2=?,answer3=?,answer4=?,correct_answer=? where examid=? and qno=?");
        for(Question q:questionList)
        {
           ps.setString(1,q.getQues());
           ps.setString(2,q.getAns1());
           ps.setString(3,q.getAns2());
           ps.setString(4,q.getAns3());
           ps.setString(5,q.getAns4());
           ps.setString(6,q.getCorrectAns());
           ps.setString(7,q.getExamId());
           ps.setInt(8,q.getQuesno());
           ps.executeUpdate();
        }
    }
}
