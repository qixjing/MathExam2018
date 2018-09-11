import java.io.File;
import java.util.*;
import java.text.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class MathExam6356 {

	public static void main(String[] args) throws FileNotFoundException {
		int n;
		//Scanner input=new Scanner(System.in);
		if(args.length==1) {
		n=Integer.parseInt(args[0]);
		int[] a=new int [n];
		int[] b=new int [n];
		int[] c=new int [n];
		Random fuhao=new Random();
		Random num1=new Random();
		Random num2=new Random();//种子相同的Random对象，生成的随机数序列是一样的。
		for (int i = 0; i < n; i++) {
			a[i]=num1.nextInt(100);	//0-100的随机数
			b[i]=num2.nextInt(100);
			c[i]=fuhao.nextInt(2);
		}
		File file = new File("out.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);//把创建的打印输出流赋给系统。
		for (int i = 0; i < n; i++) {
			if (c[i]==0) {
				System.out.println("("+(i+1)+") "+a[i]+"+"+b[i]+" =");
			}else {
				System.out.println("("+(i+1)+") "+a[i]+"-"+b[i]+" =");
			}
			
		}	
		System.out.println("--------------标准答案----------------");
		for (int i = 0; i < n; i++) {
			if (c[i]==0) {
				System.out.println("("+(i+1)+") "+a[i]+"+"+b[i]+" ="+" "+(a[i]+b[i]));
			}else {
				System.out.println("("+(i+1)+") "+a[i]+"-"+b[i]+" ="+" "+(a[i]-b[i]));
			}
	}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
 		String time = sdf.format(new Date());
 		System.out.println("211606356 " + time);//输出学号姓名 时间
	}
	}
}
