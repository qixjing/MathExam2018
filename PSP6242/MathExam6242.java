

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class MathExam6242 {
	static int n;			//定义一个全局变量
	static char[] symb = new char[] {'+','-','*','/'};			//定义一个运算符数组
	
	public static String getTime() {			//定义获取得到的系统当前时间格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		String dateStr = df.format(System.currentTimeMillis());
		return dateStr;
	}
	
	public static String input() {			//输入方法
		String str;
		Scanner scan = new Scanner(System.in);
		str=scan.nextLine();
		return str;
	}
	
	public static boolean checkNum(String str) {		//检查输入是否为数字的方法
		try {
			Integer.parseInt(str);			//判断输入是否为整型
			}catch(NumberFormatException e) {
				System.err.println("输入有误！请输入合适的题目数量(1~1000)：");			//若输入不是整型，用err输出强调提醒
				return false;
			}
			n=Integer.parseInt(str);
			if(n<=0) {			//排除题目量负数
				System.out.println("请输入有效的题目数量(1~1000)：");
			}
			if(n>1000) {			//排除题目量过大
				System.out.println("题目量太大！体谅一年级的孩子们，请重新输入题目数量(1~1000)：");
				return false;
			}
			return true;
		}
	
	public static void mathTest(int n) {			//出题方法
		int[] a = new int[2000];
		char[] c = new char[1000];
		Random ra = new Random();
		for(int i=0;i<2*n;i++) {
			a[i]=ra.nextInt(51);			//一次性获取所有题目的随机数（0～50）
			c[i]=symb[ra.nextInt(2)];			//一次性获取所有题目的随机运算符（+、-）
		}
//		-------------------------------------------创建IO流
		FileWriter fw = null;
		try {
		String address = "output.txt";
		File file = new File(address);
		fw = new FileWriter(file,true);
		}catch(IOException e){
			e.printStackTrace();
		}
		PrintWriter pw =new PrintWriter(fw);
//		-------------------------------------------
		for(int i=0,j=0;i<2*n;i=i+2,j++) {
			System.out.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" =");			//输出到屏幕
			pw.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" =");			//输出到output.txt
			pw.flush();
		}
		
		System.out.println("-----------标准答案--------------");			//输出到屏幕
		pw.println("-----------标准答案--------------");			//输出到output.txt
		pw.flush();	
		
		for(int i=0,j=0;i<2*n;i=i+2,j++) {
			if(c[j]=='+') {
				System.out.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" = " +(a[i]+a[i+1]));			//输出到屏幕
				pw.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" = " +(a[i]+a[i+1]));			//输出到output.txt
				pw.flush();
			}
			
			if(c[j]=='-') {
				System.out.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" = " +(a[i]-a[i+1]));			//输出到屏幕
				pw.println("("+(j+1)+") "+a[i]+" "+c[j]+" "+a[i+1]+" = " +(a[i]-a[i+1]));			//输出到output.txt
				pw.flush();
				}
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
		if(!checkNum(args[0])){
		while(!checkNum(input())) {			//当输入不为数字时，重复空循环
		}
}			
		mathTest(n);
	}
}
