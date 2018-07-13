package com.astro.supportwheel.model;

import java.util.ArrayList;
import java.util.List;

public class Employee 
{
    private boolean availability;    
    private boolean shiftsTaken;    
    private String firstName;
    private String lastName;
    private Schedule schedule;
  
   

	public Employee(String fName,String lName)
    {
        firstName = fName;
        lastName = lName;
        availability = false;
        shiftsTaken = false;
        schedule = new Schedule();
        setSchedule(schedule);
    }

    public void addShift(int day, TimeSpan shiftTime) throws Exception
    {
    	schedule.setDay(day);
    	schedule.setShiftTime(shiftTime);
        shiftsTaken = true;
        availability = true;
    }

 

    
    
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
    public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
   
}
