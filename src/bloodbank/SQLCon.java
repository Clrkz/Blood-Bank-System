/*
*(C) Google & YouTube
* Clrkz - Revision from MySQL to MSSQL
* Thanks: Sr. Alojado
* 2018
*/
package bloodbank;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.xml.transform.Result;
/**
 * @author Clrkz
 */
public class SQLCon {
        /*
     Connection conn=null;
    public static Connection ConnectDB(){
        try{
            String url = "jdbc:jtds:sqlserver://CORE-I3/TeambogDB;instance=SQLEXPRESS";
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null, "Connected to Database");
            return conn;
        }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    return null;
}
}
      */
  // SQLJDBC4.JAR
     Connection conn=null;
    public static Connection ConnectDB(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=bloodbankFinal;user=CLJS;password=12345");
            //JOptionPane.showMessageDialog(null, "Connected to Database");
            return conn;
        }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    return null;
}
}
   
    
    /* DIRECT CLASS CONNECTION
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String ConURL = "jdbc:sqlserver://localhost:1433;databaseName=TeambogDB;user=TeamBog;password=12345";
        Connection con = DriverManager.getConnection(ConURL);
      
        JOptionPane.showMessageDialog(null, "Connect Success");
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from TestLogin");
        while(rs.next()){
            int LoginID = rs.getInt(1);
            String ser = rs.getString(2);
            String pw = rs.getString(3);
            System.out.print(LoginID + " "+ ser +" "+pw);
        }

    }*/
}
