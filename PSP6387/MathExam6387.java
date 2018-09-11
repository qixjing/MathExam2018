
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.text.SimpleDateFormat;
// import java.util.Scanner;


public class MathExam6387 {

// 	private static Scanner in;
	private static int x,y,f;
	private static String[] str;

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
// 		int n ;
// 		in = new Scanner(System.in);
// 		n = in.nextInt();
		int i =Integer.valueOf(args[0]).intValue();
		File file = new File("out6387.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		gradeOne(n);
	}

	public static void gradeOne(int n) {
		str = new String[n];
			for (int i = 0; i < n ; i++) {
			x = (int)(Math.random()*100);
			y = (int)(Math.random()*100);
			f = (int)(Math.random()*2);
			
			if ( f == 0) {
				System.out.println("(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " ");
				str[i] = "(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " " + (x+y);
			}
			else {
				System.out.println("(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " ");
				str[i] = "(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " " + (x-y);
			}
		}
		System.out.println("--------标准答案--------");
		    for(String a:str)
		        System.out.println(a);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		    System.out.println("              211606387 姓名：叶宏奇  " +sdf.format(new Date()));
	}
}
