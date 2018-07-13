package com.astro.supportwheel.model;

import java.util.ArrayList;
import java.util.List;

public class Schedule 
{
    private ArrayList<ArrayList<Employee>> scheduleList = new ArrayList<ArrayList<Employee>>(7);
    private int day;
    private TimeSpan shiftTime;
    public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	

    public Schedule()
    { 
    	for (int i = 0;i<7;i++)
    	{
    		scheduleList.add(new ArrayList<Employee>());
    	}
      
    }
    
    public void add(int day, TimeSpan shiftTime) throws Exception
    {
       this.day = day;
       this.setShiftTime(shiftTime);
        
    }

	public TimeSpan getShiftTime() {
		return shiftTime;
	}

	public void setShiftTime(TimeSpan shiftTime) {
		this.shiftTime = shiftTime;
	}
    
 

}