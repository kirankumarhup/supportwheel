package com.astro.supportwheel.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.astro.supportwheel.model.Employee;
import com.astro.supportwheel.model.TimeSpan;




@RestController
public class EmployeeSupportWheelOfFateController {

	
	final static Logger logger = Logger.getLogger(EmployeeSupportWheelOfFateController.class);

	/**
	 *  Support of Wheel fate employee scheduler
	 * 
	 * @return employees.
	 * @throws Exception 
	 */

	@RequestMapping(value = "/api/v1/schedule/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  ResponseEntity<Map<String, List<Employee>>> employeeSchedule()
			throws Exception {

		
			logger.info("Start - EmployeeSupportWheelOfFateController - employeeSchedule Method");
			
			ResponseEntity<Map<String, List<Employee>>> scheduleResponse = new ResponseEntity(HttpStatus.OK);
			
			List<Employee> employeeWeek1List = initEmployees();
			List<Employee> employeeWeek2List = initEmployees();
			Map<String, List<Employee>> employeeMap = new HashMap();
			employeeMap.put("week1", employeeWeek1List);
			employeeMap.put("week2", employeeWeek2List);
		
			logger.info("End - EmployeeSupportWheelOfFateController - employeeSchedule Method");
			if (employeeMap.isEmpty())
				scheduleResponse = new ResponseEntity<Map<String, List<Employee>>>(HttpStatus.NO_CONTENT);
			else
				scheduleResponse = new ResponseEntity<Map<String, List<Employee>>>(employeeMap, HttpStatus.OK);
			
			return scheduleResponse;
		

	}
	

	
	private List<Employee> initEmployees() throws Exception{
		
		logger.info("Start - EmployeeSupportWheelOfFateController - initEmployees Method");
		
		List<Employee> employeeList = new ArrayList();
		Employee employee1 = new Employee("Anis","Aisar");
		employee1.addShift(generateDay(employeeList), generateTimeSpan());
		employeeList.add(employee1);
		
		Employee employee2 = new Employee("ahmad","ameer");
		employee2 = shiftConflictsCheck(employee2,employeeList);
		employeeList.add(employee2);
		
		Employee employee3 = new Employee("hana","Ivan");
		employee3 = shiftConflictsCheck(employee3,employeeList);
		employeeList.add(employee3);
		
		Employee employee4 = new Employee("Michelle","Jeremy");
		employee4 = shiftConflictsCheck(employee4,employeeList);
		employeeList.add(employee4);
		
		Employee employee5 = new Employee("Jack","mory");
		employee5 = shiftConflictsCheck(employee5,employeeList);
		employeeList.add(employee5);
		
		Employee employee6 = new Employee("Hani","yusrii");
		employee6 = shiftConflictsCheck(employee6,employeeList);
		employeeList.add(employee6);
		
		Employee employee7 = new Employee("Alex","ron");
		employee7 = shiftConflictsCheck(employee7,employeeList);
		employeeList.add(employee7);
		
		Employee employee8 = new Employee("Amanda","Danny");
		employee8 = shiftConflictsCheck(employee8,employeeList);
		employeeList.add(employee8);
		
		Employee employee9 = new Employee("Hay","Ben");
		employee9 = shiftConflictsCheck(employee9,employeeList);
		employeeList.add(employee9);
		
		Employee employee10 = new Employee("Jay","Chan");
		employee10 = shiftConflictsCheck(employee10,employeeList);
		employeeList.add(employee10);
		
	
		logger.info("End - EmployeeSupportWheelOfFateController - initEmployees Method");
		
		return employeeList;
	}

	private TimeSpan generateTimeSpan(){
		TimeSpan shiftTime = new TimeSpan();
		shiftTime.generateTime();
		
		return shiftTime;
	}
	
	private int generateDay(List<Employee> employeeList){
		Random ran = new Random();
		int min = 1;  
		int max = 5; 
		int day = min + ran.nextInt(max - min + 1);    
	
		return day;
	}
	
	public boolean doesShiftConflict(List<Employee> empList, int day, TimeSpan shiftTime)
    {
    
    	boolean conflict = false;
    	if(empList !=null){
	    	for(Employee emp: empList){
	    		if(emp !=null && emp.getSchedule().getDay() == day && emp.getSchedule().getShiftTime().getTimeIn() == shiftTime.getTimeIn() && emp.getSchedule().getShiftTime().getTimeOut() == shiftTime.getTimeOut()) {
	    			conflict = true;
	    		}else
	    			conflict = false;
	    	}
    	}
        return conflict;
    }
	
	public Employee shiftConflictsCheck(Employee employee, List<Employee> employeeList) throws Exception{
		TimeSpan timeSpan = generateTimeSpan();
		int day = generateDay(employeeList);
		if(!doesShiftConflict(employeeList,day,timeSpan)){
			employee.addShift(day,timeSpan );
			//employeeList.add(employee);
		}else{
			
					if(timeSpan.getTimeIn()==9.00){
						timeSpan.setTimeIn(13.00);
						timeSpan.setTimeOut(18.00);
					}
					if(timeSpan.getTimeIn()==13.00){
						timeSpan.setTimeIn(9.00);
						timeSpan.setTimeOut(12.00);
					}
					employee.addShift(day,timeSpan);
	    		}
			
		
		return employee;
	}
}