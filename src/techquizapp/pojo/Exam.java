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
public class Exam {
   private  String examId;
   private String lang;
   private int totQues;

    public Exam() {
    }

    public Exam(String examId, String lang, int totQues) {
        this.examId = examId;
        this.lang = lang;
        this.totQues = totQues;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getTotQues() {
        return totQues;
    }

    public void setTotQues(int totQues) {
        this.totQues = totQues;
    }

    
}
