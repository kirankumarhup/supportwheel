package com.astro.supportwheel.model;

public class TimeSpan
{
    private double timeIn;
    private double timeOut;
    private double time;
    
    public TimeSpan()
    {
   
    }
   
   
    public double getTimeIn()
    {
        return timeIn;
    }
    
    public void setTimeIn(double timeIn)
    {
        this.timeIn = timeIn;
    }
    

    public double getTimeOut()
    {
        return timeOut;
    }


    public void setTimeOut(double timeOut)
    {
        this.timeOut = timeOut;
    }
    
    
    public void generateTime(){
   
     Double min = 9.00;  
     Double max = 13.00; 
     double time = (Math.random()*((max-min)+1))+min;
     setTime(time);
     
     
     if(getTime()<=12.00){
    	 setTimeIn(9.00);
    	 setTimeOut(12.00);
     }else if(getTime()>12.00){
    	 setTimeIn(13.00);
    	 setTimeOut(18.00);
     }
    	 
    }
   
 
    public static void main(String s[]){
    	TimeSpan span = new TimeSpan();
    	span.generateTime();
    	
    }

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

  
}
