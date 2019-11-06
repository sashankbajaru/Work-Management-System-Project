<%-- 
    Document   : newjsp
    Created on : 9 Apr, 2019, 7:38:04 PM
    Author     : sashankbajaru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Public Feedback Form</title>
        <style>
       
form .stars {
  background: url("stars.png") repeat-x 0 0;
  width: 150px;
  margin: 0 auto;
}
 
form .stars input[type="radio"] {
  position: absolute;
  opacity: 0;
  filter: alpha(opacity=0);
}
form .stars input[type="radio"].star-5:checked ~ span {
  width: 100%;
}
form .stars input[type="radio"].star-4:checked ~ span {
  width: 80%;
}
form .stars input[type="radio"].star-3:checked ~ span {
  width: 60%;
}
form .stars input[type="radio"].star-2:checked ~ span {
  width: 40%;
}
form .stars input[type="radio"].star-1:checked ~ span {
  width: 20%;
}
form .stars label {
  display: block;
  width: 30px;
  height: 30px;
  margin: 0!important;
  padding: 0!important;
  text-indent: -999em;
  float: left;
  position: relative;
  z-index: 10;
  background: transparent!important;
  cursor: pointer;
}
form .stars label:hover ~ span {
  background-position: 0 -30px;
}
form .stars label.star-5:hover ~ span {
  width: 100% !important;
}
form .stars label.star-4:hover ~ span {
  width: 80% !important;
}
form .stars label.star-3:hover ~ span {
  width: 60% !important;
}
form .stars label.star-2:hover ~ span {
  width: 40% !important;
}
form .stars label.star-1:hover ~ span {
  width: 20% !important;
}
form .stars span {
  display: block;
  width: 0;
  position: relative;
  top: 0;
  left: 0;
  height: 30px;
  background: url("stars.png") repeat-x 0 -60px;
  -webkit-transition: -webkit-width 0.5s;
  -moz-transition: -moz-width 0.5s;
  -ms-transition: -ms-width 0.5s;
  -o-transition: -o-width 0.5s;
  transition: width 0.5s;
}
        </style>
    </head>
    
    <body>
     <form id="ratingsForm" action="getData" method="Post">
         <pre>
        <div class="bg-image"></div>
        <div style="background-color:blue;padding:0.5px"><h1 align="center"; style="color:white;">Public Feedback Form</h1></div>
        <div style="width:800px; margin:0 auto;"><h2 style="color:red">Are you satisfied with our work? Please fill the feedback form and tell us how you feel</h2></div>
        <h3 align="center">Please fill your details</h3>
        <p align="center">Name:<input type="text" name="name" placeholder="Type your name"/>
        </p>

       
        <p align="center">Job Name:<input type="text" name="jobname" placeholder="Type Job name"/>
        </p>

        <p align="center">Remarks(If Any):<input type="text" name="remarks" placeholder="Type remarks"/>
        </p>

 

     </pre>
    <div class="stars">
        <input type="radio" name="star" value="1" class="star-1" id="star-1"/>
        <label class="star-1" for="star-1">1</lable>
        <input type="radio" name="star" value="2" class="star-2" id="star-2"/>
        <label class="star-2" for="star-2">2</label>
        <input type="radio" name="star" value="3"class="star-3" id="star-3"/>
        <label class="star-3" for="star-3">3</label>
        <input type="radio" name="star" value="4" class="star-4" id="star-4" />
        <label class="star-4" for="star-4">4</label>
        <input type="radio" name="star" value="5" class="star-5" id="star-5" />
        <label class="star-5" for="star-5">5</label>
        <span></span>
        
    </div>
         <br>
         <p align="center">(Please rate the work out of 5)</p>
          <br>
           <br>
         <p align="center"><input type="submit" value="Submit"/></p>
     </form>

        
        
        
        
    </body>
</html>
