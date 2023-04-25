package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import Views.LoginForm;

public class ExamModel {
    public static Connection conn;
    public static PreparedStatement pst;
    public static DefaultTableModel dtm;
	
    public static void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            String ConLink = "jdbc:mysql://"+Host+":3306/"+DbName+"";
            String ConLink = "jdbc:mysql://localhost:3306/db_exam";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_exam", "root", "");    
//            DbConnect.lblTestConnection.setText("Connection is Stablish");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
//            DbConnect.lblTestConnection.setText("Error On Connection");
        }

    }
}
