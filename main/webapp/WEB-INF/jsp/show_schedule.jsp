<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!--  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
<body> -->


	<!-- Contact section -->
<div class="w3-content">
    <div class="w3-row w3-margin">
    	<div class="w3-third">
            &nbsp; &nbsp; &nbsp; &nbsp;
            <br />
            &nbsp; &nbsp; &nbsp; &nbsp;
            <!-- first image on the left hand side from the form -->
            <img src="../../images/woman_on_phone.jpg" style="width:100%">
            &nbsp; &nbsp; &nbsp; &nbsp;
            <!-- second image on the left hand side from the form -->
            <img src="../../images/woman_with_laptop.jpg" style="width:100%"> 
            <br/>
            <br/>
            <br/>
            <br/>
        </div>
        
        <div class="w3-twothird w3-container">
            <!--  <h2>5 Terre</h2> --> 
            <!--  Contact section -->
            <br/>
            <br/>
            <!--  w3-text-theme-m1 CSS rule which sets the color of the text ( file colors.css ) -->
            <div class="w3-container  w3-light-grey w3-padding-32 w3-padding-large" id="show_sched_info"> <!-- w3-light-grey w3-theme-m1 -->
              	<div class="w3-content w3-text" style="max-width:600px">
                    <h2 class="w3-center black_text"><b>Show Schedule</b></h2>   	
 					<h6>Employee Name: ${enter_f_name} ${enter_l_name}</h6>
 					<h6>Date of the Schedule: ${enter_date}</h6>
	                Employee Id is ${enter_emp_id}             
					First Name is ${enter_f_name}
					Last Name is ${enter_l_name}
					Date is ${enter_date}
					<div>
      					<table class="w3-table w3-bordered w3-centered">
        					<tr>
          						<th>Task Name</th>
					          	<!-- <th>Date</th>  -->
							  	<th>Start Time</th>
							  	<th>End Time</th>
					          	<!-- <th>Last Name</th> -->
					        </tr>
        					<c:forEach items="${empSchedTaskInfos}" var ="schedinfo"> <!-- accountInfos is the attribute from the MainController.java -->
        						<tr>
					          		<td>${schedinfo.taskName}</td>
					          		<!-- <td>${schedinfo.taskDate}</td> -->
					          		
					          		<td>${schedinfo.taskStartTime}</td>
					          		<td>${schedinfo.taskEndTime}</td> 
					          		<!-- <td>${person.lastName}</td> -->
					        	</tr>
        					</c:forEach>
      					</table>
    				</div>
    			</div>
			</div>
		</div>
	</div>
</div>
</div>
<!--  </body>
</html> -->