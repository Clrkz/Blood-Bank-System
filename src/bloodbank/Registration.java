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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author CORE
 */
public class Registration extends javax.swing.JFrame {
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
String wImage = "No";
String s;
    /**
     * Creates new form Main
     */
    public Registration() {
        initComponents();
    }
void checkValues(){
      if (jTextField1.getText().equals("") || jTextField5.getText().equals("") || jTextField4.getText().equals("") || ((JTextField)jTextField3.getDateEditor().getUiComponent()).getText().equals("") || jTextField2.getText().equals("") || jTextField7.getText().equals("") || jTextField8.getText().equals("") || jPasswordField2.getText().equals("") || jPasswordField1.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Fill up all Fields","Blood Bank",JOptionPane.ERROR_MESSAGE);
        }else if(jComboBox3.getSelectedItem().equals("Blood Type")){
           JOptionPane.showMessageDialog(null, "Select Blood Type","Blood Bank",JOptionPane.ERROR_MESSAGE);
        }else{
        insertMainInfo();
         }
}
public void insertMainInfo(){
     if(jPasswordField2.getText().equals(jPasswordField1.getText())){
         String sql = "insert into users (fName,mName,lName,gender,userType,username,password,image,archiveStatus) values (?,?,?,?,?,?,?,?,?) ";
         Connection conn=SQLCon.ConnectDB();
         try{
             pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,jTextField1.getText());
            pst.setString(2,jTextField5.getText());
            pst.setString(3,jTextField4.getText());
            pst.setString(4, (String) jComboBox1.getSelectedItem());
            pst.setString(5, (String) jComboBox2.getSelectedItem());
            //pst.setString(5,((JTextField)jTextField3.getDateEditor().getUiComponent()).getText());
            pst.setString(6, jTextField8.getText());
            pst.setString(7,jPasswordField2.getText());
            if(wImage.equals("No")){
            pst.setString(8, "");
            }else{
            InputStream is = new FileInputStream(new File(s));
            pst.setBlob(8, is);
            }
            pst.setInt(9, 0);
            pst.executeUpdate();
             rs = pst.getGeneratedKeys();
             rs.next();
           long pk = rs.getLong(1);
       getDetails.userId = String.valueOf(pk); 
            //new MainForm().setVisible(true);
            //this.dispose();
            //JOptionPane.showMessageDialog(null, "User Successfully Registered");
            insertPersonalInfo();
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
             }
         }else{
         JOptionPane.showMessageDialog(null, "Password not Match","Blood Bank",JOptionPane.ERROR_MESSAGE);
        }
}
void insertPersonalInfo(){
    conn = SQLCon.ConnectDB();
    try{
        String sql = "insert into user_personal_info (userID,birthDate,bloodType) values (?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, getDetails.userId);
        pst.setString(2,((JTextField)jTextField3.getDateEditor().getUiComponent()).getText());
        pst.setString(3, (String) jComboBox3.getSelectedItem());
        pst.executeUpdate();
        insertContactInfo();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
}
void insertContactInfo(){
    conn = SQLCon.ConnectDB();
    try{
        String sql = "insert into user_contact_info (userID,eMail,address,contactNo) values (?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, getDetails.userId);
        pst.setString(2,jTextField6.getText());
        pst.setString(3, jTextField2.getText());
        pst.setString(4, jTextField7.getText());
        pst.executeUpdate();
         JOptionPane.showMessageDialog(null, "User Successfully Registered","Blood Bank",JOptionPane.INFORMATION_MESSAGE);
    new Users().setVisible(true);
    this.dispose();
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
        jLabel18 = new javax.swing.JLabel();
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
        jTextField2 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField3 = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
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
        jLabel7.setText("USER REGISTRATION");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 0, 230, 40);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bloodbank/image/backbutton.png"))); // NOI18N
        jLabel18.setToolTipText("Back");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel18);
        jLabel18.setBounds(0, 0, 50, 40);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PERSONAL INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("First Name");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(20, 30, 80, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Middle Name");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 60, 90, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Last Name");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 90, 80, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Birth Date");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 120, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Gender");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 150, 90, 30);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTACT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
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

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(jTextField2);
        jTextField2.setBounds(110, 20, 210, 30);

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(jTextField6);
        jTextField6.setBounds(110, 50, 210, 30);

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.add(jTextField7);
        jTextField7.setBounds(110, 80, 210, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(10, 240, 330, 130);

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(jTextField5);
        jTextField5.setBounds(120, 60, 210, 30);

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(jTextField4);
        jTextField4.setBounds(120, 90, 210, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(120, 150, 140, 30);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(jTextField1);
        jTextField1.setBounds(120, 30, 210, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Blood Type");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(20, 180, 90, 30);

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blood Type", "A+", "A-", "B+", "B-", "AB+", "AB-", "O-", "O+" }));
        jPanel3.add(jComboBox3);
        jComboBox3.setBounds(120, 180, 140, 30);

        jTextField3.setDateFormatString("yyyy-MM-dd");
        jPanel3.add(jTextField3);
        jTextField3.setBounds(120, 120, 160, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 0, 350, 380);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACCOUNT INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
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

        jPasswordField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(jPasswordField2);
        jPasswordField2.setBounds(100, 60, 200, 30);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(jPasswordField1);
        jPasswordField1.setBounds(100, 90, 200, 30);

        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel5.add(jTextField8);
        jTextField8.setBounds(100, 30, 200, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("User Type");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(20, 130, 80, 30);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Staff" }));
        jPanel5.add(jComboBox2);
        jComboBox2.setBounds(100, 130, 150, 30);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(370, 170, 320, 170);

        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel15);
        jLabel15.setBounds(370, 0, 190, 160);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);
        jPanel2.add(jPanel6);
        jPanel6.setBounds(370, 0, 190, 160);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("REGISTER");
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
        jLabel15.setIcon(ResizeImage(path));
        s = path;
        wImage = "Yes";
      //  cmdRegister.setVisible(true);
        //cmdRegister.setVisible(false);
        }else if(result==JFileChooser.CANCEL_OPTION){
            jLabel15.setIcon(null);
            wImage = "No";
          //  cmdRegister.setVisible(true);
           // cmdRegister.setVisible(false);
           // JOptionPane.showMessageDialog(null, "Select an Image","Barangay System",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       checkValues();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:]
        jLabel15.setIcon(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        new Users().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private com.toedter.calendar.JDateChooser jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
        public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(jLabel15.getWidth(), jLabel15.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
        }
}