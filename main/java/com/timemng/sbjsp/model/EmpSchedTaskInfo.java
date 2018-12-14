// project : Time Schedule, author : Ingrid Farkas, 2019 
package com.timemng.sbjsp.model;

// EmpSchedTaskInfo - model class ( the class representing the data of the record )
public class EmpSchedTaskInfo {
		
	private Long taskId; // the id of the task
    private String taskName; // the name of the task
    private String taskDate; // the date of the task
    private String taskStartTime; // the start time of the task
    private String taskEndTime; // the end time of the task
   
    // constructor of the class
    public EmpSchedTaskInfo(Long taskId, String taskName, String taskDate, String taskStartTime, String taskEndTime ) {
        super();
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskStartTime = taskStartTime;
        this.taskEndTime = taskEndTime;
    }
 
    // get the task id of the task
    public Long getTaskId() {
        return taskId;
    }
 
    // set the task id of the task
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
 
    // get the task name of the task
    public String getTaskName() {
        return taskName;
    }
 
    // set the task name of the task
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
    // get the date of the task
    public String getTaskDate() {
        return taskDate;
    }
 
    // set the date of the task
    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }
    
    // get the start time of the task
    public String getTaskStartTime() {
        return taskStartTime;
    }
 
    // set the start time of the task
    public void setTaskStartTime(String taskStartTime) {
        this.taskStartTime = taskStartTime;
    }
    
    // get the end time of the task
    public String getTaskEndTime() {
        return taskEndTime;
    }
 
    // set the end time of the task
    public void setTadskEndTime(String taskEndTime) {
        this.taskEndTime = taskEndTime;
    }
}