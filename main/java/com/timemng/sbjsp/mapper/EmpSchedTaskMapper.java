package com.timemng.sbjsp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
 
import com.timemng.sbjsp.model.EmpSchedTaskInfo;
import org.springframework.jdbc.core.RowMapper;

// EmpSchedTaskMapper - a mapper class (used for mapping corresponding to 1-1 between 1 column in the result of the query statement and 1 field in the model class )
public class EmpSchedTaskMapper implements RowMapper<EmpSchedTaskInfo> {
	/*
    public static final String BASE_SQL //
            = "Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba ";
 	*/
    
	/*
	 public static String BASE_SQL // final
     = "Select ta.task_id, ta.task_name, ta.task_date, ta.start_time, ta.end_time From task ta "; */
	
	public static String BASE_SQL // final
	= "select e.emp_id, s.emp_id, ta.task_id, ta.task_name, ta.task_date, ta.start_time, ta.end_time from employee e, schedule s, task ta"  //
	+ " where (e.emp_id = s.emp_id ) and (s.sched_id = ta.sched_id) ";
	
	// resetBASE_SQL sets the string BASE_SQL to its original value
	public static void resetBASE_SQL() {
		BASE_SQL = "select e.emp_id, s.emp_id, ta.task_id, ta.task_name, ta.task_date, ta.start_time, ta.end_time from employee e, schedule s, task ta"  //
				+ " where (e.emp_id = s.emp_id ) and (s.sched_id = ta.sched_id) ";
	}
	
	// updating the query string to the new query string built in the class EmpSchedTaskDAO, method addToQueryStr
	 public static void updateSQL(String sql) {
		 BASE_SQL = sql; // sql - new query string
	 }
    
    @Override
    public EmpSchedTaskInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        // Long id = rs.getLong("Id");
        // String fullName = rs.getString("Full_Name");
        // double balance = rs.getDouble("Balance");
        
        Long taskId = rs.getLong("task_id");
        
        String taskName = rs.getString("task_name");
        String taskDate = rs.getString("task_date");
        String taskStartTime = rs.getString("start_time");
        String taskEndTime = rs.getString("end_time");
        
 
        //return new BankAccountInfo(id, fullName, balance);
        return new EmpSchedTaskInfo(taskId, taskName, taskDate, taskStartTime, taskEndTime);
    }
 
}