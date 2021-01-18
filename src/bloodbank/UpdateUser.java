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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author CORE
 */
public class UpdateUser extends javax.swing.JFrame {
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
String wImage = "No";
String s;
    /**
     * Creates new form Main
     */
    public UpdateUser() {
        initComponents();
        lblSelectedRowUserID.setVisible(false);
        getInfo();
    }
void getInfo(){
   String sql = "select * from users where userID='"+getDetails.selectedUserId+"'";
         Connection conn=SQLCon.ConnectDB();
         try{
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                lblUserID.setText(rs.getString("userID"));
                txtFname.setText(rs.getString("fName"));
                txtMname.setText(rs.getString("mName"));
                txtLname.setText(rs.getString("lName"));
                cboGender.setSelectedItem(rs.getString("gender"));
                txtUsernname.setText(rs.getString("username"));
                txtPass.setText(rs.getString("password"));
                txtPass2.setText(txtPass.getText());
                cboUserType.setSelectedItem(rs.getString("userType"));
                 byte[] img = rs.getBytes("image");
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
                lblImage.setIcon(imageIcon);
                getPersonalInfo();
            }
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
             }
}

void getPersonalInfo(){
     String sql = "select * from user_personal_info where userID='"+getDetails.selectedUserId+"'";
         Connection conn=SQLCon.ConnectDB();
         try{
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                txtDOB.setDate(rs.getDate("birthDate"));
                cboBloodType.setSelectedItem(rs.getString("bloodType"));
                getContactInfo();
            }
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
             }
}

void getContactInfo(){
     String sql = "select * from user_contact_info where userID='"+getDetails.selectedUserId+"'";
         Connection conn=SQLCon.ConnectDB();
         try{
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                txtEmail.setText(rs.getString("eMail"));
                txtAddress.setText(rs.getString("address"));
                txtContactNo.setText(rs.getString("contactNo"));
            }
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
             }
}

