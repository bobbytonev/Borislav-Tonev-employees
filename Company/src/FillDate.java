import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FillDate {

	public FillDate() {
		// TODO Auto-generated constructor stub
	}
	
	final static int ids[] = {110,111,112,113,114,115,116,117,118,119,120,121,122,123,124};
	final static int projectids[] = {10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
	
	
	public static void main(String[] a) throws FileNotFoundException {
		int random;
		int random2;
		Random r =new Random();
		
		PrintWriter pw =new PrintWriter("employee.txt");
		String output;
		for(int i=0;i<10;i++) {
			random=r.nextInt(ids.length);
			random2=r.nextInt(ids.length);
			
			String date=randomDate(1999,12,12);
			int y=Integer.parseInt(date.split("-")[0]);
			int m=Integer.parseInt(date.split("-")[1]);
			int d=Integer.parseInt(date.split("-")[2]);
			
			pw.print(data(random,random2,date,randomDate(y,m,d)));
			pw.print("\n");
		}
		pw.close();
	
		
		
	}
	public static String data(int id,int projectId,String start,String end) {
		return id+","+projectId+","+start+","+end;
	}
	
public static String randomDate(int y,int m,int d) {
	LocalDate startDate = LocalDate.of(y, m, d); //start date
	
	
    long start = startDate.toEpochDay();
    //System.out.println(start);

    LocalDate endDate = LocalDate.now(); //end date
    long end = endDate.toEpochDay();
   // System.out.println(start);

    long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
   return LocalDate.ofEpochDay(randomEpochDay).toString(); // random date between the range
}

}
