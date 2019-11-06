
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sashankbajaru
 */
public class feedbackConnect {
    Connection con;
    public Connection getCon() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost/feedbackDatabase?"
                            + "user=dewang&password=Hello$123");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(feedbackConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
            //int count=0;
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workerDatabase","sashank","Hello$123");
            
        return con;
    }
}
