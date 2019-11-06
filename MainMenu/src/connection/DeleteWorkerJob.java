/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import username.Username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author sashankbajaru
 */
public class DeleteWorkerJob {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public DeleteWorkerJob() throws Exception
    {
    }
    
    public void deleteID(int id,JTable table) throws Exception
    {
           connect = DriverManager.getConnection("jdbc:mysql://localhost/workerDatabase?"+ "user="+Username.username+"&password=Hello$123");

            preparedStatement = connect
            .prepareStatement("delete from workerDatabase.workerTable where workerID= ? ; ");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            
        preparedStatement.close();
        connect.close();            
        
    }
    public void deleteIDJob(int id,JTable table) throws Exception
    {
           connect = DriverManager.getConnection("jdbc:mysql://localhost/jobDatabase?"+ "user="+Username.username+"&password=Hello$123");

            preparedStatement = connect
            .prepareStatement("delete from jobDatabase.jobTable1 where jobID= ? ; ");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            
        preparedStatement.close();
        connect.close();            
        
    }
    
    
    
    
    
}



