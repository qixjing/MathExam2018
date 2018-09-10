package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MathExam6305 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("请输入题目数量(小于100大于0的数)");
		double n = 0;
		while(true) {
			n = s.nextDouble();
			if(n<=100 && n > 0 && (int)n == n) {
				break;
			}else {
				System.out.println("您输入的不是小于100大于0的整数数,请重新输入");
			}
		}
		System.out.println("请输入1（代表一年级）或2（代表二年级）");
		while(true) {
			double G = s.nextDouble();
			if(G==1) {
				Grade_one(n);
				break;
			}else if(G == 2) {
				Grade_two(n);
				break;
			}else {
				System.out.println("您输入的不是1或2,请重新输入");
			}
		}
	}
	
	public static void Grade_one(double n) {
		String[][] str = new String[100][4];
		for(int i = 0; i < n; i++) {
			int a = (int) (Math.random()*20);
			int b = (int) (Math.random()*20);
			int ans = 0;
			int mark = (int) (Math.random()*2+1);
			String strMark = null;
			if(mark == 1) {
				ans = a+b;
				strMark = "+";
			}else {
				ans = a-b;
				strMark = "-";
			}
			if(ans >= 20 || ans < 0) {
				i--;
				continue;
			}
				
			str[i][0] = String.valueOf(a);
			str[i][1] = strMark;
			str[i][2] = String.valueOf(b);
			str[i][3] = String.valueOf(ans);
		}
		Calculate(n, str);
	}
	
	public static void Grade_two(double n){
		String[][] str = new String[100][4];
		for(int i = 0; i < n; i++) {
			int mark = (int) (Math.random()*2+1);
			int a = (int) (Math.random()*9+1);
			int b = (int) (Math.random()*9+1);
			int ans = a*b;
			String strMark = null;
			if(mark == 1) {
				strMark = "*";
				str[i][0] = String.valueOf(a);
				str[i][1] = strMark;
				str[i][2] = String.valueOf(b);
				str[i][3] = String.valueOf(ans);
			}else {
				strMark = "/";
				str[i][0] = String.valueOf(ans);
				str[i][1] = strMark;
				str[i][2] = String.valueOf(a);
				str[i][3] = String.valueOf(b);
			}
		}
		Calculate(n, str);
	}
	
	public static void Calculate(double n, String[][] str) {
		try {
			File f=new File("F:\\java\\out.txt");
	        if(!f.exists()){
	            f.getParentFile().mkdirs();          
	        }
	        f.createNewFile();
			FileOutputStream fos = new FileOutputStream("F:\\java\\out.txt");
			for(int i = 0; i < n; i++) {
				fos.write("(".getBytes());
				fos.write(String.valueOf(i+1).getBytes());
				fos.write(")".getBytes());
				for(int j = 0; j < 3; j++) {
					fos.write(str[i][j].getBytes());
					fos.write("\b".getBytes());
				}
				fos.write("=".getBytes());
				fos.write("\r\n".getBytes());
			}
			fos.write("------------------标准答案------------------\r\n".getBytes());
			for(int i = 0; i < n; i++) {
				fos.write("(".getBytes());
				fos.write(String.valueOf(i+1).getBytes());
				fos.write(")".getBytes());
				for(int j = 0; j < 3; j++) {
					fos.write(str[i][j].getBytes());
					fos.write("\b".getBytes());
				}
				fos.write("=\b".getBytes());
				fos.write(str[i][3].getBytes());
				fos.write("\r\n".getBytes());
			}
			fos.close();
		}catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
