/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

import java.util.Objects;

/**
 *
 * @author tasmi
 */
public class Answer {
    private int quesno;
    private String chosenAns;
    private String correctAns;
    private String examId;
    private String subject;

    public Answer() {
    }

    public Answer(int quesno, String chosenAns, String correctAns, String examId, String subject) {
        this.quesno = quesno;
        this.chosenAns = chosenAns;
        this.correctAns = correctAns;
        this.examId = examId;
        this.subject = subject;
    }

    public int getQuesno() {
        return quesno;
    }

    public void setQuesno(int quesno) {
        this.quesno = quesno;
    }

    public String getChosenAns() {
        return chosenAns;
    }

    public void setChosenAns(String chosenAns) {
        this.chosenAns = chosenAns;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    //also ye ans class ka obj arraylist m add hoga isliye hm equals and toString override krenge
    @Override
        public boolean equals(Object obj) {
        
        Answer other = (Answer) obj;
        if (this.examId.equals(other.examId)==false) {
            return false;
        }
        if (this.subject.equals(other.subject)==false) {
            return false;
        }
        if (this.quesno != other.quesno) {
            return false;
        }
        if (this.chosenAns.equals(other.chosenAns)==false) {
            return false;
        }
        if (this.correctAns.equals(other.correctAns)==false) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Answer{" + "quesno=" + quesno + ", chosenAns=" + chosenAns + ", correctAns=" + correctAns + ", examId=" + examId + ", subject=" + subject + '}';
    }
    
    
    
    
    
}
