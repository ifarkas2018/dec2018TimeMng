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
        </div>

		<!--  
        <div class="w3-twothird w3-container">
            <h2>5 Terre</h2> -->
            <!--  Contact section -->
            <!-- 
            <div class="w3-container w3-light-grey w3-padding-32 w3-padding-large" id="contact">
              	<div class="w3-content" style="max-width:600px">
	                <h4 class="w3-center"><b>Contact Me</b></h4>
	                <p>Do you want me to photograph you? Fill out the form and fill me in with the details :) I love meeting new people!</p>
	                <form action="/action_page.php" target="_blank">
	                  	<div class="w3-section">
	                    	<label>Name</label>
	                    	<input class="w3-input w3-border" type="text" name="Name" required>
	                  	</div>
	                  	<div class="w3-section">
	                    	<label>Email</label>
	                    	<input class="w3-input w3-border" type="text" name="Email" required>
	                  	</div>
	                  	<div class="w3-section">
	                    	<label>Message</label>
	                    	<input class="w3-input w3-border" type="text" name="Message" required>
	                  	</div>
	                  	<button type="submit" class="w3-button w3-block w3-black w3-margin-bottom">Send Message</button>
	                </form>
              	</div>
            </div>
            <br /> -->
        <!--  </div> --> <!-- end of class="w3-twothird w3-container" -->
        <!--  <br/>
        <br/> -->
        <!-- 
        <div class="w3-twothird w3-container">
        <div class="w3-container w3-light-grey w3-padding-32 w3-padding-large" id="sched_empl_form">
            <div class="w3-content" style="max-width:600px">
		        <form> <!-  class="w3-card-4 " ->
					<h2>Bordered Input</h2>
					<p>Add the w3-border class to create bordered inputs.</p>
					
					<p><label>First Name</label>
					<input class="w3-input w3-border" name="first" type="text"></p>
					
					<p><label>Last Name</label>
					<input class="w3-input w3-border" name="last" type="text"></p>
					<br/>
					<br/>
					<br/>
					<br/>
					<br/>
					<br/>
					<br/>
				</form>
				<br/>
				<br/>
			</div>
		</div>
        </div> -->
        <!--  <br/>
        <br/> -->
        <div class="w3-twothird w3-container">
            <!--  <h2>5 Terre</h2> --> 
            <!--  Contact section -->
            <br/>
            <br/>
            <!--  w3-text-theme-m1 CSS rule which sets the color of the text ( file colors.css ) -->
            <div class="w3-container  w3-light-grey w3-padding-32 w3-padding-large" id="show_sched_info"> <!-- w3-light-grey w3-theme-m1 -->
              	<div class="w3-content w3-text" style="max-width:600px">
 
	                <h4 class="w3-center black_text"><b>Show Schedule</b></h4>
	                <!--  <p>Do you want me to photograph you? Fill out the form and fill me in with the details :) I love meeting new people!</p> -->
	                <form action="/show_sched_results" method="post" target="_blank">
	                  	<div class="w3-section">
	                    	<label>Employee ID</label>
	                    	<!--  when removing REQUIRED go to MainController, show_schedule, and in method show_schedule remove required=true 
	                    			for the employee_id -->
	                    	<input class="w3-input w3-border" type="text" name="employee_id" required>
	                  	</div>
	                  	<div class="w3-section">
	                    	<label>First Name</label>
	                    	<!--  when removing REQUIRED go to MainController, show_schedule, and in method show_schedule remove required=true 
	                    		  for the employee_id -->
	                    	<input class="w3-input w3-border" type="text" name="first_name" required>
	                  	</div>
	                  	<div class="w3-section">
	                    	<label>Last Name</label>
	                    	<!--  when removing REQUIRED go to MainController, show_schedule, and in method show_schedule remove required=true
	                    		   for the last-name -->
	                    	<input class="w3-input w3-border" type="text" name="last_name" required>
	                  	</div><div class="w3-section">
	                    	<label>Date ( format dd/mm/yyyy )</label>
	                    	<!--  when removing REQUIRED go to MainController, show_schedule, and in method show_schedule remove required=true 
	                    		  for the date -->
	                    	<input class="w3-input w3-border" type="text" name="date" required>
	                  	</div>
	                  	<!-- <button type="submit" class="w3-button w3-block w3-black w3-margin-bottom">Send Message</button> -->
	                  	<button class="w3-btn w3-camo-grey">Submit</button> 
	                </form>
              	</div>
            </div>
            <br />
        </div>  <!-- end of class="w3-twothird w3-container" -->
    </div> <!-- end of class="w3-row w3-margin" --> 
    </div> <!-- end of the contact section -->
</div> <!-- end of class="content" -->
