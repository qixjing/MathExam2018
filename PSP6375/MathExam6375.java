package niu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

import java.util.Scanner;

public class MathExam6375 {

		private static int x,y,f;
		private static String[] str ;
		private static String rem;

		public void main(String args[]) throws FileNotFoundException, InterruptedException {
			// TODO Auto-generated method stub

			//String[] 转化为 int
			int input =Integer.parseInt(args[0]);
			int grade =Integer.parseInt(args[1]);
			//输出保存在文件中
			File file = new File("out.txt");
			PrintStream ps = new PrintStream(file);
			System.setOut(ps);
			choiceGrade(input, grade);
			
		}
		
		//一年级加法出题
		public void gradeOne( int n ) {
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
				else{
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
			System.out.println("              211606375 姓名：牛振乾  " +sdf.format(new Date()));
		}
		
		//二年级乘法出题
		public void gradeTwo( int n ) {
			str = new String[n];
			for (int i = 0; i < n; i++) {
				x = (int)(Math.random()*10);
				y = (int)(Math.random()*10);
				f = (int)(Math.random()*2);
				
				if ( f == 0 && y!=0 && x!=0) {
					System.out.println("(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " ");
					str[i] = "(" + (i+1) + ")" +" " + x + "*" + y + " " + "=" + " " + (x*y);
				}
				else {
					if (x-y < 0 ) {
						System.out.println("(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " ");
						str[i] = "(" + (i+1) + ")" +" " + y + "/" + x + " " + "=" + " " + (y/x) + "..."+(y%x);
					}
					else {
						System.out.println("(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " ");
						str[i] = "(" + (i+1) + ")" +" " + x + "/" + y + " " + "=" + " " + (x/y) + "..."+(x%y);
					}
				}
			}
			System.out.println("--------标准答案--------");
			//输出答案
			for(String a:str)
				System.out.println(a);
			//输出日期和姓名学号
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
			System.out.println("              211606375 姓名：牛振乾  " +sdf.format(new Date()));
		}
		
		//选择年级
		public void choiceGrade( int n , int grade ) {
			if ( grade == 1 ) {
				gradeOne(n);
			}
			else if ( grade == 2) {
				gradeTwo(n);
			}
			else {
				System.out.println("比较困难，高中年级未出");
			}
		}
		
}
