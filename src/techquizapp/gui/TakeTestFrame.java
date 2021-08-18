/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import techquizapp.dao.PerformanceDAO;
import techquizapp.dao.QuestionsDAO;
import techquizapp.pojo.Answer;
import techquizapp.pojo.AnswerStore;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Performance;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author tasmi
 */
public class TakeTestFrame extends javax.swing.JFrame {

    /**
     * Creates new form TakeTestFrame
     */
    private int pos=0,quesno;
    private QuestionStore qstore;
    private AnswerStore astore;
    private Exam exam;
    
    public TakeTestFrame() {
        initComponents();
        setLocationRelativeTo(null);
        lblUsername.setText("Hello "+UserProfile.getUsername());
        qstore=new QuestionStore();
        astore=new AnswerStore();
        quesno=1;
        lblQuesNo.setText(lblQuesNo.getText()+ quesno);
        Clock c=new Clock();
        c.start();
         
    }
    
    public TakeTestFrame(Exam exam){
        this();
        this.exam=exam;
        lblHeader.setText(exam.getLang().toUpperCase()+" PAPER");
        loadQuestions();
        showQuestion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblHeader = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQues = new javax.swing.JTextArea();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        lblQuesNo = new javax.swing.JLabel();
        jrbOpt1 = new javax.swing.JRadioButton();
        jrbOpt2 = new javax.swing.JRadioButton();
        jrbOpt3 = new javax.swing.JRadioButton();
        jrbOpt4 = new javax.swing.JRadioButton();
        lblTimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 153, 0));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(255, 153, 0));
        lblHeader.setText("JAVA PAPER");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/good luck2.jpg"))); // NOI18N

        txtQues.setColumns(20);
        txtQues.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtQues.setRows(5);
        jScrollPane1.setViewportView(txtQues);

        btnNext.setBackground(new java.awt.Color(0, 0, 0));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 153, 0));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(255, 153, 0));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 153, 0));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        btnDone.setForeground(new java.awt.Color(255, 153, 0));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        lblQuesNo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblQuesNo.setForeground(new java.awt.Color(255, 153, 0));
        lblQuesNo.setText("Question No : ");

        buttonGroup1.add(jrbOpt1);
        jrbOpt1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jrbOpt1.setForeground(new java.awt.Color(255, 153, 0));

        buttonGroup1.add(jrbOpt2);
        jrbOpt2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jrbOpt2.setForeground(new java.awt.Color(255, 153, 0));

        buttonGroup1.add(jrbOpt3);
        jrbOpt3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jrbOpt3.setForeground(new java.awt.Color(255, 153, 0));

        buttonGroup1.add(jrbOpt4);
        jrbOpt4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jrbOpt4.setForeground(new java.awt.Color(255, 153, 0));

        lblTimer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrevious)
                        .addGap(77, 77, 77)
                        .addComponent(btnCancel)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDone))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(btnNext)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblQuesNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbOpt3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrbOpt4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbOpt1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrbOpt2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 144, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(lblHeader))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(lblHeader)
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbOpt1)
                            .addComponent(jrbOpt2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbOpt3)
                            .addComponent(jrbOpt4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDone)
                            .addComponent(btnNext)
                            .addComponent(btnCancel)
                            .addComponent(btnPrevious)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblQuesNo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        doneTest();
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        ChoosePaperFrame choosePaper=new ChoosePaperFrame();
        choosePaper.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        String chosenAns=getUserAnswer();
        if(chosenAns!=null)
        {
            //ab agr ques attempted hai to me ans obj bnana padega or uske liye baki sb haiexcept correct ans thus we will first achieve the correct ans
            Question ques=qstore.getQuestionByQuesNo(quesno);
            String correctAns=ques.getCorrectAns();
            Answer ans=new Answer(quesno,chosenAns,correctAns,exam.getExamId(),exam.getLang());
            //ab direct add nhi krenge astore me qk esa bhi ho skta hai ye ek poora round lekr aaye ho dusri bar attempt kiya ho
            //thus pta kro is ques ka ans attempt hua hai ki nhi
            Answer attempted=astore.getAnswerByQuesNo(quesno);
            if(attempted==null)//attempt phli bar kiya hai
            {
                astore.addAnswer(attempted);
            }
            else
            {//ab mtlb attempted hai pr hm tb remove krenge jb jb prev or currect ans diifer kr rhe ho else nhi krenge qk arraylist me insertion and removal
             //time consumin hai...arraylist traversal ke liye acchi hoti hai
                String prevAns=attempted.getChosenAns();
                if(prevAns.equals(chosenAns)==false)
                {
                    int apos=astore.removeAnswer(attempted);
                    astore.setAnswerAt(apos,ans) ;       
                } 
            }
            pos--;
        if(pos<0){ 
            pos=qstore.getCount()-1;
        }
        quesno--;
        if(quesno<=0)
        {
            quesno=qstore.getCount();
        }
        lblQuesNo.setText("Question No :"+quesno);
        showQuestion();  
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        String chosenAns=getUserAnswer();
        if(chosenAns!=null)
        {
            //ab agr ques attempted hai to me ans obj bnana padega or uske liye baki sb haiexcept correct ans thus we will first achieve the correct ans
            Question ques=qstore.getQuestionByQuesNo(quesno);
            String correctAns=ques.getCorrectAns();
            Answer ans=new Answer(quesno,chosenAns,correctAns,exam.getExamId(),exam.getLang());
            //ab direct add nhi krenge astore me qk esa bhi ho skta hai ye ek poora round lekr aaye ho dusri bar attempt kiya ho
            //thus pta kro is ques ka ans attempt hua hai ki nhi
            Answer attempted=astore.getAnswerByQuesNo(quesno);
            if(attempted==null)//attempt phli bar kiya hai
            {
                astore.addAnswer(ans);
            }
            else
            {//ab mtlb attempted hai pr hm tb remove krenge jb jb prev or currect ans diifer kr rhe ho else nhi krenge qk arraylist me insertion and removal
             //time consumin hai...arraylist traversal ke liye acchi hoti hai
                String prevAns=attempted.getChosenAns();
                if(prevAns.equals(chosenAns)==false)
                {
                    int apos=astore.removeAnswer(attempted);
                    astore.setAnswerAt(apos,ans) ;       
                } 
            }
            pos++;
        if(pos>=qstore.getCount()){ 
            pos=0;
        }
        quesno++;
        if(quesno>qstore.getCount())
        {
            quesno=1;
        }
        lblQuesNo.setText("Question No :"+quesno);
        showQuestion();  
        }
    }//GEN-LAST:event_btnNextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeTestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbOpt1;
    private javax.swing.JRadioButton jrbOpt2;
    private javax.swing.JRadioButton jrbOpt3;
    private javax.swing.JRadioButton jrbOpt4;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblQuesNo;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextArea txtQues;
    // End of variables declaration//GEN-END:variables

    private void loadQuestions() {
        try
        {
            ArrayList<Question>quesList=QuestionsDAO.getQuestionsByExamId(exam.getExamId());//contains ques..put these ques in QuestionStore as it has methods to retrieve data
            for(Question q:quesList)
            {
                qstore.addQuestion(q);  // not quesList.add(q) use qstore
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DBError.","Edit Paper Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void showQuestion() {
        Question question=qstore.getQuestion(pos);
        buttonGroup1.clearSelection();
        txtQues.setText(question.getQues());
        jrbOpt1.setText(question.getAns1());
        jrbOpt2.setText(question.getAns2());
        jrbOpt3.setText(question.getAns3());
        jrbOpt4.setText(question.getAns4());
        //ab agr user next krte krte wapas isi ques pe aaya to use qaide se uska selected ans show hona chahiye na
        //check kro ki ques attempted hai ki nhi..if ke=ra to answer return hoga else null return hoga
//        System.out.println(quesno);
        Answer ans=astore.getAnswerByQuesNo(quesno);
//        System.out.println(quesno);
        if(ans==null)
        {
            return;//koi bhi radiobutton select nhi krna hoga
        }
        //null nhi h mtlb attempt kiya h phlese
        String str=ans.getChosenAns();
        switch(str)
        {
            case "Answer 1":
                    jrbOpt1.setSelected(true);
                    break;
            case "Answer 2":
                    jrbOpt2.setSelected(true);
                    break;
            case "Answer 3":
                    jrbOpt3.setSelected(true);
                    break;
            case "Answer 4":
                    jrbOpt4.setSelected(true);
                    break;
            //no default req as agr ans hota hi nhi to phle hi null mil chuka hota 
        }     
    }
    
    private void doneTest() {
            String chosenAns=getUserAnswer();
        if(chosenAns!=null)
        {
            Question ques=qstore.getQuestionByQuesNo(quesno);
            String correctAns=ques.getCorrectAns();
            Answer ans=new Answer(quesno,chosenAns,correctAns,exam.getExamId(),exam.getLang());
            Answer attempted=astore.getAnswerByQuesNo(quesno);
            if(attempted==null)//attempt phli bar kiya hai
            {
                astore.addAnswer(ans);
            }
            else
            {
                String prevAns=attempted.getChosenAns();
                if(prevAns.equals(chosenAns)==false)
                {
                    int apos=astore.removeAnswer(attempted);
                    astore.setAnswerAt(apos,ans) ;       
                } 
            }
        }
        int right=0,wrong=0;
        for(Question ques:qstore.getAllQuestions())//hm loop qstore pr chalenge astore pr nhi qk astore m sare attempted hi honge
        {
            int qno=ques.getQuesno();
            Answer ans=astore.getAnswerByQuesNo(qno);
            if(ans==null)
            {
                continue;//kch nhi krenge
            }
            String attemptedAns=ans.getChosenAns();
            String correctAns=ans.getCorrectAns();
            if(attemptedAns.equals(correctAns))
                ++right;
            else
                ++wrong;
        }
        StringBuilder sb=new StringBuilder();//qk bar bar + = lgegega
        sb.append("\nRight Answers : "+right);
        sb.append("\nWrong Answers : "+wrong);
        sb.append("\nUnattempted Answers : "+ (qstore.getCount()-(right+wrong)));
        JOptionPane.showMessageDialog(null,sb.toString(),"Result",JOptionPane.INFORMATION_MESSAGE);
        try{
            Performance p=new Performance(UserProfile.getUsername(),exam.getExamId(),right,wrong,qstore.getCount()-(right+wrong),(double)right/qstore.getCount()*100,exam.getLang());
            PerformanceDAO.addPerformance(p);
            JOptionPane.showMessageDialog(null,"Result saved.\nThankyou for the test.","Done!",JOptionPane.INFORMATION_MESSAGE);
            ChoosePaperFrame choosePaper=new ChoosePaperFrame();
            choosePaper.setVisible(true);
            this.dispose();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "DBError.","Take Test Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        }
    private String getUserAnswer()
    {
        if(jrbOpt1.isSelected())
            return "Answer 1";// space as question table me correct ans answer 1 esa h(space h bich me) thus comparison hoga to ekdum ese hi likhna padega
        if(jrbOpt2.isSelected())
            return "Answer 2";
        if(jrbOpt3.isSelected())
            return "Answer 3";
        if(jrbOpt4.isSelected())
            return "Answer 4";
        return null;
    }
    
     class Clock extends Thread
     {
        int time=0;
        int m=0,s=60,h=0;
        public void run()
        {
            while(true)
            {
               Calendar date=Calendar.getInstance();
               date.setTime(new java.util.Date());
               date.set(Calendar.HOUR_OF_DAY, h);
               date.set(Calendar.MINUTE, m);
               date.set(Calendar.SECOND, s);
               date.set(Calendar.MILLISECOND, 0);
               java.util.Date da=date.getTime();
               SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
               String str=sdf.format(da);
               
                try
                {
                    Thread.sleep(1000);
                    s=s-1;
                    if(s==0)
                    {
//                        m=m-1;
//                        s=60;
                        time=time+1;
                    }
                    lblTimer.setText("Time left : "+str);
                }
                catch(InterruptedException ex)
                {
                    System.out.println(ex);
                }
                if(time==1)
                {
                    lblTimer.setText("Time left : 00:00:00");
                    JOptionPane.showMessageDialog(null, "Time Over.","Test submitted",JOptionPane.INFORMATION_MESSAGE);
                    doneTest();
                    btnNext.setEnabled(false);
                    btnPrevious.setEnabled(false);
                    break;
                }
            }
        }
    }
}
