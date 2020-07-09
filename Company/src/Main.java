import java.text.ParseException;

public class Main {

	public Main() {
		
	}
	
	
	public static void main(String[] a ) throws  ParseException {
		BackEnd be =new BackEnd("employee.txt");
		System.out.println(be.findTwoEmployeeWorkingTheMostAsATeam());
		
	}
	
	
	
	

}
