/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class DonorsInformation extends javax.swing.JFrame {
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
int cycle = 1;
String donorsId;
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
            String getDate = "",getTime="";
    /**
     * Creates new form Main
     */
    public DonorsInformation() {
        initComponents();
        showDate();
    }
    
    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        ((JTextField)jTextField8.getDateEditor().getUiComponent()).setText(s.format(d));
    }
void insertContact(){
    conn = SQLCon.ConnectDB();
    try{
        String sql="insert into donors_contacts (donorsID,address,contactNo,eMail) values (?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, donorsId);
        pst.setString(2, jTextField5.getText());
        pst.setString(3, jTextField6.getText());
        pst.setString(4, jTextField7.getText());
        pst.executeUpdate();
         insertDonorsReport();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
}

void insertDonorsReport(){
    conn = SQLCon.ConnectDB();
    
    try{
        String sql = "insert into donorsReport (userID,action,donorsID,date,time) values (?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, getDetails.userid);
        pst.setString(2, "ADDED A DONOR");
        pst.setString(3, donorsId);
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
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
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
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blood Bank");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DONORS INFORMATION");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 0, 270, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bloodbank/image/backbutton.png"))); // NOI18N
        jLabel12.setToolTipText("Back");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 0, 50, 40);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PERSONAL INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Middle Name");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(40, 60, 100, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Last Name");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(40, 90, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Age");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(40, 120, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Gender");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(40, 150, 90, 30);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(jTextField1);
        jTextField1.setBounds(140, 30, 190, 30);

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(jTextField2);
        jTextField2.setBounds(140, 60, 190, 30);

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(jTextField3);
        jTextField3.setBounds(140, 90, 190, 30);

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField4PropertyChange(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField4);
        jTextField4.setBounds(140, 120, 90, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(140, 150, 90, 30);

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
        jPanel4.setBounds(30, 200, 320, 140);

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
        jPanel5.add(jComboBox2);
        jComboBox2.setBounds(120, 30, 150, 30);

        jTextField8.setDateFormatString("yyyy-MM-dd");
        jPanel5.add(jTextField8);
        jTextField8.setBounds(120, 70, 150, 30);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(360, 20, 290, 110);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("First Name");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(40, 30, 100, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("ADD DONOR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(470, 290, 180, 50);

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
       
         if (jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("") || jTextField4.getText().equals("") || jTextField5.getText().equals("") || jTextField6.getText().equals("") || jTextField7.getText().equals("") || ((JTextField)jTextField8.getDateEditor().getUiComponent()).getText().equals("")){
        JOptionPane.showMessageDialog(null, "Fill up all Fields","Blood Bank System",JOptionPane.ERROR_MESSAGE);
        }else if(jComboBox2.getSelectedItem().equals("Blood Type")){
                JOptionPane.showMessageDialog(null, "Select Blood Type");
             jComboBox2.requestFocus();
             }else{
            int getAge = Integer.valueOf(jTextField4.getText());
             if(getAge<=17){
                  JOptionPane.showMessageDialog(null, "Age 17 or Below are not able to donate");
             }else{
                 String checkFname = jTextField1.getText();
                 String checkLname = jTextField3.getText();
              String checkDonor = "SELECT * FROM donors WHERE fName='"+checkFname+"' and lName='"+checkLname+"'";
         String sql = "insert into donors (fName,mName,lName,age,gender,bloodType,cycle,donateDate) values (?,?,?,?,?,?,?,?)";
         String stock = "SELECT * FROM bloodstock";
         
         Connection conn=SQLCon.ConnectDB();
         try{
             pst=conn.prepareStatement(checkDonor);
             rs = pst.executeQuery();
             while(rs.next()){
             fname = rs.getString("fName");
             mname = rs.getString("mName");
             lname = rs.getString("lName");
             donorsID = rs.getString("donorsID");
             }
             if(fname.equals(jTextField1.getText()) & mname.equals(jTextField2.getText()) & lname.equals(jTextField3.getText())){
             JOptionPane.showMessageDialog(null, "Donors Details Already Exist\nDonors ID: "+donorsID);
             fname = "";
             mname = "";
             lname = "";
             }else{
                 pst=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,jTextField1.getText());
            pst.setString(2,jTextField2.getText());
            pst.setString(3,jTextField3.getText());
            pst.setString(4,jTextField4.getText());
            pst.setString(5, (String) jComboBox1.getSelectedItem());
            pst.setString(6, (String) jComboBox2.getSelectedItem());
            pst.setString(7, String.valueOf(cycle));
            pst.setString(8, ((JTextField)jTextField8.getDateEditor().getUiComponent()).getText());
            pst.executeUpdate();
             rs = pst.getGeneratedKeys();
             rs.next();
            long pk = rs.getLong(1);
            donorsId = String.valueOf(pk); 
            insertContact();
            pst=conn.prepareStatement(stock);
            rs = pst.executeQuery();
            while(rs.next()){
            getAplus = rs.getString("A+");
            getAneg = rs.getString("A-");
            getBplus = rs.getString("B+");
            getBneg = rs.getString("B-");
            getABplus = rs.getString("AB+");
            getABneg = rs.getString("AB-");
            getOplus = rs.getString("O+");
            getOneg = rs.getString("O-");
            System.out.print("Done Get Blood Stocks");
            }
            if(jComboBox2.getSelectedItem().equals("A+")){
                String putToStock = "UPDATE bloodstock SET [A+]=?";
                pst=conn.prepareStatement(putToStock);
               StockInc = StockInc + Integer.valueOf(getAplus);
            pst.setString(1, String.valueOf(StockInc));
            pst.executeUpdate(); StockInc = 1;
            }if(jComboBox2.getSelectedItem().equals("A-")){
                String putToStock = "UPDATE bloodstock SET [A-]=?";
                pst=conn.prepareStatement(putToStock);
               StockInc = StockInc + Integer.valueOf(getAneg);
            pst.setString(1, String.valueOf(StockInc));
            pst.executeUpdate(); StockInc = 1;
            }if(jComboBox2.getSelectedItem().equals("B+")){
                String putToStock = "UPDATE bloodstock SET [B+]=?";
                pst=conn.prepareStatement(putToStock);
               StockInc = StockInc + Integer.valueOf(getBplus);
            pst.setString(1, String.valueOf(StockInc));
            pst.executeUpdate(); StockInc = 1;
            }if(jComboBox2.getSelectedItem().equals("B-")){
                String putToStock = "UPDATE bloodstock SET [B-]=?";
                pst=conn.prepareStatement(putToStock);
               StockInc = StockInc + Integer.valueOf(getBneg);
            pst.setString(1, String.valueOf(StockInc));
            pst.executeUpdate(); StockInc = 1;
            }if(jComboBox2.getSelectedItem().equals("AB+")){
                String putToStock = "UPDATE bloodstock SET [AB+]=?";
                pst=conn.prepareStatement(putToStock);
               StockInc = StockInc + Integer.valueOf(getABplus);
            pst.setString(1, String.valueOf(StockInc));
            pst.executeUpdate(); StockInc = 1;
            }if(jComboBox2.getSelectedItem().equals("AB-")){
                String putToStock = "UPDATE bloodstock SET [AB-]=?";
                pst=conn.prepareStatement(putToStock);
               StockInc = StockInc + Integer.valueOf(getABneg);
            pst.setString(1, String.valueOf(StockInc));
            pst.executeUpdate(); StockInc = 1;
            }if(jComboBox2.getSelectedItem().equals("O+")){
                String putToStock = "UPDATE bloodstock SET [O+]=?";
                pst=conn.prepareStatement(putToStock);
               StockInc = StockInc + Integer.valueOf(getOplus);
            pst.setString(1, String.valueOf(StockInc));
            pst.executeUpdate(); StockInc = 1;
            }if(jComboBox2.getSelectedItem().equals("O-")){
                String putToStock = "UPDATE bloodstock SET [O-]=?";
                pst=conn.prepareStatement(putToStock);
               StockInc = StockInc + Integer.valueOf(getOneg);
            pst.setString(1, String.valueOf(StockInc));
            pst.executeUpdate(); StockInc = 1;
            }
            conn.close();
            JOptionPane.showMessageDialog(null, "Donors Successfully Added");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jComboBox1.setSelectedItem("Male");
            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jComboBox2.setSelectedItem("Blood Type");
            cycle = 1;
            jTextField8.setDate(null);}
             
            
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
             }
             }
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        new Donors().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jTextField4PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField4PropertyChange
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextField4PropertyChange

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
 try{
        int getAge = Integer.valueOf(jTextField4.getText());
        if (getAge>=75){
             JOptionPane.showMessageDialog(null, "Age 75 or Above are not able to donate");
             jTextField4.setText("");
        } 
 }catch(Exception alba){
JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.ERROR_MESSAGE);
jTextField4.setText("");
 }
    }//GEN-LAST:event_jTextField4KeyReleased

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
            java.util.logging.Logger.getLogger(DonorsInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DonorsInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DonorsInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DonorsInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DonorsInformation().setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private com.toedter.calendar.JDateChooser jTextField8;
    // End of variables declaration//GEN-END:variables

}