import java.util.ArrayList;
import java.util.Random;

 class MathExam5242 {
	static ArrayList<String> answer;
	static int number=0;//题号
	static int n=0;//题数
	static int grade=1;
	static String errMesssge;
public static void main(String args[]) {
	
	if(args.length==0 || args.length>2) {
		System.out.println("参数不能大于2，不能为空");
	}
	else if(!args[1].matches("\\d*")) {
		System.out.println("第二个参数错");
	}
	
	else if(args.length==2) {      
 		n=Integer.valueOf(args[0]);
 		if(args.length==2 && Integer.valueOf(args[1])==2) {			
 			grade=2;
 		}
 		else 
 			grade=0;
		answer = new ArrayList();
		n=Integer.valueOf(args[0]);
	    Random r = new Random();
	  
	    for (int i = 1; i <= n; i++) {
			int s = r.nextInt(2); 
			s=s+grade;
			switch (s) {
			case 0://减法
			{
				    number++;
				    Jiafa j = new Jiafa(answer,number);
					break;
			}
			case 1://加法
			{
				number++;
				Jianfa f= new Jianfa(answer,number);
				break;
			}
			case 2:                    //乘法
			{
				number++;
				 chengfa c = new chengfa(answer,number);
				break;
			}
			case 3:                  //除法
			{
				number++;
			      chufa c = new  chufa(answer,number);
				break;
			}
			}
		}
	    Output o = new Output(n);
	}
	else 
		System.out.println("");
} 
}
