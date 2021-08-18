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
public class QuestionStore {
    //arraylist jo bnegi exam obj ki (ehich in turn would contain questions) use bar bar use krne ke liye alg se class bna di...arraylist ka use bht h
    //ye class array list pr operations kregi methods bnaenge or call baar baar krenge
    ArrayList <Question> questionList;

    public QuestionStore() {
        questionList=new ArrayList<>();
    }

    @Override//will internally call the toString()of Question
    public String toString() {
        return "QuestionsStore{" + "questionList=" + questionList + '}';
    }
    public void addQuestion(Question q){
        questionList.add(q);
    }
    public Question getQuestion(int pos){
        return questionList.get(pos);
    }
    public Question getQuestionByQuesNo(int quesno){
        for(Question question:questionList)
        {
            if(question.getQuesno()==quesno)
                return question;//qk ek quess ka ek hi ans hoga yhi se return kr jarnge
        }
        return null;//agr attempt nhi kiya hoga ques to AnswerList me koi entry nhi hogi thus return null
    }
   public void removeQuestion(int pos){
        questionList.remove(pos);
    }
    public void setQuestionAt(int pos,Question q){
        questionList.add(pos, q);
    }
    public ArrayList<Question> getAllQuestions(){
        return questionList;
    }
    public int getCount(){
        return questionList.size();
    }
}

    
