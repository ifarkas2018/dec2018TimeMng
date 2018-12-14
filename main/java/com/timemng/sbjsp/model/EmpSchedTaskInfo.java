package com.timemng.sbjsp.model;

// EmpSchedTaskInfo - model class ( the class representing the data of the record )
public class EmpSchedTaskInfo {
		
	private Long taskId;
    private String taskName;
    private String taskDate;
    private String taskStartTime;
    private String taskEndTime;
   
    // constructor
    public EmpSchedTaskInfo(Long taskId, String taskName, String taskDate, String taskStartTime, String taskEndTime ) {
        super();
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskStartTime = taskStartTime;
        this.taskEndTime = taskEndTime;
        // this.balance = balance;
    }
 
    public Long getTaskId() {
        return taskId;
    }
 
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
 
    public String getTaskName() {
        return taskName;
    }
 
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
    public String getTaskDate() {
        return taskDate;
    }
 
    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }
    
    public String getTaskStartTime() {
        return taskStartTime;
    }
 
    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }
    
    public String getTaskEndTime() {
        return taskEndTime;
    }
 
    public void setTadskEndTime(String taskEndTime) {
        this.taskEndTime = taskEndTime;
    }
    
    
}