import java.util.ArrayList;
import java.util.Random;

public class chufa extends Operation{
	public chufa(ArrayList<String> answer,int number) {
		Random r = new Random();
		first = r.nextInt(9)+1;//³ıÊı
		second = r.nextInt(9)+1;//±»³ıÊı
		
		if(first/second==0) {
			answernumber = first/second;
			answer.add("("+number+")"+"  "+first+" / "+second+" =");
			answer.add(" "+answernumber);
		}else if(first/second!=0) {
			int shang = first%second;
			answernumber = first/second;
			answer.add("("+number+")"+"  "+first+" / "+second+" =");
			answer.add(" "+answernumber+"..."+shang);
		}
	}

}
