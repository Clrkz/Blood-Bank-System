/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank;

import static bloodbank.UpdateDonee.lblSelectedRowDoneeID;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author CORE
 */
public class UpdateDonors extends javax.swing.JFrame {
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
int cycle = 1;
String getDate = "",getTime = "";
             String fname = "";
             String mname = "";
             String lname = "";
             String donorsID = "";
            String getAplus = "";
            String getAneg = "";
            String getBplus = "";
            String getBneg = "";
            String getABplus = "";
            String getABneg = "";
            String getOplus = "";
            String getOneg = "";
            int StockInc = 1;
    /**
     * Creates new form Main
     */
    public UpdateDonors() {
        initComponents();
        getMainInfo();
    }
    
    void getMainInfo(){
        conn =  SQLCon.ConnectDB();
        try{
            String sql = "select * from donors where donorsID = '"+getDetails.selectedDonors+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                txtFname.setText(rs.getString("fName"));
                txtMname.setText(rs.getString("mName"));
                txtLname.setText(rs.getString("lName"));
                jTextField4.setText(rs.getString("age"));
                jComboBox1.setSelectedItem(rs.getString("gender"));
                jComboBox2.setSelectedItem(rs.getString("bloodType"));
                jTextField8.setDate(rs.getDate("donateDate"));
                getContactInfo();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"getMainInfo"+ e);
        }
    }
void getContactInfo(){
    conn = SQLCon.ConnectDB();
    try{
        String getContact = "select * from donors_contacts where donorsID = '"+getDetails.selectedDonors+"'";
    pst = conn.prepareStatement(getContact);
   rs =  pst.executeQuery();
    while(rs.next()){
        jTextField5.setText(rs.getString("address"));
        jTextField6.setText(rs.getString("contactNo"));
        jTextField7.setText(rs.getString("eMail"));
    }
    }catch(Exception  e){
        
         JOptionPane.showMessageDialog(null,"getContact"+ e);
    }
}

void updateMainInfo(){
    conn = SQLCon.ConnectDB();
    try{
                 String sql = "UPDATE donors SET fName='"+txtFname.getText()+"',mName='"+txtMname.getText()+"',lName='"+txtLname.getText()+"',age='"+jTextField4.getText()+"',gender='"+jComboBox1.getSelectedItem()+"',bloodType='"+jComboBox2.getSelectedItem()+"',donateDate='"+((JTextField)jTextField8.getDateEditor().getUiComponent()).getText()+"' WHERE donorsID='"+getDetails.selectedDonors+"'";
          pst = conn.prepareStatement(sql);
          pst.executeUpdate();
          JOptionPane.showMessageDialog(null, "Donor Successfully Updated!");
          insertDonorsReport();
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, "updateMainInfo"+e);
             }
}

void updateContactInfo(){
    conn = SQLCon.ConnectDB();
    try{
        String sql = "update donors_contacts set address='"+jTextField5.getText()+"',contactNo='"+jTextField6.getText()+"',eMail='"+jTextField7.getText()+"'";
       pst = conn.prepareStatement(sql);
          pst.executeUpdate();
          updateMainInfo();
    }catch(Exception e){
         JOptionPane.showMessageDialog(null, "updateContactInfo"+e);
    }
}


