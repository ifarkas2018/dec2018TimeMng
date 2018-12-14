package com.timemng.sbjsp.dao;


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
 
    public List<EmpSchedTaskInfo> getSchedules() {
    	List<EmpSchedTaskInfo> list=null;
        // Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
    	// Select ta.task_id, ta.task_name From task ta
        String sql = EmpSchedTaskMapper.BASE_SQL;
        try {
        	Object[] params = new Object[] {};
        	EmpSchedTaskMapper mapper = new EmpSchedTaskMapper();
        	list = this.getJdbcTemplate().query(sql, params, mapper);
        } catch (Exception e) {
        	
        }
        
        return list;
    }
    
    // method removeEmpSpaces removes the empty spaces in the string inString and returns the string without empty spaces
    public String removeEmpSpaces(String inString) {
    	
    	String newString; // the string with no empty spaces
    	
    	newString = inString; 
    	newString = newString.replace(" ", ""); // replacing the white space with no character   
    	
    	return newString;
    }
    
    // from the date in the format dd/mm/yyyy makes the format yyyy-mm-dd ( which is used by the SQL Server )
    public String dateDB(String enteredDate) {
    	String sYear; // the year
    	String sMonth; // the month
    	String sDay; // the day
    	String sDate; // the date in format yyyy-mm-dd
    	sYear = enteredDate.substring(6);
    	sMonth = enteredDate.substring(3, 5);
    	sDay = enteredDate.substring(0, 2);
    	sDate = sYear + "-" + sMonth + "-" + sDay;
    	return sDate;
    }
    
    // add to the SQL query the where part - where ( e.emp_id = entered value for emp_id ) and ( e.first_name = entered value for enter_f_name ) 
	// AND ( e.last_name = entered value for enter_l_name ) AND ( ta.task_date = entered value for the date )
    public void addToQueryStr(String empId, String fName, String lName, String date ) {
    	// reset_BASE_SQL sets the string to its original value
    	// if the user ran the Show Schedule before then to the original BASE_SQL got changed so I have to reset it to its original value 
    	EmpSchedTaskMapper.resetBASE_SQL();
    	String sql = EmpSchedTaskMapper.BASE_SQL;
    	// if the user entered an employee id in the Show Schedule form I am changing the SQL query to return the records where the employee id equals the entered value
    	if (!(empId.equals(null))) {
    		sql += "and ( e.emp_id='" + empId + "') ";
    	}
    	
    	if (!(fName.equals(null))) {
    		sql += "and ( e.first_name='" + fName + "') ";
    	}
    	
    	if (!(lName.equals(null))) {
    		sql += "and ( e.last_name='" + lName + "') ";
    	}
    	
    	String noEmpSpaces = removeEmpSpaces(date);
    	// sDBFormatDate is the date in the format yyyy-mm-dd
    	String sDBFormatDate = dateDB(noEmpSpaces);
    	if (!(sDBFormatDate.equals(null))) {
    		sql += "and ( ta.task_date='" + sDBFormatDate + "') ";
    	}
    	
    	
    	sql += ";";
    	
    	// PROBLEM : if id,name, date are all EMPTY - HANDLE THIS ????????????????????????????????????????????????????????
    	EmpSchedTaskMapper.updateSQL(sql);
    }
}