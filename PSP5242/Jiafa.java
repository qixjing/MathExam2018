import java.util.ArrayList;
import java.util.Random;

public class Jiafa extends Operation {
	public Jiafa(ArrayList<String> answer,int number) {
		Random r = new Random();
		first = r.nextInt(100);
		second = r.nextInt(100);
		int answernumber = first+second;
				
		
			answer.add("("+number+")"+"  "+first+" + "+second+" =");
			answer.add(" "+answernumber);
		}
	}
	

