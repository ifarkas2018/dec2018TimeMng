// project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.controller;

// importing the packages
import java.util.ArrayList;
import java.util.List;

import com.timemng.sbjsp.dao.EmpSchedTaskDAO;
import com.timemng.sbjsp.model.EmpSchedTaskInfo;
import com.timemng.sbjsp.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class MainController {
 
    // if the requested URL is localhost:8080, method is GET do 
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String index(Model model) {
    	// DELETE this part ??????????????????????? 
        String message = "Hello Spring Boot + JSP";
        model.addAttribute("message", message);
        // END of DELETE this part ??????????????????????? 
        return "index"; // return the index.jsp
    }
    
    // if the requested URL is localhost:8080/add_schedule, method is GET do 
    @RequestMapping(value = { "add_schedule" }, method = RequestMethod.GET)
    public String add_schedule(Model model) {
    	// DELETE this part ??????????????????????? 
        String message = "Add Schedule";
        model.addAttribute("message", message);
     // END of DELETE this part ??????????????????????? 
        return "add_schedule"; // return the add_schedule.jsp
    }
        
    @Autowired
    private EmpSchedTaskDAO empSchedTaskDAO;
    
    // if the requested URL is localhost:8080/show_sched_form, method is GET 
    @RequestMapping(value = "show_sched_form", method = RequestMethod.GET)
    public String show_sched_form(Model model) {
    	return "show_sched_form"; // return the show_sched_form.jsp
    }
    
    // if the requested URL is localhost:8080/show_sched_results, method is POST
    @RequestMapping(value = "show_sched_results", method = RequestMethod.POST)
    // employee_id is an input element in show_sched_fcont.jsp. There the user entered the id and name of the employee whose schedule he wants to see
    // and the date of the schedule
	public String show_sched_results(Model model, @RequestParam(value="employee_id", required=true ) String enter_emp_id, // 
		@RequestParam(value="first_name", required=true) String enter_f_name, @RequestParam(value="last_name", required=true) String enter_l_name, //
		@RequestParam(value="date", required=true) String enter_date) {
		 
    	// ??????????????? , required=true 
    	// add to the SQL query the where part - where ( e.emp_id = entered value for emp_id ) and ( e.first_name = entered value for enter_f_name ) 
    	// AND ( e.last_name = entered value for enter_l_name ) AND ( ta.task_date = entered value for the date )
		 empSchedTaskDAO.addToQueryStr(enter_emp_id, enter_f_name, enter_l_name, enter_date );
		 // retrieve the schedule ( with tasks ) for the requested employee on the requested date
		 List<EmpSchedTaskInfo> list = empSchedTaskDAO.getSchedules();
		 
		 // add the schedule of the employee as the attribute to the model 
		 model.addAttribute("empSchedTaskInfos", list);
		 // add the first name as the attribute to the model
		 model.addAttribute("enter_f_name", enter_f_name ); 
		 // add the last name to the model
		 model.addAttribute("enter_l_name", enter_l_name );
		 // add the date ( of the schedule ) to the model
		 model.addAttribute("enter_date", enter_date ); 
		 
		 // show_schedule.jspe is the content of the web page, when show_sched_results is the part of the URL
		 //model.addAttribute("content_URL","show_schedule.jsp");
		
		 return "show_sched_results"; // show the show_sched_results.jsp
	 }
    
    /*
    @RequestMapping(value= { "show_task_info" }, method = RequestMethod.POST)
    public String show_task_info(Model model, @RequestParam(value="employee_id") String employee_id, //
    		@RequestParam(value="first_name") String enter_f_name ) {
    	model.addAttribute("employee_id", employee_id);  
    	return "show_task_info";
    } */
    
    /*
    @RequestMapping(value = { "/show_task_info" }, method = RequestMethod.GET)
    public String show_task_info(Model model, @RequestParam(value="employee_id") String employee_id ) {
    	model.addAttribute("employee_id", employee_id);  
    	return "show_task_info";
    }
    */
    
    @RequestMapping(value = { "/task_update/{id}" }, method = RequestMethod.GET)
    public String task_update(Model model, @PathVariable("id") Long id) {
    	EmpSchedTaskInfo task_info = empSchedTaskDAO.findTask(id);
    	model.addAttribute("task_info", task_info);
    	return "show_task_info";
    }
    
    
    
    
    @RequestMapping(value = { "/test1" }, method = RequestMethod.GET)
    public String test(Model model) {
    	return "test1";
    }
    
    @RequestMapping(value = { "/accounts1" }, method = RequestMethod.GET)
    public String accounts1(Model model) {
    	return "accounts1";
    }
    
    // if the requested URL is localhost:8080/task_list, method is GET do 
    @RequestMapping(value = { "task_list" }, method = RequestMethod.GET)
    public String task_list(Model model) {
 
        String message = "Task List";
        model.addAttribute("message", message);
        return "task_list"; // return the task_list.jsp
    }
    
    // if the requested URL is localhost:8080/task_add, method is GET do 
    @RequestMapping(value = { "task_add" }, method = RequestMethod.GET)
    public String task_add(Model model) {
 
        String message = "Task Add";
        model.addAttribute("message", message);
        return "task_add"; // return the task_add.jsp
    }
    
    // if the requested URL is localhost:8080/task_update, method is GET do 
    @RequestMapping(value = { "task_update" }, method = RequestMethod.GET)
    public String task_update(Model model) {
 
    	// call updateTask(Long id) similarly as empSchedTaskDAO.getSchedules(); in show_sched_task
        String message = "Task Update";
        model.addAttribute("message", message);
        
        return "task_update"; // return the task_update.jsp
    }
    
    // if the requested URL is localhost:8080/task_delete, method is GET do 
    @RequestMapping(value = { "task_delete" }, method = RequestMethod.GET)
    public String task_delete(Model model) {
 
        String message = "Task Delete";
        model.addAttribute("message", message);
        return "task_delete"; // return the task_delete.jsp
    }
 
    // if the requested URL is localhost:8080/contact_us, method is GET do 
    @RequestMapping(value = { "contact_us" }, method = RequestMethod.GET)
    public String contact_us(Model model) {
 
        String message = "Contact Us";
        model.addAttribute("message", message);
        return "contact_us"; // return the contact_us.jsp
    }
    
    // if the requested URL is localhost:8080/log_in, method is GET do 
    @RequestMapping(value = { "log_in" }, method = RequestMethod.GET)
    public String log_in(Model model) {
 
        String message = "Log In";
        model.addAttribute("message", message);
        return "log_in"; // return the log_in.jsp
    }
    
 // if the requested URL is localhost:8080/log_out, method is GET do 
    @RequestMapping(value = { "log_out" }, method = RequestMethod.GET)
    public String log_out(Model model) {
 
        String message = "Log Out";
        model.addAttribute("message", message);
        return "log_out"; // return the log_out.jsp
    }
}
