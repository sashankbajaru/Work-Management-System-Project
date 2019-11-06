/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;
import location.Location;
import java.sql.Time;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

/**
 *
 * @author dewang
 */
public class Worker {


    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public int getWorkingOnJob() {
        return workingOnJob;
    }

    public void setWorkingOnJob(int workingOnJob) {
        this.workingOnJob = workingOnJob;
    }
    private int workerID;    
    private String name;
    private Location address;
    private String skillLevel;      //high,medium,low
    private int availability;       //0 - no;1 - yes
    private String emailID;
    private String phoneNumber;
    private Time startTime;
    private Time finishTime;
    private int jobsDone;
    private int ratingPoints;
    private int workingOnJob;
    private double distance;
    
    public double getDistance()
    {
        return this.distance;
    }
    public void setDistance(double d)
    {
        this.distance = d;
    }
    
    
    public Worker()
    {
        startTime = new Time(0);
        finishTime = new Time(0);
        address = new Location();
    }
    
    public boolean setName(String name)
    {
        this.name = name;
        return true;
    }
    public String getName()
    {
        return this.name;
    }
    public boolean setLocation(double lat,double lon)
    {   
        return this.address.changeLocation(lat, lon);
    }
    public double[] getLocation()
    {
        return this.address.getLocation();
    }
    public boolean setSkillLevel(String skill)
    {
        if(skill.equals("high") || skill.equals("medium") || skill.equals("low"))
        {
            this.skillLevel = skill;
            return true;
        }
        return false;
    }
    public String getSkillLevel()
    {
        return this.skillLevel;
    }
    public boolean setAvailability(int a)
    {
        if (a!=1 && a!=0)
            return false;
        this.availability = a;
        return true;
    }
    public int getAvailability()
    {
        return this.availability;
    }
    public boolean setEmailID(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        if(pat.matcher(email).matches() == true)
        {
            this.emailID = email;
            return true;
        }
        return false;
    }
    public String getEmailID()
    {
        return this.emailID;
    }
    public boolean setPhoneNumber(String no)
    {
        if(no.matches("^[0-9]*$") && no.length()==10)
        {
            this.phoneNumber = no;
            return true; 
        }
        else
        {
            return false;
        }        
    }
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    public boolean setStartTime(Time a)
    {
        this.startTime = a;
        return true;
    }
    public Time getStartTime()
    {
        return this.startTime;
    }
    public boolean setFinishTime(Time a)
    {
        this.finishTime = a;
        return true;
    }
    public Time getFinishTime()
    {
        return this.finishTime;
    }
    public boolean setJobsDone(int a)
    {
        if(a<0 || a<this.jobsDone)
            return false;
        this.jobsDone = a;
        return true;
    }
    public int getJobsDone()
    {
        return this.jobsDone;
    }
    public boolean setRatingPoints(int a)
    {
        if(a<1 || a>500)
        {
            return false;
        }
        this.ratingPoints = a;
        return true;
    }
    
    public int getRatingPoints()
    {
        return this.ratingPoints;
    }
}
