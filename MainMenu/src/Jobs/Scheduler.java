/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jobs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import username.Username;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import worker.Worker;
import connection.JavaEmail;

/**
 *
 * @author dewang
 */


class SortByCost implements Comparator<Job> {
    public int compare(Job a, Job b) {
        if ( a.getScore() > b.getScore() ) return -1;
        else if ( a.getScore() == b.getScore() ) return 0;
        else return 1;
    }
}

class SortByDistance implements Comparator<Worker> {
    public int compare(Worker a, Worker b) {
        if ( a.getDistance() < b.getDistance() ) return -1;
        else if ( a.getDistance() == b.getDistance() ) return 0;
        else return 1;
    }
}





public class Scheduler {
    
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSetJob = null;
    private ResultSet rsHigh = null;
    private ResultSet rsMedium = null;
    private ResultSet rsLow = null;
    private static double distance(double lat1, double lon1, double lat2, double lon2) 
    {
	if ((lat1 == lat2) && (lon1 == lon2)) {
		return 0;
	}
	else {
		double theta = lon1 - lon2;
		double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;
		return (dist);
	}
    }    
    
    public void runScheduler()
    {   
        try{
        connect = DriverManager.getConnection("jdbc:mysql://localhost/jobDatabase?"+ "user="+Username.username+"&password=Hello$123");
        preparedStatement = connect.prepareStatement("select * from jobDatabase.jobTable1 where jobStatus= 0 ORDER BY jobPriority DESC; ");
        resultSetJob = preparedStatement.executeQuery();
        connect.close();

        
        ArrayList<Job> list_of_jobs = new ArrayList<Job>();
        
        while(resultSetJob.next())
        {
            Job newjob = new Job();
            newjob.setJobID(resultSetJob.getInt("jobID"));
            newjob.setJobName(resultSetJob.getString("jobName"));
            newjob.setjobDescription(resultSetJob.getString("jobDescription"));
            newjob.setHighSkilled(resultSetJob.getInt("highSkilled"));
            newjob.setMediumSkilled(resultSetJob.getInt("mediumSkilled"));
            newjob.setLowSkilled(resultSetJob.getInt("lowSkilled"));
            newjob.setLongitude(resultSetJob.getDouble("longitude"));
            newjob.setLatitude(resultSetJob.getDouble("latitude"));
            newjob.setStartTime(resultSetJob.getTime("startTime"));
            newjob.setAmount(resultSetJob.getInt("amount"));
            newjob.setJobRating(resultSetJob.getInt("jobRating"));
            newjob.setJobPriority(resultSetJob.getInt("jobPriority"));
            newjob.setVoteCount(resultSetJob.getInt("voteCount"));
            newjob.setJobStatus(resultSetJob.getInt("jobStatus"));
            newjob.setStartDate(resultSetJob.getDate("startDate"));
            newjob.setScore();
            if (newjob.getScore()>=0)
                list_of_jobs.add(newjob);
        }
        
        Collections.sort(list_of_jobs,new SortByCost());
        
        for(Job i : list_of_jobs)
        {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/workerDatabase?"+ "user="+Username.username+"&password=Hello$123");
            preparedStatement = connect.prepareStatement("select * from workerDatabase.workerTable where availability = 0 and skillLevel = 'high'; ");
            rsHigh = preparedStatement.executeQuery();
            preparedStatement = connect.prepareStatement("select * from workerDatabase.workerTable where availability = 0 and skillLevel = 'medium'; ");
            rsMedium = preparedStatement.executeQuery();
            preparedStatement = connect.prepareStatement("select * from workerDatabase.workerTable where availability = 0 and skillLevel = 'low'; ");
            rsLow = preparedStatement.executeQuery();
            connect.close();
            
            rsHigh.last();
            int countHigh = rsHigh.getRow();
            rsHigh.beforeFirst();

            rsMedium.last();
            int countMedium = rsMedium.getRow();
            rsMedium.beforeFirst();

            rsLow.last();
            int countLow = rsLow.getRow();
            rsLow.beforeFirst();
            
            if(countHigh<i.getHighSkilled() || countMedium<i.getMediumSkilled() || countLow<i.getLowSkilled())
                continue;
            
            ArrayList<Worker> high = new ArrayList<Worker>();
            ArrayList<Worker> medium = new ArrayList<Worker>();
            ArrayList<Worker> low = new ArrayList<Worker>();
            
            ResultSet rs = rsHigh;
            while(rs.next())
            {
                Worker newbie = new Worker();
                newbie.setWorkerID(rs.getInt("workerID"));
                newbie.setName(rs.getString("name"));
                newbie.setLocation(rs.getFloat("latitude"), rs.getByte("longitude"));
                newbie.setAvailability(rs.getInt("availability"));
                newbie.setEmailID(rs.getString("emailID"));
                newbie.setPhoneNumber(rs.getString("phoneNumber"));
                newbie.setStartTime(rs.getTime("workerStartTime"));
                newbie.setFinishTime(rs.getTime("workerFinishTime"));
                newbie.setJobsDone(rs.getInt("jobsDone"));
                newbie.setRatingPoints(rs.getInt("ratingPoints"));
                newbie.setWorkingOnJob(rs.getInt("workingOnJob"));
                double d = distance(i.getLatitude(),i.getLongitude(),newbie.getLocation()[0],newbie.getLocation()[1]);
                newbie.setDistance(d);
                high.add(newbie);
            }
            
            rs = rsMedium;
            while(rs.next())
            {
                Worker newbie = new Worker();
                newbie.setWorkerID(rs.getInt("workerID"));
                newbie.setName(rs.getString("name"));
                newbie.setLocation(rs.getFloat("latitude"), rs.getByte("longitude"));
                newbie.setAvailability(rs.getInt("availability"));
                newbie.setEmailID(rs.getString("emailID"));
                newbie.setPhoneNumber(rs.getString("phoneNumber"));
                newbie.setStartTime(rs.getTime("workerStartTime"));
                newbie.setFinishTime(rs.getTime("workerFinishTime"));
                newbie.setJobsDone(rs.getInt("jobsDone"));
                newbie.setRatingPoints(rs.getInt("ratingPoints"));
                newbie.setWorkingOnJob(rs.getInt("workingOnJob"));
                double d = distance(i.getLatitude(),i.getLongitude(),newbie.getLocation()[0],newbie.getLocation()[1]);
                newbie.setDistance(d);
                medium.add(newbie);
            }
            
            
            rs = rsLow;
            while(rs.next())
            {
                Worker newbie = new Worker();
                newbie.setWorkerID(rs.getInt("workerID"));
                newbie.setName(rs.getString("name"));
                newbie.setLocation(rs.getFloat("latitude"), rs.getByte("longitude"));
                newbie.setAvailability(rs.getInt("availability"));
                newbie.setEmailID(rs.getString("emailID"));
                newbie.setPhoneNumber(rs.getString("phoneNumber"));
                newbie.setStartTime(rs.getTime("workerStartTime"));
                newbie.setFinishTime(rs.getTime("workerFinishTime"));
                newbie.setJobsDone(rs.getInt("jobsDone"));
                newbie.setRatingPoints(rs.getInt("ratingPoints"));
                newbie.setWorkingOnJob(rs.getInt("workingOnJob"));
                double d = distance(i.getLatitude(),i.getLongitude(),newbie.getLocation()[0],newbie.getLocation()[1]);
                newbie.setDistance(d);
                low.add(newbie);
            }
            
            Collections.sort(high,new SortByDistance());
            Collections.sort(medium,new SortByDistance());
            Collections.sort(low,new SortByDistance());
            int j;
            
            Class.forName("com.mysql.jdbc.Driver");
                //int count=0;
                //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workerDatabase","sashank","Hello$123");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/workerDatabase?"
                           + "user=" + Username.username + "&password=Hello$123");
                     
            for(j=0;j<countHigh;j++)
            {
                high.get(j).setWorkingOnJob(i.getJobID());
                String query = "UPDATE workerDatabase.workerTable SET workingOnJob= ? WHERE workerID = ?;";
                preparedStatement = connect.prepareStatement(query);
                preparedStatement.setInt(1,i.getJobID());
                preparedStatement.setInt(2,high.get(j).getWorkerID());
                preparedStatement.executeUpdate();
                JavaEmail email = new JavaEmail(high.get(j),i);
                email.createEmailMessage();
                email.sendEmail();
            }
        
            for(j=0;j<countMedium;j++)
            {
                medium.get(j).setWorkingOnJob(i.getJobID());
                String query = "UPDATE workerDatabase.workerTable SET workingOnJob= ? WHERE workerID = ?;";
                preparedStatement = connect.prepareStatement(query);
                preparedStatement.setInt(1,i.getJobID());
                preparedStatement.setInt(2,medium.get(j).getWorkerID());
                preparedStatement.executeUpdate();
                JavaEmail email = new JavaEmail(medium.get(j),i);
                email.createEmailMessage();
                email.sendEmail();

            }
        
            for(j=0;j<countLow;j++)
            {
                low.get(j).setWorkingOnJob(i.getJobID());
                String query = "UPDATE workerDatabase.workerTable SET workingOnJob= ? WHERE workerID = ?;";
                preparedStatement = connect.prepareStatement(query);
                preparedStatement.setInt(1,i.getJobID());
                preparedStatement.setInt(2,low.get(j).getWorkerID());
                preparedStatement.executeUpdate();
                JavaEmail email = new JavaEmail(low.get(j),i);
                email.createEmailMessage();
                email.sendEmail();

            }
            
            
            connect.close();
            
            connect = DriverManager.getConnection("jdbc:mysql://localhost/jobDatabase?"+ "user="+Username.username+"&password=Hello$123");
                String query = "UPDATE jobDatabase.jobTable1 SET jobStatus= ? WHERE jobID = ?;";
                preparedStatement = connect.prepareStatement(query);
                preparedStatement.setInt(1,1);
                preparedStatement.setInt(2,i.getJobID());
                preparedStatement.executeUpdate();
            connect.close();           
        }
        
        
        
        
        }
        catch(Exception e)
        {
            System.out.println("While running scheduler,");
            e.printStackTrace();
        }

    }   
    
}
