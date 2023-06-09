/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Model.ExamModel;
import Views.ExamViewIdentification;
import Controller.*;
import java.sql.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class ListofExam extends javax.swing.JFrame {

    /**
     * Creates new form ListofExam
     */
    public ListofExam() {
        initComponents();
        ExamModel.Connect();
        PopulateExamTable();
    }
       
    public void PopulateExamTable(){
        int col;
        int numofitems;
        
        try {
            ExamModel.pst = ExamModel.conn.prepareStatement("Select * from examcreated ORDER BY exam_id DESC");
            ResultSet rs = ExamModel.pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            col = rsd.getColumnCount();
            
            ExamModel.dtm = (DefaultTableModel)jTable1.getModel();
            ExamModel.dtm.setRowCount(0);
            
            while(rs.next()){
                Vector v2 = new Vector();
                
                for(int i=1; i<=col; i++){
                    v2.add(rs.getString("subject"));
                    v2.add(rs.getString("grading_period"));
                    v2.add(rs.getString("semester"));
                    numofitems = rs.getInt("multiplechoice") + rs.getInt("indentification");
                    v2.add(numofitems);
                    v2.add(rs.getInt("multiplechoice"));
                    v2.add(rs.getInt("indentification"));
                    v2.add(rs.getString("prof_name"));
                }
                
                ExamModel.dtm.addRow(v2); 
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ListofExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void TakeExam(){
        ExamModel.dtm = (DefaultTableModel)jTable1.getModel();
        int select = jTable1.getSelectedRow();
        String gradeper = ExamModel.dtm.getValueAt(select, 1).toString();
        int limitmulti = Integer.parseInt( ExamModel.dtm.getValueAt(select, 4).toString());
        int limitindenty = Integer.parseInt(ExamModel.dtm.getValueAt(select, 5).toString());   
        String Subject = ExamModel.dtm.getValueAt(select, 0).toString();
        System.out.println(limitindenty);
        System.out.println(limitmulti);
        System.out.println(Subject);
        
        
        if(Optional.ofNullable(limitindenty).orElse(0) != 0) {
            GetExamParameters.setIdentLimit(limitindenty, Subject, gradeper);
        }
        
        try {
            ExamModel.pst = ExamModel.conn.prepareStatement("SELECT * FROM exam WHERE subject=?");
            ExamModel.pst.setString(1, Subject);
            ResultSet rs1 = ExamModel.pst.executeQuery();
            
            if (rs1.next()) {
               StudentTakeExam();
            } else {
                JOptionPane.showMessageDialog(null,  "No Questions Available");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(ListofExam.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,  "You Already Take This Exam");
        }
    }
    
    
    public void StudentTakeExam(){
        ExamModel.dtm = (DefaultTableModel)jTable1.getModel();
        int select = jTable1.getSelectedRow();
        String Subject = ExamModel.dtm.getValueAt(select, 0).toString();
        String gradeper = ExamModel.dtm.getValueAt(select, 1).toString();
        int limitmulti = Integer.parseInt( ExamModel.dtm.getValueAt(select, 4).toString());
        int limitindenty = Integer.parseInt(ExamModel.dtm.getValueAt(select, 5).toString());   
        System.out.println(limitindenty);
        System.out.println(limitmulti);
        System.out.println(Subject);
        String Student = GetExamParameters.GetStudent();
        
         try {
            ExamModel.pst = ExamModel.conn.prepareStatement("insert into exam_take(student_name, subject, grading_per) values(?,?,?)");
            ExamModel.pst.setString(1, Student);
            ExamModel.pst.setString(2, Subject);
            ExamModel.pst.setString(3, gradeper);
            ExamModel.pst.executeUpdate();
            
            if (Optional.ofNullable(limitmulti).orElse(0) != 0) {
                GetExamParameters.setMultiLimit(limitmulti, Subject, gradeper);
                this.setVisible(false);
                ExamViewMultipleChoice hpag = new ExamViewMultipleChoice();
                hpag.setVisible(true);
            } else if (Optional.ofNullable(limitindenty).orElse(0) != 0) {
                GetExamParameters.setIdentLimit(limitindenty, Subject, gradeper);
                this.setVisible(false);
                ExamViewIdentification hpag = new ExamViewIdentification();
                hpag.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Exam Not Ready Yet");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ListofExam.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,  "You Already Take This Exam");
        }
    }
  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Available Exam");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Take Exam");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "Grading Period", "Semester", "Items", "Multiple Choice", "Identification", "Professors Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(2);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(368, 368, 368)
                        .addComponent(jLabel1)
                        .addGap(0, 450, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        StudentView hpag = new StudentView();
        hpag.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TakeExam();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ListofExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListofExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListofExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListofExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListofExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
