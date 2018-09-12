package c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class MathExam6306 {

	public static void main(String[] args) throws FileNotFoundException {		
		// TODO 自动生成的方法存根
		int n,g;
		Scanner scanner = new Scanner(System.in);
		// 从键盘接收数据
		n = scanner.nextInt();
		 // 接收的数据赋值给n
		g = scanner.nextInt();
		String[] str = new String[n];
		File file = new File("out6306.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		if (g == 1) {
			zzz(n, str);
		} else if (g==2) {
			xxx(n, str);
		} else {
			System.out.println("不会做");
		}
	}
	public static void zzz(int n,String[] str) {
		int x;
		int y;
		for (int i = 0; i < n; i++) {
			int z = (int)(Math.random()*(2));
			x = (int)(Math.random()*100);
			y = (int)(Math.random()*100);
			
		if(z==0) {
			System.out.println("("+(i+1)+")" + "" + x + "+" + y + "" + "=" + " " );
			str[i] = "(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " " + (x+y);}
		else{
			if(x-y<0) {
				System.out.println("("+(i+1)+")" + "" + y + "-" + x + "" + "=" + " " );
				str[i] = "(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " " + (y-x);
			}
			else {
				System.out.println("("+(i+1)+")" + "" + x + "-" + y + "" + "=" + " " );
				str[i] = "(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " " + (x-y);
		}
			}
		}
		System.out.println("标准答案");
		for(String s:str)
			System.out.println(s);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		System.out.println("              211606306 姓名：黄柏涛  " +sdf.format(new Date()));


		
	}
	public static void xxx(int n,String[] str) {
		int x;
		int y;
		for (int i = 0; i < n; i++) {
			int z = (int)(Math.random()*(2));
			x = (int)(Math.random()*9)+1;
			y = (int)(Math.random()*9)+1;
			
		if(z==0) {
			System.out.println("("+(i+1)+")" + "" + x + "*" + y + "" + "=" + " " );
			str[i] = "(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " " + (x*y);}
		else{
			if(x-y<0) {
				System.out.println("("+(i+1)+")" + "" + y + "/" + x + "" + "=" + " " );
				str[i] = "(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " " + (y/x)+"..."+(y%x);
			}
			else {
				System.out.println("("+(i+1)+")" + "" + x + "/" + y + "" + "=" + " " );
				str[i] = "(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " " + (x/y)+"..."+(x%y);
		}
			}
		}
		System.out.println("标准答案");
		for(String s:str)
			System.out.println(s);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		System.out.println("              211606306 姓名：黄柏涛  " +sdf.format(new Date()));

		
		
		
	}
		
}