void insertDonorsReport(){
    conn = SQLCon.ConnectDB();
    
    try{
        String sql = "insert into donorsReport (userID,action,donorsID,date,time) values (?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, getDetails.userid);
        pst.setString(2, "UPDATE A DONOR");
        pst.setString(3, getDetails.selectedDonors);
        getDate();
        getTime();
        pst.setString(4, getDate);
        pst.setString(5, getTime);
        pst.executeUpdate();
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
}

void getDate(){
Date d = new Date();
SimpleDateFormat s = new SimpleDateFormat("MM-dd-yyyy");
getDate = s.format(d);
}
void getTime(){
Date d = new Date();
SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
getTime = s.format(d);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblSelectedRowDonorID = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        txtMname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField8 = new com.toedter.calendar.JDateChooser();
        lblUserID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blood Bank");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("UPDATE DONOR");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 0, 270, 40);

        lblSelectedRowDonorID.setForeground(new java.awt.Color(153, 0, 0));
        lblSelectedRowDonorID.setText("DonorID");
        lblSelectedRowDonorID.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblSelectedRowDonorIDPropertyChange(evt);
            }
        });
        lblSelectedRowDonorID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblSelectedRowDonorIDKeyReleased(evt);
            }
        });
        jPanel1.add(lblSelectedRowDonorID);
        lblSelectedRowDonorID.setBounds(620, 20, 50, 14);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bloodbank/image/backbutton.png"))); // NOI18N
        jLabel15.setToolTipText("Back");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15);
        jLabel15.setBounds(0, 0, 50, 40);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PERSONAL INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Middle Name");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(40, 90, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Last Name");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(40, 120, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Age");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(40, 150, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Gender");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(40, 180, 90, 30);

        txtFname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txtFname);
        txtFname.setBounds(140, 60, 190, 30);

        txtMname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txtMname);
        txtMname.setBounds(140, 90, 190, 30);

        txtLname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txtLname);
        txtLname.setBounds(140, 120, 190, 30);

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField4.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField4InputMethodTextChanged(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField4);
        jTextField4.setBounds(140, 150, 90, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(140, 180, 90, 30);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTACT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel4.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Address");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(40, 30, 70, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Contact No.");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(10, 60, 100, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("e-Mail");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(50, 90, 50, 30);

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(jTextField5);
        jTextField5.setBounds(110, 30, 190, 30);

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(jTextField6);
        jTextField6.setBounds(110, 60, 190, 30);

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField7);
        jTextField7.setBounds(110, 90, 190, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(30, 220, 320, 140);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BLOOD DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel5.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Blood Type");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(10, 30, 100, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Donate Date");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(10, 70, 100, 30);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blood Type", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        jComboBox2.setEnabled(false);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox2);
        jComboBox2.setBounds(120, 30, 150, 30);

        jTextField8.setDateFormatString("yyyy-MM-dd");
        jTextField8.setEnabled(false);
        jPanel5.add(jTextField8);
        jTextField8.setBounds(120, 70, 150, 30);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(360, 20, 290, 170);

        lblUserID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUserID.setText("DonorID");
        jPanel3.add(lblUserID);
        lblUserID.setBounds(140, 30, 90, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("UPDATE DONOR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(450, 300, 200, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("First Name");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(40, 60, 140, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Donor ID");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(40, 30, 90, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 10, 680, 370);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         if (txtFname.getText().equals("") || txtMname.getText().equals("") || txtLname.getText().equals("") || jTextField4.getText().equals("") || jTextField5.getText().equals("") || jTextField6.getText().equals("") || jTextField7.getText().equals("") || ((JTextField)jTextField8.getDateEditor().getUiComponent()).getText().equals("")){
        JOptionPane.showMessageDialog(null, "Fill up all Fields","Blood Bank System",JOptionPane.ERROR_MESSAGE);
        }else{
             if(jComboBox2.getSelectedItem().equals("Blood Type")){
                JOptionPane.showMessageDialog(null, "Select Blood Type");
             }else{
             updateContactInfo();
             jComboBox2.requestFocus();
             }
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void lblSelectedRowDonorIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblSelectedRowDonorIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSelectedRowDonorIDKeyReleased

    private void lblSelectedRowDonorIDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblSelectedRowDonorIDPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lblSelectedRowDonorIDPropertyChange

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        new Donors().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField4InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField4InputMethodTextChanged
try{
        int getAge = Integer.valueOf(jTextField4.getText());
        if (getAge>=75){
             JOptionPane.showMessageDialog(null, "Age 75 or Above are not able to donate");
             jTextField4.setText("");
        } 
 }catch(Exception alba){
JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.ERROR_MESSAGE);
jTextField4.setText("");
 }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4InputMethodTextChanged

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
            java.util.logging.Logger.getLogger(UpdateDonors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDonors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDonors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDonors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDonors().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private com.toedter.calendar.JDateChooser jTextField8;
    public static javax.swing.JLabel lblSelectedRowDonorID;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtMname;
    // End of variables declaration//GEN-END:variables

}
