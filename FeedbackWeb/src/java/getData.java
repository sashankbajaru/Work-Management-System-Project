/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.println;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author sashankbajaru
 */
public class getData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         
/*       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletConnect</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletConnect athjsdhk hello" + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            String name=request.getParameter("uname");
            int rating_int;
            rating_int = Integer.parseInt(request.getParameter("star"));
            /*String rating[];
            rating =new String[5];
        rating[0]=request.getParameter("star-1");
        rating[1]=request.getParameter("star-2");
        rating[2]=request.getParameter("star-3");
        rating[3]=request.getParameter("star-4");
        rating[4]=request.getParameter("star-5");
        for(int i=0;i<5;i++){
            if(rating[i]=="on"){
                rating_int=i+1;
                break;
            }
        }*/
        String ipAddress =  request.getRemoteAddr();
        String jobName = request.getParameter("jobname");
        String remarks = request.getParameter("remarks");
        
        //feedbackConnect obj=new feedbackConnect();
        Connection con=null;
        String query;
        PreparedStatement st;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost/feedbackDatabase?"
                            + "user=sashank&password=Hello$123");
            query = "select * from feedbackDatabase.feedbackTable1 where ipAddress = ? and jobName = ?;";
            st = con.prepareStatement(query);
            st.setString(1,ipAddress);
            st.setString(2, jobName);
            ResultSet r1 = st.executeQuery();
            int count = 0;
            while(r1.next())
            {
                count++;
            }
            if(count!=0)
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Feedback Already Recorded</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>We Already have a feedback recorded from you!</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            
            else if(jobName.equals("")||rating_int==0)
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Feedback form incomplete!</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your feedback form was not filled! Filling job name and a non zero rating is compulsory!</h1>");
            out.println("</body>");
            out.println("</html>");
                
            }
            
            else{
                
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Feedback Inserted!</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your feedback has been recorded successfully!</h1>");
            out.println("</body>");
            out.println("</html>");
            
        try{
        query="insert into feedbackDatabase.feedbackTable1 values (?,?,?,?,?);";
        st=con.prepareStatement(query);
        st.setString(1,name);
        st.setString(2,jobName);
        st.setInt(3,rating_int);
        st.setString(4,remarks);
        st.setString(5,ipAddress);
        st.executeUpdate();
        st.close();
        con.close();
        }
        catch(Exception e)
        {}
        
           con = DriverManager.getConnection("jdbc:mysql://localhost/jobDatabase?"+ "user=sashank&password=Hello$123");
           st = con.prepareStatement("select * from jobDatabase.jobTable1 where jobName = ?; ");
           st.setString(1,jobName);
           ResultSet resultSet = st.executeQuery();
           int jobid = -1;
           while(resultSet.next())
           {
               jobid = resultSet.getInt("jobID");
               break;
           }
           
           con.close();
           st.close();
           
           con = DriverManager.getConnection("jdbc:mysql://localhost/workerDatabase?"+ "user=sashank&password=Hello$123");

           st = con.prepareStatement("UPDATE workerDatabase.workerTable SET ratingPoints = ratingPoints+? where workingOnJob= ? ; ");
           st.setInt(1,(rating_int-3)*5);
           st.setInt(2,jobid);
           st.executeUpdate();


           st.close();
           con.close();            
           
           
            


            
         }
        }
        //System.out.println("hello");
        catch(Exception e){
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Oops</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>The following error occured : " + e + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
        
    }
     catch(Exception e)
     {}
        
        
    }
    protected void dopost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
    {
        //response.sendRedirect("test.jsp");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
