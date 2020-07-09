

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {






private String id;
private String projectID;
private String start;
private String end;


	
private String max="";
private Map<String,Integer> workingTime =new HashMap<String,Integer>();


	public Employee(String id,String projectID,String start,String end) {
		
		this.end=end;
		this.start=start;
		this.id=id;
		this.projectID=projectID;
		
		
	}
	

	
	

	public Map<String, Integer> getWorkingTime() {
		return workingTime;
	}

public void addWorkintTime(String id,int workingTime) {
	int temp;
	
	if(getWorkingTime().get(id)==null) {
		getWorkingTime().put(id, workingTime);
		return;
	}else {
		 temp =getWorkingTime().get(id).intValue();
		
		getWorkingTime().remove(id);
		getWorkingTime().put(id, temp+workingTime);
	}
	
	
	
	
}



	public void setWorkingTime(Map<String, Integer> workingTime) {
		this.workingTime = workingTime;
	}





	public String getId() {
		return id;
	}



private String findMax() {
	int max=0;
	String id="";
	List<Integer> list =new ArrayList<Integer>(workingTime.values());
	for(int i=0;i<list.size();i++) {
		if(max<list.get(i)) {
			max=list.get(i);
			id=(String) workingTime.keySet().toArray()[i];
		}
		
	}
	
	return id+":"+max;
}

	public String getMaxInt() {
		if(max.equals("")) 
			max=findMax();
			
		return max;
	}

public void setId(String id) {
		this.id = id;
	}





	public String getProjectID() {
		return projectID;
	}





	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}





	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}
	
	public void setEnd(String end) {
		this.end = end;
	}

	
	
}
