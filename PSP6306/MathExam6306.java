import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
public class MathExam306 {

	public static void main(String[] args) throws FileNotFoundException {		
		// TODO 自动生成的方法存根
		int n;
		Scanner scanner = new Scanner(System.in);
		// 从键盘接收数据
		n = scanner.nextInt();
		 // 接收的数据赋值给n
		String[] str = new String[n];
		File file = new File("out6306.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		zzz(n,str);
	}
	public static void zzz(int n,String[] str) {
		int x;
		int y;
		for (int i = 0; i < n; i++) {
			int z = (int)(Math.random()*(2));
			
		if(z==0) {
			x = (int)(Math.random()*100);
			y = (int)(Math.random()*100);
			System.out.println("("+(i+1)+")" + "" + x + "+" + y + "" + "=" + "" );
			str[i] = "(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " " + (x+y);}
		if(z==1) {
			x = (int)(Math.random()*100);
			y = (int)(Math.random()*100);
			System.out.println("("+(i+1)+")" + "" + x + "+" + y + "" + "=" + "" );
			str[i] = "(" + (i+1) + ")" +" " + x + "-2" + y + " " + "=" + " " + (x-y);
		}
		}
		System.out.println("标准答案");
		for(String s:str)
			System.out.println(s);

		
	}
		

		
		
}


