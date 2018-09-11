import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

import java.util.Scanner;


public class MathExam6387 {

	private static int x,y,f;
	private static String[] str ;
	private static String rem;

	public static void main(String args[]) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub

		//String[] 转化为 int
		int i =Integer.valueOf(args[0]).intValue();
		int g =Integer.valueOf(args[1]).intValue();
		//输出保存在文件中
		File file = new File("out6387.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		choiceGrade(i, g);
		
	}
	
	//一年级加法出题
	public static void gradeOne( int n ) {
		str = new String[n];
		for (int i = 0; i < n ; i++) {
			x = (int)(Math.random()*100);
			y = (int)(Math.random()*100);
			f = (int)(Math.random()*2);
			// 判断加法和减法 0为加法
			if ( f == 0) {
				System.out.println("(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " ");
				str[i] = "(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " " + (x+y);
			}
			else {
				if (x-y < 0) {
					System.out.println("(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " " + (y-x);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " " + (x-y);
				}
			}
		}
		System.out.println("--------标准答案--------");
		//输出答案
		for(String a:str)
			System.out.println(a);
		//输出日期和学号姓名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		System.out.println("              211606387 姓名：叶宏奇  " +sdf.format(new Date()));
	}
	
	//二年级乘法出题
	public static void gradeTwo( int n ) {
		str = new String[n];
		for (int i = 0; i < n; i++) {
			x = new Random().nextInt(10) + 1;
			y = new Random().nextInt(10) + 1;
			f = (int)(Math.random()*2);
			
			if ( f == 0 && y!=0 && x!=0) {
				System.out.println("(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " ");
				str[i] = "(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " " + (x*y);
			}
			else {
				if (x-y < 0 ) {
					System.out.println("(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " " + (y/x) + judgementRemainder(y,x);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " " + (x/y) + judgementRemainder(x,y);
				}
			}
		}
		System.out.println("--------标准答案--------");
		//输出答案
		for(String a:str)
			System.out.println(a);
		//输出日期和姓名学号
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		System.out.println("              211606387 姓名：叶宏奇  " +sdf.format(new Date()));
	}
	
	//选择年级
	public static void choiceGrade( int n , int g ) {
		if ( g == 1 ) {
			gradeOne(n);
		}
		else if ( g == 2) {
			gradeTwo(n);
		}
		else {
			System.out.println("程序员能力有限，高年级还未完成");
		}
	}
	
	//判断余数
	public static String judgementRemainder( int x , int y ) {
		if( (x%y) == 0) {
			
			rem = " ";
		}
		else {
			rem = "..." + (x%y) + " ";
		}
		return rem;
	}
}