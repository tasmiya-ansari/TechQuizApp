/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;
/**
 *
 * @author tasmi
 */
public class Question {
    private String examId;
    private int quesno;
    private String ques;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String correctAns;
    private String lang;

    public Question() {
    }

    public Question(String examId, int quesno, String ques, String ans1, String ans2, String ans3, String ans4, String correctAns, String lang) {
        this.examId = examId;
        this.quesno = quesno;
        this.ques = ques;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.correctAns = correctAns;
        this.lang = lang;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getQuesno() {
        return quesno;
    }

    public void setQuesno(int qno) {
        this.quesno = quesno;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Question{" + "examId=" + examId + ", quesno=" + quesno + ", ques=" + ques + ", ans1=" + ans1 + ", ans2=" + ans2 + ", ans3=" + ans3 + ", ans4=" + ans4 + ", correctAns=" + correctAns + ", lang=" + lang + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
                Question other = (Question) obj;
        if (this.examId.equals(other.examId)==false) {
            return false;
        }
        if (this.quesno != other.quesno) {
            return false;
        }
        if (this.ques.equals(other.ques)==false) {
            return false;
        }
        if (this.ans1.equals(other.ans1)==false) {
            return false;
        }
        if (this.ans2.equals(other.ans2)==false) {
            return false;
        }
        if (this.ans3.equals(other.ans3)==false) {
            return false;
        }
        if (this.ans4.equals(other.ans4)==false) {
            return false;
        }
        if (this.correctAns.equals(other.correctAns)==false) {
            return false;
        }
        return true;
    }  
    
}

    
    
    
   
