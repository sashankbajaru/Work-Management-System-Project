/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jobs;


import java.sql.*;

/**
 *
 * @author sashankbajaru
 */
public class Job {
    private String jobName;
    private String jobDescription;
    private int highSkilled;
    private int mediumSkilled;
    private int lowSkilled;
    private double latitude;
    private double longitude;
    private Time startTime;
    private Date startDate;
    private int amount;
    private int jobRating;
    private int voteCount;
    private int jobID;
    private int jobPriority;
    private int jobStatus;
    private double score;
    
    public double getScore()
    {
        return this.score;
    }
    
    public double getDeadline()
    {
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        double deadline = (date.getTime()-this.startDate.getTime())/(1000.0*3600);
        return deadline;
    }
    public void setScore()
    {   
        this.score = this.jobPriority + Math.sqrt(this.getDeadline())+Math.pow(this.amount,1/3.0);
        
    }
    public int getJobPriority(){
        return this.jobPriority;
    }
    public String  getJobName(){
        return this.jobName;
    }
    public String getJobDescription(){
         return this.jobDescription;
    }
    public int getHighSkilled(){
        return this.highSkilled;
    }
    public int getMediumSkilled(){
        return this.mediumSkilled;
    }
    public int getLowSkilled(){
        return this.lowSkilled;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
    public Time getStartTime(){
        return this.startTime;
    }
    public Date getStartDate(){
        return this.startDate;
    }
    public int getAmount(){
        return this.amount;
    }
    public int getJobRating(){
        return this.jobRating;
    }
    public int getVoteCount(){
        return this.voteCount;
    }
    public int getJobID(){
        return this.jobID;
    }
    public boolean setJobName(String JobName){
         this.jobName=JobName;
         if(JobName!="") return true;
         return false;
    }
    public boolean setjobDescription(String JobDescription){
         this.jobDescription=JobDescription;
         if(JobDescription!="") return true;
         return false;
    }
    public int setHighSkilled(int high){
         this.highSkilled=high;
         return high;
    }
    public int setMediumSkilled(int med){
        this.mediumSkilled=med;
        return med;
    }
    public int setLowSkilled(int low){
        this.lowSkilled=low;
        return low;
    }
    public boolean setLatitude(double lat){
        this.latitude=lat;
        if(8<lat&&lat<38) return true;
        else return false;
    }
    public boolean setLongitude(double lon){
        this.longitude=lon;
        if(68<lon&&lon<98) return true;
        else return false;
    }
    public void setStartTime(Time t){
        this.startTime=t;
    }
    public void setStartDate(Date d){
        this.startDate=d;
    }
    public boolean setAmount(int a){
        this.amount=a;
        if(a>=0) return true;
        else return false;
    }
    public boolean setJobRating(int rating){
         this.jobRating=rating;
         if(rating<0||rating>500) return false;
         else return true;
    }
    public void setVoteCount(int vcount){
        this.voteCount=vcount;
    }
    public void setJobPriority(int prio){
        this.jobPriority=prio;
    }
    private Connection con;
    private PreparedStatement st;
    public int addIntoDatabase() throws Exception{
        try{
            String url="jdbc:mysql://localhost/jobDatabase";
            String uname="sashank";
            String pword="Hello$123";
            String query="insert into jobDatabase.jobTable values (?,?,?,?,?,?,?,?,?,?,?,?,default)";
            Class.forName("com.mysql.jdbc.Driver");
            int count=0;
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/jobDatabase"
                            + "user=sashank&password=Hello$123");
            st = con.prepareStatement(query);
            st.setString(1,this.getJobName());
            st.setString(2,this.getJobDescription());
            st.setInt(3,this.getHighSkilled());
            st.setInt(4,this.getMediumSkilled());
            st.setInt(5,this.getLowSkilled());
            st.setDouble(6, this.getLatitude());
            st.setDouble(7, this.getLongitude());
            st.setTime(8,this.getStartTime());
            //st.setDate(9, date);
            st.setInt(9, this.getAmount());
            st.setInt(10, this.getJobRating());
            st.setInt(11, this.getJobPriority());
            st.setInt(12, this.getVoteCount());
            count = st.executeUpdate();
            //st.close();
            //con.close();
            return count;
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        finally{
            close();
        }
        return 0;
    }
    private void close() {
        try {

            if (st != null) {
                st.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {

        }
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }
}
