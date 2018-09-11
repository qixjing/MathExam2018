import java.util.ArrayList;
import java.util.Random;

public class Jianfa extends Operation{
	public Jianfa(ArrayList<String> answer,int number) {
		Random r = new Random();
		first = r.nextInt(100);
		second = r.nextInt(100);
		int answernumber;
		
		if(first-second>=0) {
		answernumber = first-second;
		}
		else {
			answernumber = second-first ;
		}
		answer.add("("+number+")"+"  "+first+" - "+second+" =");
		answer.add(" "+answernumber);
	}
	

}