void updateMainInfo(){
     String sql = "update users set fName=?,mName=?,lName=?,gender=?,userType=?,username=?,password=? where userID='"+getDetails.selectedUserId+"'";
         Connection conn=SQLCon.ConnectDB();
         try{
            pst=conn.prepareStatement(sql);
               pst.setString(1, txtFname.getText());
               pst.setString(2, txtMname.getText());
               pst.setString(3, txtLname.getText());
                pst.setString(4, (String) cboGender.getSelectedItem());
                 pst.setString(5, (String) cboUserType.getSelectedItem());
                  pst.setString(6, txtUsernname.getText());
                   pst.setString(7, txtPass.getText());
                   pst.executeUpdate();
                   if (wImage.equals("No")) {
          String sqlNoImage = "UPDATE users SET image=? WHERE userID='"+getDetails.selectedUserId+"'";
          pst = conn.prepareStatement(sqlNoImage);
          pst.setString(1, "");
          pst.executeUpdate();
      } else if (wImage.equals("Yes")) {
          String sqlWithImage = "UPDATE users SET image=? WHERE userID='"+getDetails.selectedUserId+"'";
          pst = conn.prepareStatement(sqlWithImage);
          InputStream is = new FileInputStream(new File(s));
          pst.setBlob(1, is);
          pst.executeUpdate();
      }
          updatePersonalInfo(); 
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
             }
}
         void updatePersonalInfo(){
             conn = SQLCon.ConnectDB();
             try{
                 String sql = "update user_personal_info set birthDate='"+((JTextField)txtDOB.getDateEditor().getUiComponent()).getText()+"',bloodType='"+cboBloodType.getSelectedItem()+"' where userID='"+getDetails.selectedUserId+"'";
                 pst=conn.prepareStatement(sql);
              pst.executeUpdate();
              JOptionPane.showMessageDialog(null, "User Successfully Updated!","",JOptionPane.INFORMATION_MESSAGE);
             }catch(Exception e){
                  JOptionPane.showMessageDialog(null, e);
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

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblSelectedRowUserID = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        txtMname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        cboGender = new javax.swing.JComboBox<>();
        txtFname = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cboBloodType = new javax.swing.JComboBox<>();
        txtDOB = new com.toedter.calendar.JDateChooser();
        lblUserID = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtPass2 = new javax.swing.JPasswordField();
        txtUsernname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboUserType = new javax.swing.JComboBox<>();
        lblImage = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blood Bank");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("UPDATE USER");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 0, 170, 40);

        lblSelectedRowUserID.setText("jLabel1");
        lblSelectedRowUserID.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblSelectedRowUserIDPropertyChange(evt);
            }
        });
        jPanel1.add(lblSelectedRowUserID);
        lblSelectedRowUserID.setBounds(620, 20, 50, 14);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bloodbank/image/backbutton.png"))); // NOI18N
        jLabel15.setToolTipText("Back");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15);
        jLabel15.setBounds(0, 0, 50, 40);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PERSONAL INFORMATION", 0, 0, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("User ID");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(20, 30, 80, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Middle Name");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 90, 90, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Last Name");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 120, 80, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Birth Date");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 150, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Gender");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 180, 90, 30);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTACT", 0, 0, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel4.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Address");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(40, 20, 70, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Contact No.");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(10, 80, 100, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("e-Mail");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(50, 50, 50, 30);

        txtAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(txtAddress);
        txtAddress.setBounds(110, 20, 210, 30);

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(txtEmail);
        txtEmail.setBounds(110, 50, 210, 30);

        txtContactNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(txtContactNo);
        txtContactNo.setBounds(110, 80, 210, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(10, 250, 330, 120);

        txtMname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txtMname);
        txtMname.setBounds(120, 90, 210, 30);

        txtLname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txtLname);
        txtLname.setBounds(120, 120, 210, 30);

        cboGender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel3.add(cboGender);
        cboGender.setBounds(120, 180, 140, 30);

        txtFname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txtFname);
        txtFname.setBounds(120, 60, 210, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Blood Type");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(20, 210, 90, 30);

        cboBloodType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboBloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blood Type", "A+", "A-", "B+", "B-", "AB+", "AB-", "O-", "O+" }));
        jPanel3.add(cboBloodType);
        cboBloodType.setBounds(120, 210, 140, 30);

        txtDOB.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(txtDOB);
        txtDOB.setBounds(120, 150, 160, 30);

        lblUserID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUserID.setText("UserID");
        jPanel3.add(lblUserID);
        lblUserID.setBounds(120, 30, 80, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("First Name");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(20, 60, 80, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 0, 350, 380);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACCOUNT INFORMATION", 0, 0, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel5.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Username");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(20, 30, 80, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Password");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(20, 90, 80, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Confirm");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(20, 80, 90, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Password");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(20, 60, 70, 20);

        txtPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(txtPass);
        txtPass.setBounds(100, 60, 200, 30);

        txtPass2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(txtPass2);
        txtPass2.setBounds(100, 90, 200, 30);

        txtUsernname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(txtUsernname);
        txtUsernname.setBounds(100, 30, 200, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("User Type");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(20, 130, 80, 30);

        cboUserType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Staff" }));
        jPanel5.add(cboUserType);
        cboUserType.setBounds(100, 130, 150, 30);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(370, 170, 320, 170);

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblImage);
        lblImage.setBounds(370, 0, 190, 160);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);
        jPanel2.add(jPanel6);
        jPanel6.setBounds(370, 0, 190, 160);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(550, 350, 140, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("REMOVE ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(570, 90, 120, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("ADD IMAGE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(570, 30, 120, 40);

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.jpg","*.png","*.gif","*.bmp");
        fileChooser.addChoosableFileFilter(filter);
        int result=fileChooser.showSaveDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
        File selectedFile = fileChooser.getSelectedFile();
        String path = selectedFile.getAbsolutePath();
        lblImage.setIcon(ResizeImage(path));
        s = path;
        wImage = "Yes";
       // cmdUpdate.setVisible(true);
        //cmdUpdate.setVisible(false);
        }else if(result==JFileChooser.CANCEL_OPTION){
           // lblImage.setIcon(null);
           if(wImage.equals("")){
               wImage= "";
           }else{
            wImage = "No";
           }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      if (txtFname.getText().equals("") || txtMname.getText().equals("") || txtLname.getText().equals("") || ((JTextField)txtDOB.getDateEditor().getUiComponent()).getText().equals("") || txtAddress.getText().equals("") || txtContactNo.getText().equals("") || txtUsernname.getText().equals("") || txtPass.getText().equals("") || txtPass2.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Fill up all Fields","Blood Bank",JOptionPane.ERROR_MESSAGE);
        }else if(cboBloodType.getSelectedItem().equals("Blood Type")){
           JOptionPane.showMessageDialog(null, "Select Blood Type","Blood Bank",JOptionPane.ERROR_MESSAGE);
        }else{
        updateMainInfo();
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:]
        lblImage.setIcon(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lblSelectedRowUserIDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblSelectedRowUserIDPropertyChange
        // TODO add your handling code here:
         
    }//GEN-LAST:event_lblSelectedRowUserIDPropertyChange

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        new Users().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

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
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new UpdateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboBloodType;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JComboBox<String> cboUserType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblImage;
    public static javax.swing.JLabel lblSelectedRowUserID;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNo;
    private com.toedter.calendar.JDateChooser txtDOB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtMname;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass2;
    private javax.swing.JTextField txtUsernname;
    // End of variables declaration//GEN-END:variables
        public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
        }
}
