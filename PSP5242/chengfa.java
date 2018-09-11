import java.util.ArrayList;
import java.util.Random;

public class chengfa extends Operation{
	public chengfa(ArrayList<String> answer,int number) {
		Random r = new Random();
		first = r.nextInt(9)+1;
		second = r.nextInt(9)+1;
		answernumber = first*second;
		
		answer.add("("+number+")"+"  "+first+" * "+second+" =");
		answer.add(" "+answernumber);
	}

}
