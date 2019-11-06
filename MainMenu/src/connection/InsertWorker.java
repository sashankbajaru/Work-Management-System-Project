/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import worker.Worker;
import username.Username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author sashankbajaru
 */
public class InsertWorker {
    
    Worker newbie;
    public InsertWorker(Worker w)
    {
        newbie = w;

    }
    
    
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/workerDatabase?"
                            + "user="+Username.username+"&password=Hello$123");


            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into  workerDatabase.workerTable values (default, ?, ?, ?, ? , ?, ?,?,?,?,?,?,?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            preparedStatement.setString(1, newbie.getName());
            preparedStatement.setDouble(2, newbie.getLocation()[1]);
            preparedStatement.setDouble(3, newbie.getLocation()[0]);
            preparedStatement.setString(4, newbie.getSkillLevel());
            preparedStatement.setInt(5, newbie.getAvailability());
            preparedStatement.setString(6, newbie.getEmailID());
            preparedStatement.setString(7,newbie.getPhoneNumber());//Handle large numbers pls
            preparedStatement.setTime(8,newbie.getStartTime());
            preparedStatement.setTime(9,newbie.getFinishTime());
            preparedStatement.setInt(10,newbie.getJobsDone());
            preparedStatement.setInt(11,newbie.getRatingPoints());
            preparedStatement.setInt(12,newbie.getWorkingOnJob());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }
    
    
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
    
    
    
    
    
}
