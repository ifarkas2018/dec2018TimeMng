// project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.dao;

// importing the packages
import java.util.List;

import javax.sql.DataSource;
 
// import org.o7planning.sbjdbc.exception.BankTransactionException;
import com.timemng.sbjsp.mapper.EmpSchedTaskMapper;
import com.timemng.sbjsp.model.EmpSchedTaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
@Transactional
public class EmpSchedTaskDAO extends JdbcDaoSupport {
 
    @Autowired
    public EmpSchedTaskDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
 
    // getSchedules - retrieving the schedule for the employee on the requested date as a List of the elements of the type EmpSchedTaskInfo
    public List<EmpSchedTaskInfo> getSchedules() {
    	List<EmpSchedTaskInfo> list=null; // initialising the list
        
    	// BASE_SQL is the String that contains the query onto which one the WHERE clause will be added depending on the values the user entered 
    	// in the form show_sched_form.jsp 
        String sql = EmpSchedTaskMapper.BASE_SQL; 
        try {
        	Object[] params = new Object[] {};
        	// EmpSchedTaskMapper is a mapping class that maps 1 column in the query statement to 1 field in the model class ( EmpSchedTaskInfo.java )
        	EmpSchedTaskMapper mapper = new EmpSchedTaskMapper();
        	// running the query and retrieving the list of the tasks for the employee on the requested date
        	list = this.getJdbcTemplate().query(sql, params, mapper);
        } catch (Exception e) {
        	
        }
        
        return list; // return the list of the tasks for the employee on the requested date
    }
    
    // method removeEmpSpaces removes the empty spaces in the string inString and returns the string without empty spaces
    public String removeEmpSpaces(String inString) {
    	
    	String newString; // the string with no empty spaces
    	
    	newString = inString; 
    	newString = newString.replace(" ", ""); // replacing the white space with no character   
    	
    	return newString;
    }
    
    // converts the date from the format dd/mm/yyyy to the format yyyy-mm-dd ( which is used by the SQL Server )
    public String dateDB(String enteredDate) {
    	String sYear; // the year
    	String sMonth; // the month
    	String sDay; // the day
    	String sDate; // the date in format yyyy-mm-dd
    	sYear = enteredDate.substring(6); // retrieving the year from the string
    	sMonth = enteredDate.substring(3, 5); // retrieving the month
    	sDay = enteredDate.substring(0, 2); // retrieving the day from  the string
    	sDate = sYear + "-" + sMonth + "-" + sDay;
    	return sDate; // return the date in the format used by the SQL server
    }
    
    // add to the SQL query the where part - where ( e.emp_id = entered value for emp_id ) and ( e.first_name = entered value for enter_f_name ) 
	// AND ( e.last_name = entered value for enter_l_name ) AND ( ta.task_date = entered value for the date )
    public void addToQueryStr(String empId, String fName, String lName, String date ) {
    	// resetBASE_SQL sets the string to its original value
    	// if the user ran the Show Schedule before then to the original BASE_SQL got changed so I have to reset it to its original value 
    	EmpSchedTaskMapper.resetBASE_SQL();
    	String sql = EmpSchedTaskMapper.BASE_SQL;
    	
    	// if the user entered an employee id in the Show Schedule form I am changing the SQL query to return the records where the employee id equals the entered value
    	if (!(empId.equals(null))) {
    		sql += "and ( e.emp_id='" + empId + "') ";
    	}
    	
    	// if the user entered a first name in the Show Schedule form I am changing the SQL query to return the records where the first name equals the entered value
    	if (!(fName.equals(null))) {
    		sql += "and ( e.first_name='" + fName + "') ";
    	}
    	
    	// if the user entered a first name in the Show Schedule form I am changing the SQL query to return the records where the first name equals the entered value
    	if (!(lName.equals(null))) {
    		sql += "and ( e.last_name='" + lName + "') ";
    	}
    	
    	// removeEmpSpaces removes the empty spaces from the date 
    	String noEmpSpaces = removeEmpSpaces(date);
    	// dateDB coverts the date from the format dd/mm/yyyy to the format yyyy-mm-dd
    	// sDBFormatDate is the date in the format yyyy-mm-dd
    	String sDBFormatDate = dateDB(noEmpSpaces);
    	
    	// if the user entered a date for the schedule in the Show Schedule form I am changing the SQL query to return the records where the date equals the entered value
    	if (!(sDBFormatDate.equals(null))) {
    		sql += "and ( ta.task_date='" + sDBFormatDate + "') ";
    	}
    	
    	
    	sql += ";";
    	
    	// PROBLEM : if id,name, date are all EMPTY - HANDLE THIS ????????????????????????????????????????????????????????
    	EmpSchedTaskMapper.updateSQL(sql);
    }
}