
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class MathExam6242_2 {
		static int n;			//定义一个全局变量
		static char[] symb = new char[] {'+','-','*','/'};			//定义一个运算符数组
		static int grade;
		static int[] a = new int[200];
		static int[] result = new int[100];
		static char[] c = new char[100];

		public static String getTime() {			//定义获取得到的系统当前时间格式
			SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
			String dateStr = df.format(System.currentTimeMillis());
			return dateStr;
		}
		
		public static String input() {			//输入方法
			String str;
			Scanner scan = new Scanner(System.in);
			str = scan.nextLine();
			return str;
		}
			
		public static boolean checkNum(String str) {
			String[] split = str.split(" ");
			try {
				n = Integer.parseInt(split[0]);
				} catch(Exception e) {
					System.err.println("题数输入有误！请输入正确的题数(1~100) 年级(1 or 2)，例: 20 2 ：");
					return false;
				}
			
			try {
			grade = Integer.parseInt(split[1]);
			} catch(Exception e) {
				System.err.println("年级输入有误！请输入正确的题数(1~100) 年级(1 or 2)，例: 20 2 ：");
				return false;
			}
			
			if (n <= 0) {			//排除题目量负数
				System.out.println("请输入有效的题目数量(1~100)：");
				return false;
			}
			
			if( n > 1000) {			//排除题目量过大
				System.out.println("题目量太大！体谅一年级的孩子们，请重新输入题目数量(1~100)：");
				return false;
			}

			if (grade == 1 || grade == 2) {}
			else{
				System.err.println("年级输入有误！输入正确的题数(1~100) 年级(1 or 2)，例: 20 2 ：");
				return false;
			}
			return true;
	}
		public static boolean checkNum(String str1,String str2) {
			try {
				n = Integer.parseInt(str1);
				} catch(Exception e) {
					System.err.println("题数输入有误！请输入正确的题数(1~100) 年级(1 or 2)，例: 20 2 ：");
					return false;
				}
			
			try {
			grade = Integer.parseInt(str2);
			} catch(Exception e) {
				System.err.println("年级输入有误！请输入正确的题数(1~100) 年级(1 or 2)，例: 20 2 ：");
				return false;
			}
			
			if (n <= 0) {			//排除题目量负数
				System.out.println("请输入有效的题目数量(1~100)：");
				return false;
			}
			
			if( n > 100) {			//排除题目量过大
				System.out.println("题目量太大！体谅一年级的孩子们，请重新输入题目数量(1~100)：");
				return false;
			}

			if (grade == 1 || grade == 2) {
			}
			else{
				System.err.println("年级输入有误！输入正确的题数(1~100) 年级(1 or 2)，例: 20 2 ：");
				return false;
			}
			return true;
	}
		public static void mathGrade(int n,int grade) {			//出题方法
			int fristNum,secondNum,t;
			Random ra = new Random();
			for (int i=0;i<2*n;i++) {
				c[i]=symb[ra.nextInt(2*grade)];			//一次性获取所有题目的随机运算符（+、-、*、/）
			}
//			-------------------------------------------创建IO流
			
			FileWriter fw = null;
			try {
			String address = "output.txt";
			File file = new File(address);
			fw = new FileWriter(file,true);
			} catch(IOException e){
				e.printStackTrace();
			}
			
			PrintWriter pw =new PrintWriter(fw);		
//         ---------------------------------
			for (int i = 0,j = 0; i< 2*n;i = i + 2, j++) {
				switch(c[j]) {
					case'+':	
						fristNum = ra.nextInt(21);
						a[i] = fristNum;
						secondNum = ra.nextInt(21);
						a[i+1] = secondNum;
						result[j] = a[i] + a[i+1];
						System.out.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" =");
						pw.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" =");			//输出到output.txt
						pw.flush();
						break;
						
					case'-':	
						fristNum = ra.nextInt(21);
						a[i] = fristNum;
						secondNum = ra.nextInt(21);
						a[i+1] = secondNum;
						if (a[i] < a[i+1]) {
							t = a[i];a[i] = a[i+1];a[i+1] = t;
						}
						result[j] = a[i] - a[i+1];
						System.out.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" =");
						pw.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" =");			//输出到output.txt
						pw.flush();
					break;
					
					case'*':	
						fristNum = ra.nextInt(11);
						a[i] = fristNum;
						secondNum = ra.nextInt(11);
						a[i+1] = secondNum;
						result[j] = a[i] * a[i+1];
						System.out.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" =");
						pw.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" =");			//输出到output.txt
						pw.flush();
					break;
					
					case'/':	
						fristNum = ra.nextInt(11);
						a[i] = fristNum;
						secondNum = ra.nextInt(11);
						while(secondNum == 0) {
							secondNum = ra.nextInt(11);
						}
						a[i+1] = secondNum;
						result[j] = a[i] / a[i+1];
						System.out.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" =");
						pw.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" =");			//输出到output.txt
						pw.flush();
					break;
					}
				}
			
			System.out.println("-----------------标准答案--------------------");
			pw.println("-----------------标准答案--------------------");			//输出到output.txt
			pw.flush();
			
			for(int i = 0,j = 0;i < 2*n; i = i + 2, j++) {
				if(c[j]=='/') {
					if(a[i]%a[i+1]!=0) {
						System.out.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" = " + result[j]+"..."+(a[i]%a[i+1]));
						pw.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" = " + result[j]+"..."+(a[i]%a[i+1]));			//输出到output.txt
						pw.flush();
						continue;
						}
					}
				System.out.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" = " + result[j]);
				pw.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" = " + result[j]);			//输出到output.txt
				pw.flush();
				}
			
			System.out.println("                        211406242  杨长元  "+getTime());			//输出到屏幕
			pw.println("                     211406242  杨长元  "+getTime());			//输出到output.txt
			pw.flush();
			
			try {
				fw.flush();
				pw.close();
				fw.close();
				}	catch(IOException e) {
					e.printStackTrace();
					}
			}
		
		public static void main(String[] args) {
			if(!checkNum(args[0],args[1])){
				while(!checkNum(input())) {}			//当输入不为数字时，重复空循环
				}	
			mathGrade(n,grade);
		}
}


