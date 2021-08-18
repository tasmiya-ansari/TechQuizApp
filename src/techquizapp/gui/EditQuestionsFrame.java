/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;
import techquizapp.dao.QuestionsDAO;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author tasmi
 */
public class EditQuestionsFrame extends javax.swing.JFrame {

    /**
     * Creates new form EditQuestionsFrame
     */
    private Exam editExam;
    private QuestionStore qstore;
    private HashMap <String,String> options;
    private int quesno;
    private int pos=0;
    private String question,option1,option2,option3,option4,correctOption;
    
    
    public EditQuestionsFrame() {
        initComponents();
        setLocationRelativeTo(null);
        lblUsername.setText("Hello "+UserProfile.getUsername());
        qstore=new QuestionStore();
        quesno=1;
        lblQuesNo.setText(lblQuesNo.getText() + quesno);
        
        
        options=new HashMap<>();
        
        options.put("Option 1","Answer 1");
        options.put("Option 2","Answer 2");        
        options.put("Option 3","Answer 3");
        options.put("Option 4","Answer 4");
    }
     public EditQuestionsFrame(Exam editExam)//qk java ne koi parameterised constructor nhi diya h is frame ka
    {
        this();
        this.editExam=editExam;
        lblHeader.setText("EDITING "+editExam.getLang().toUpperCase()+" PAPER");
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

        jPanel1 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblHeader = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtQues = new javax.swing.JTextArea();
        lblQuesNo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOpt1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtOpt2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOpt3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtOpt4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbCorrectAns = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 153, 0));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(255, 153, 0));
        lblHeader.setText("EDIT JAVA PAPER");

        btnCancel.setBackground(new java.awt.Color(0, 0, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 153, 0));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(255, 153, 0));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDone.setForeground(new java.awt.Color(255, 153, 0));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(0, 0, 0));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 153, 0));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/questionpaper4.jpg"))); // NOI18N

        txtQues.setColumns(20);
        txtQues.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtQues.setRows(5);
        jScrollPane2.setViewportView(txtQues);

        lblQuesNo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblQuesNo.setForeground(new java.awt.Color(255, 153, 0));
        lblQuesNo.setText("Question No :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Option 1");

        txtOpt1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Option2");

        txtOpt2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtOpt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOpt2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Option3");

        txtOpt3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtOpt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOpt3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Option 4");

        txtOpt4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Correct Answer:");

        jcbCorrectAns.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jcbCorrectAns.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Option 1", "Option 2", "Option 3", "Option 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300)
                        .addComponent(btnCancel)
                        .addGap(87, 87, 87)
                        .addComponent(btnDone))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNext)
                                .addGap(73, 73, 73)
                                .addComponent(btnPrevious))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHeader)
                                    .addComponent(txtOpt1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOpt3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblQuesNo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbCorrectAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtOpt4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtOpt2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblHeader)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuesNo)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOpt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOpt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOpt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOpt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcbCorrectAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious)
                    .addComponent(btnCancel)
                    .addComponent(btnDone)
                    .addComponent(btnNext))
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

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if(validateInputs()==false)
        {
            JOptionPane.showMessageDialog(null,"DB Error.","Edit Questions Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Question editQues=new Question(editExam.getExamId(),quesno,question,option1,option2,option3,option4,options.get(correctOption),editExam.getLang());
        qstore.removeQuestion(pos);//sb ek upar shift ho gya
        qstore.setQuestionAt(pos, editQues);//wapas usi index pe set krenge ques
        pos++;

        if(pos>=qstore.getCount()){
            JOptionPane.showMessageDialog(null,"Your questions have all been edited successfully.\nPress the DONE button to addthem to the database.","Exam Added!",JOptionPane.INFORMATION_MESSAGE);
            pos=0;//ek chance de rhe h user ko review krne ke liye

        }
        showQuestion();
        quesno++;
        if(quesno>qstore.getCount())
        {
            quesno=1;
        }
        lblQuesNo.setText("Question No :"+quesno);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        try{
            QuestionsDAO.updateQuestions(qstore);
            JOptionPane.showMessageDialog(null, "Your questions have been successfully updated in the DB","Exam Added!",JOptionPane.INFORMATION_MESSAGE);
            EditPaperFrame paperFrame=new EditPaperFrame();
            paperFrame.setVisible(true);
            this.dispose();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error while connecting to DB!","Exception!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if(validateInputs()==false)
        {
            JOptionPane.showMessageDialog(null,"Please fill all the fields.","Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Question editQues=new Question(editExam.getExamId(),quesno,question,option1,option2,option3,option4,options.get(correctOption),editExam.getLang());
        qstore.removeQuestion(pos);//sb ek upar shift ho gya
        qstore.setQuestionAt(pos, editQues);//wapas usi index pe set krenge ques
        pos--;

        if(pos<0){
            JOptionPane.showMessageDialog(null,"Your questions have all been edited successfully.\nPress the DONE button to addthem to the database.","Exam Added!",JOptionPane.INFORMATION_MESSAGE);
            pos=qstore.getCount()-1;

        }
        showQuestion();
        quesno--;
        if(quesno<=qstore.getCount())
        {
            quesno=qstore.getCount();        }
        lblQuesNo.setText("Question No :"+quesno);
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        EditPaperFrame editPaper=new EditPaperFrame();
        editPaper.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtOpt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOpt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOpt2ActionPerformed

    private void txtOpt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOpt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOpt3ActionPerformed

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
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQuestionsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuestionsFrame().setVisible(true);
            }
        });
    }
      private void loadQuestions() {
        try
        {
            ArrayList<Question>quesList=QuestionsDAO.getQuestionsByExamId(editExam.getExamId());//contains ques..put these ques in QuestionStore as it has methods to retrieve data
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbCorrectAns;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblQuesNo;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtOpt1;
    private javax.swing.JTextField txtOpt2;
    private javax.swing.JTextField txtOpt3;
    private javax.swing.JTextField txtOpt4;
    private javax.swing.JTextArea txtQues;
    // End of variables declaration//GEN-END:variables
     
    private boolean validateInputs() {
        question=txtQues.getText().trim();
        option1=txtOpt1.getText().trim();
        option2=txtOpt2.getText().trim();
        option3=txtOpt3.getText().trim();
        option4=txtOpt4.getText().trim();
        correctOption=jcbCorrectAns.getSelectedItem().toString();
        if(txtOpt1.getText().isEmpty()||txtOpt2.getText().isEmpty()||txtOpt3.getText().isEmpty()||txtOpt4.getText().isEmpty())
            return false;
        else 
            return true;
    }      
    public void showQuestion(){
        Question question=qstore.getQuestion(pos);
        txtQues.setText(question.getQues());
        txtOpt1.setText(question.getAns1());
        txtOpt2.setText(question.getAns2());
        txtOpt3.setText(question.getAns3());
        txtOpt4.setText(question.getAns4());
        String correctAnswer=question.getCorrectAns();//as(q.getCorrectAns() will give value as ans no while combo box has values as optno thus to convert ansno to optno
        String correctOption=getKeyFromValue(correctAnswer);
        jcbCorrectAns.setSelectedItem(correctOption);
        }
    
     public String getKeyFromValue(String value) {//collection me key se value nikal skte h but value se key nhi milti isliye func
        Set<String>keys=options.keySet();
        for (String key : keys) {
            String currValue=options.get(key);//value aa jaegi
            if (currValue.equals(value)) {
                return key;
            }
        }
        return null;//qk return key for ke andar hai or java ye nhi manegi isliye use satisfy krne ke liye hme return null krna padega....zaroori nhi h null return ho kch bhi krdo qk ye kbhi chlna hi nhi h
        //if 100%true hoga
    }
    

}
  
