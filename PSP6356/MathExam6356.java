import java.io.File;
import java.util.*;
import java.text.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class MathExam6356 {
	static int n;
	public static void main(String[] args) throws FileNotFoundException {

		//Scanner input=new Scanner(System.in);
		if(args.length==1) {
			
			try {
				n=Integer.parseInt(args[0]);
				if(n<=0 || n > 500) {
					System.out.println("请输入0-500的正整数");
					System.exit(0);
				}
				
			} catch (NumberFormatException e) {
				System.out.println("您输入的不是正整数,请输入整数");
				System.exit(0);
			}
		
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
			if (c[i]==0) {//随机加法
				while (a[i]+b[i]>100) {
					//如果和大于100重新随机
					a[i]=num1.nextInt(100);
					b[i]=num2.nextInt(100);
				}
				System.out.println("("+(i+1)+") "+a[i]+"+"+b[i]+" =");
			}else {//随机减法
				while (a[i]-b[i]<0) {
					//如果差小于0重新随机
					a[i]=num1.nextInt(100);
					b[i]=num2.nextInt(100);
				}
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
 		System.out.println("211606356 陈宇 " + time);//输出学号姓名 时间
	}else {
		System.out.println("参数输入有误，请重新运行");
		System.exit(0);
	}
	}
}
