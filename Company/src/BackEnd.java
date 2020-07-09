import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BackEnd {

List<Employee> employees=new ArrayList<Employee>();
	
	public BackEnd(String filePath) throws NotValidDateException, ParseException {
		openFile( filePath);
	}
	
	
	public void openFile(String filePath) throws NotValidDateException, ParseException {
		
			File file =new File(filePath);
				if(!file.exists()) {
					return;
					
				}else if(!file.getName().endsWith(".txt")) {
					return;
				}
				
				
			try {
				Scanner fileInfo =new Scanner(file);
				while(fileInfo.hasNext()) {
					
					String line[] =fileInfo.nextLine().split(",");
				
					if(line.length>4)
						continue;
					
					
					
					
					
					
					
					if(line[3].equals("NULL"))
						line[3]=getCurrentDate();
					
					
					 
					
					
					employees.add(new Employee(line[0],line[1],line[2],line[3]));
					
				}
				fileInfo.close();
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
	}
	
	public String findTwoEmployeeWorkingTheMostAsATeam() {
		
		
			for(int i=0;i<employees.size();i++) {
				for(int j=0;j<employees.size();j++) {
					if(i==j)
						continue;
						
					if(employees.get(i).getId().equals(employees.get(j).getId()))
						continue;
					
					
					
				/*
				 * if(employees.get(i).getStart().before(employees.get(j).getStart())||employees
				 * .get(j).getEnd().after(employees.get(i).getEnd())) {
				 * employees.get(i).getWorkingTime().put(employees.get(i).getId(),
				 * employees.get(j).getStart().compareTo(employees.get(i).getEnd()));
				 * 
				 * }else
				 * if(employees.get(i).getStart().before(employees.get(j).getEnd())||employees.
				 * get(i).getEnd().after(employees.get(j).getEnd())) {
				 * employees.get(i).getWorkingTime().put(employees.get(i).getId(),
				 * employees.get(i).getStart().compareTo(employees.get(j).getEnd())); }else
				 * if(employees.get(j).getStart().before(employees.get(i).getEnd())||employees.
				 * get(j).getEnd().after(employees.get(i).getEnd())) {
				 * employees.get(i).getWorkingTime().put(employees.get(i).getId(),
				 * employees.get(i).getStart().compareTo(employees.get(i).getEnd())); }else
				 * if(employees.get(i).getStart().before(employees.get(j).getStart())||employees
				 * .get(i).getEnd().after(employees.get(j).getEnd())) {
				 * employees.get(i).getWorkingTime().put(employees.get(i).getId(),
				 * employees.get(j).getStart().compareTo(employees.get(j).getEnd())); }
				 */
					if(employees.get(i).getProjectID().equals(employees.get(j).getProjectID())) {
					
					if(getDaysBetween(employees.get(i).getStart(),employees.get(j).getStart())>=0
							||getDaysBetween(employees.get(j).getEnd(),employees.get(i).getEnd())>=0) {
						employees.get(i).getWorkingTime().put(employees.get(j).getId(),(int) getDaysBetween(employees.get(j).getStart(),employees.get(i).getEnd()));
					}else if(getDaysBetween(employees.get(i).getStart(),employees.get(j).getEnd())>=0
							||getDaysBetween(employees.get(i).getEnd(),employees.get(j).getEnd())>=0) {
						employees.get(i).getWorkingTime().put(employees.get(j).getId(),(int) getDaysBetween(employees.get(i).getStart(),employees.get(j).getEnd()));
					}else if(getDaysBetween(employees.get(j).getStart(),employees.get(i).getEnd())>=0
							||getDaysBetween(employees.get(j).getEnd(),employees.get(i).getEnd())>=0) {
						employees.get(i).getWorkingTime().put(employees.get(j).getId(),(int) getDaysBetween(employees.get(i).getStart(),employees.get(i).getEnd()));
					}else if(getDaysBetween(employees.get(i).getStart(),employees.get(j).getStart())>=0
							||getDaysBetween(employees.get(i).getEnd(),employees.get(j).getEnd())>=0) {
						employees.get(i).getWorkingTime().put(employees.get(j).getId(),(int) getDaysBetween(employees.get(j).getStart(),employees.get(j).getEnd()));
					}
					}
						
						
				}
			}
			
			
			
			
			
			List<String> list =new ArrayList<String>();
			for(int i=0;i<employees.size();i++) {
				list.add(employees.get(i).getId()+":"+employees.get(i).getMaxInt());
					
				}
				
			int max=0;
			String output="";
			for(int i=0;i<list.size();i++) {
				String[] split =list.get(i).split(":");
				
				if(max<Integer.parseInt(split[2])) {
					max=Integer.parseInt(split[2]);
					output=list.get(i);
				}
					
			}
			
		
		return "User with ID="+output.split(":")[0]+" work the most with User ID="
		+output.split(":")[1];
		
		
	}
	
	
	public long getDaysBetween(String date1,String date2) {
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      
	         String firstInput = date1;
	         String secondInput = date2;
	         LocalDate firstDate = LocalDate.parse(firstInput, formatter);
	         LocalDate secondDate = LocalDate.parse(secondInput, formatter);
	         long days = ChronoUnit.DAYS.between(firstDate, secondDate);
	        return days;
	}
	public String getCurrentDate() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   return dtf.format(now);
		   
	}

}
