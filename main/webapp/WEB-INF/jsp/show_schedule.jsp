<!--  project : Time Schedule, author : Ingrid Farkas, 2019 -->
<!--  show_schedule.jsp shows the results of the request to list schedule for the certain EMPLOYEE on the certain DAY ( show_sched_form.jsp ) -->
<!--  show_schedule.jsp included in show_sched_results.jsp -->

<!--  include the JSTL Core library -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

	<!-- Contact section -->
	<div class="w3-content">
	    <div class="w3-row w3-margin">
	    	<!-- "w3-third" class uses 33% of the parent container -->
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
	        
	        <!-- "w3-twothird" class uses 66% of the parent container -->
	        <div class="w3-twothird w3-container"> 
	            <!--  Contact section -->
	            <br/>
	            <br/>
	            <!--  w3-light-grey sets the background color of the container -->
	            <div class="w3-container w3-light-grey w3-padding-32 w3-padding-large" id="show_sched_info"> 
	              	<div class="w3-content w3-text" style="max-width:600px">
	              		<!-- black_test CSS rule from the colors.css -->
	                    <h2 class="w3-center black_text"><b>Schedule</b></h2> 
	                      	
	 					<h6>Employee Name: ${enter_f_name} ${enter_l_name}</h6> <!-- showing the employee name -->
	 					<h6>Date of the Schedule: ${enter_date}</h6> <!-- showing the date of the schedule -->
						<form action="/show_task_info" method="get" target="_blank">
						<div>
	      					<!-- creating the table with the tasks -->
	      					<table class="w3-table w3-bordered w3-centered">
	        					<!-- creating the table row with the headings -->
	        					<tr>
	          						<th>Task Name</th>
								  	<th>Start Time</th>
								  	<th>End Time</th>
								  	<th>Action</th>
						        </tr>
						        <!-- for each element of the list empSchedTaskInfos, show the name of the task, the start time and the end time of the task -->
	        					<!-- empSchedTaskInfos is the attribute from the MainController.java, which was added to the model -->
	        					<c:forEach items="${empSchedTaskInfos}" var="schedinfo"> 
	        						<tr class="w3--cell-bottom">
						          		<td>${schedinfo.taskName}</td>	<!-- show the name of the task -->
						          		<td>${schedinfo.taskStartTime}</td> <!-- show the start time of the task -->
						          		<td>${schedinfo.taskEndTime}</td> <!-- show the end time of the task -->
						          		
						          			<!-- <td><input class="w3-input w3-border" name="employee_id" id="employee_id" value="${schedinfo.taskName}"></td> 
						          			<td><input class="w3-input w3-border" name="first_name" id="first_name" value=${enter_f_name}></td>
						          			<td><input class="w3-input w3-border" name="last_name" id="last_name" value="Farkas"></td>
						          			<td><input class="w3-input w3-border" name="date" id="date" value=${ schedinfo.taskDate }></td> --> 
						          			<td>
						          				<spring:url value="/task_update/${schedinfo.taskId}" var="updateURL" />
     											<a href="${updateURL}">Update</a>
						          				<!-- <button class="w3-btn w3-tiny w3-padding-small w3-camo-grey">Update</button> -->
						          			</td> 
						        	</tr>
	        					</c:forEach>
	      					</table>
	    				</div>
	    				</form>
	    			</div>
				</div>
			</div>
		</div> <!-- end of the class="w3-row w3-margin" -->
	</div> <!-- end of the class="w3-content" -->
</div>