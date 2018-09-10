import java.util.ArrayList;
import java.util.Random;

 class MathExam5242 {
	static ArrayList<String> answer;
	static int number=0;//ÌâºÅ
	static int n=0;//ÌâÊı
public static void main(String args[]) {
	if(args.length!=0) {
		answer = new ArrayList();
		n=Integer.valueOf(args[0]);
	    Random r = new Random();
	    for (int i = 1; i <= n; i++) {
			int s = r.nextInt(2);
			switch (s) {
			case 0:
			{
				    number++;
				    Jiafa j = new Jiafa(answer,number);
					break;
			}
			case 1:
			{
				number++;
				Jianfa f= new Jianfa(answer,number);
				break;
			}
			}
		}
	    Output o = new Output(n);
	}
	else 
		System.out.println(" ");
} 
}
