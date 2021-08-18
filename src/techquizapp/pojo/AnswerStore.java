/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

import java.util.ArrayList;

/**
 *
 * @author tasmi
 */
public class AnswerStore {
    ArrayList <Answer> answerList;

    public AnswerStore() {
        answerList = new ArrayList<>();
    }
     public void addAnswer(Answer answer){
        answerList.add(answer);
    }
    public Answer getAnswer(int pos){
        return answerList.get(pos);
    }
   public void removeAnswer(int pos){
        answerList.remove(pos);
    }
    public void setAnswerAt(int pos,Answer answer){
        answerList.add(pos, answer);
    }
    public ArrayList<Answer> getAllAnswer(){
        return answerList;
    }
    public int getCount(){
        return answerList.size();
    }
    public Answer getAnswerByQuesNo(int quesno){
        for(Answer answer:answerList)
        {
            if(answer.getQuesno()==quesno)
                return answer;//qk ek quess ka ek hi ans hoga yhi se return kr jarnge
        }
        return null;//agr attempt nhi kiya hoga ques to AnswerList me koi entry nhi hogi thus return null
    }
    public int removeAnswer(Answer answer){
        int pos=answerList.indexOf(answer);
        answerList.remove(pos);
        return pos;
    }
            

}
