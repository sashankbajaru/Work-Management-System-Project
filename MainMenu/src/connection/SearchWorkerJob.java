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
public class SearchWorkerJob {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public SearchWorkerJob() throws Exception
    {
    }
    
    public int searchByID(int id,JTable table) throws Exception
    {
           connect = DriverManager.getConnection("jdbc:mysql://localhost/workerDatabase?"+ "user="+Username.username+"&password=Hello$123");

            preparedStatement = connect
            .prepareStatement("select * from workerDatabase.workerTable where workerID= ? ; ");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            
        int count = 0;
        while(table.getRowCount() > 0) 
        {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        int columns = resultSet.getMetaData().getColumnCount();
        while(resultSet.next())
        {  
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++)
            {  
                row[i - 1] = resultSet.getObject(i);
            }
            ((DefaultTableModel) table.getModel()).insertRow(resultSet.getRow()-1,row);
            count++;
        }

        resultSet.close();
        preparedStatement.close();
        connect.close();            
        return count;
    }

    public int searchByRating(int id,JTable table) throws Exception
    {
           connect = DriverManager.getConnection("jdbc:mysql://localhost/feedbackDatabase?"+ "user="+Username.username+"&password=Hello$123");

            preparedStatement = connect
            .prepareStatement("select * from feedbackDatabase.feedbackTable1 where rating= ? ; ");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            
        int count = 0;
        while(table.getRowCount() > 0) 
        {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        int columns = resultSet.getMetaData().getColumnCount();
        while(resultSet.next())
        {  
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++)
            {  
                row[i - 1] = resultSet.getObject(i);
            }
            ((DefaultTableModel) table.getModel()).insertRow(resultSet.getRow()-1,row);
            count++;
        }

        resultSet.close();
        preparedStatement.close();
        connect.close();            
        return count;
    }
    
    
    public int searchByQuery(String query,JTable table) throws Exception
    {
           connect = DriverManager.getConnection("jdbc:mysql://localhost/workerDatabase?"+ "user="+Username.username+"&password=Hello$123");
           query+="%";
            preparedStatement = connect
            .prepareStatement("select * from workerDatabase.workerTable where name LIKE ? OR emailID LIKE ?; ");
            preparedStatement.setString(1,query);
            preparedStatement.setString(2,query);
            resultSet = preparedStatement.executeQuery();

        System.out.println("HELLO");
        int count = 0;
        while(table.getRowCount() > 0) 
        {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        int columns = resultSet.getMetaData().getColumnCount();
        while(resultSet.next())
        {  
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++)
            {  
                row[i - 1] = resultSet.getObject(i);
            }
            ((DefaultTableModel) table.getModel()).insertRow(resultSet.getRow()-1,row);
            count++;
        }

        resultSet.close();
        preparedStatement.close();
        connect.close();            
        return count;
    }
    
    public int searchByQueryFeedback(String query,JTable table) throws Exception
    {
           connect = DriverManager.getConnection("jdbc:mysql://localhost/feedbackDatabase?"+ "user="+Username.username+"&password=Hello$123");
           query+="%";
            preparedStatement = connect
            .prepareStatement("select * from feedbackDatabase.feedbackTable1 where name LIKE ? OR remarks LIKE ? or jobName LIKE ?; ");
            preparedStatement.setString(1,query);
            preparedStatement.setString(2,query);
            preparedStatement.setString(3,query);
            resultSet = preparedStatement.executeQuery();

        System.out.println("HELLO");
        int count = 0;
        while(table.getRowCount() > 0) 
        {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        int columns = resultSet.getMetaData().getColumnCount();
        while(resultSet.next())
        {  
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++)
            {  
                row[i - 1] = resultSet.getObject(i);
            }
            ((DefaultTableModel) table.getModel()).insertRow(resultSet.getRow()-1,row);
            count++;
        }

        resultSet.close();
        preparedStatement.close();
        connect.close();            
        return count;
    }
    
    
    public int searchByIDJob(int id,JTable table) throws Exception
    {
           connect = DriverManager.getConnection("jdbc:mysql://localhost/jobDatabase?"+ "user="+Username.username+"&password=Hello$123");

            preparedStatement = connect
            .prepareStatement("select * from jobDatabase.jobTable1 where jobID= ? ; ");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

         System.out.println("HELLO");   
        int count = 0;
        while(table.getRowCount() > 0) 
        {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        int columns = resultSet.getMetaData().getColumnCount();
        while(resultSet.next())
        {  
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++)
            {  
                row[i - 1] = resultSet.getObject(i);
            }
            ((DefaultTableModel) table.getModel()).insertRow(resultSet.getRow()-1,row);
            count++;
        }

        resultSet.close();
        preparedStatement.close();
        connect.close();            
        return count;
    }
    
    
    public int searchByQueryJob(String query,JTable table,int countID) throws Exception
    {
           connect = DriverManager.getConnection("jdbc:mysql://localhost/jobDatabase?"+ "user="+Username.username+"&password=Hello$123");
           query+="%";
            preparedStatement = connect
            .prepareStatement("select * from jobDatabase.jobTable1 where jobName LIKE ? OR jobDescription LIKE ?; ");
            preparedStatement.setString(1,query);
            preparedStatement.setString(2,query);
            resultSet = preparedStatement.executeQuery();

        System.out.println("HELLO");
        int count = 0;
        while(countID==-1&&table.getRowCount() > 0) 
        {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        int columns = resultSet.getMetaData().getColumnCount();
        while(resultSet.next())
        {  
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++)
            {  
                row[i - 1] = resultSet.getObject(i);
            }
            ((DefaultTableModel) table.getModel()).insertRow(resultSet.getRow()-1,row);
            count++;
        }

        resultSet.close();
        preparedStatement.close();
        connect.close();            
        return count;
    }
    
    
    
    
}



