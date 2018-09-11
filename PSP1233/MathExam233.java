package com.java1233.MathExam;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

public class MathExam233 {
	static String s = "";
	static String s1 = "";
	static String s2 = "";

	public static void Math(int num) {
		int r = 0;
		String p;
		int c;
		int d;
		String[] m = new String[num];
		String[] n = new String[num];
		int j = 0, l = 0;
		for (int i = 0; i < num; i++) {
			String a = "(" + (i + 1) + ")" + " ";

			do {
				int b = (int) (Math.random() * 10);
				c = (int) (Math.random() * 100);
				d = (int) (Math.random() * 100);
				if (b % 2 == 0) {
					p = "+";
					r = c + d;
				} else {
					p = "-";
					r = c - d;
				}
			} while (r < 0 || r > 100);
			System.out.println(a + c + p + d + "=");
			m[j++] = a + c + p + d + "=" + r;
			n[l++] = a + c + p + d + "=";
		}
		System.out.println("----------------标准答案----------------");
		for (int o = 0; o < j; o++) {
			System.out.println(m[o]);
		}
		for (int i = 0; i < m.length; i++) {
			s = s + "\n" + m[i];
		}
		for (int i = 0; i < n.length; i++) {
			s1 = s1 + "\n" + n[i];
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");//设置日期格式
		System.out.println("         "+"211601233"+"张康凌"+df.format(new Date()));// new Date()为获取当前系统时间
	}

	private static void createtxt() {
		try {
			FileOutputStream fos = new FileOutputStream("out.txt");
			PrintStream ps = new PrintStream(fos);
			ps.println(s1);
			ps.println(s);
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Math2(int num) {
		int a,b,c,d,e,f;
		String p = null,k = null;
		for(int i=0;i<num;i++) {
			String j="("+(i+1)+")"+" ";
			d=(int) (Math.random()*10);
			if(d%2==0 ) {
				a=(int) (Math.random()*9+1);
				b=(int) (Math.random()*9+1);
				p="*";
				k=String.valueOf(a*b);
			}else {
				p="/";
				do {
					a=(int) (Math.random()*90+1);
					b=(int) (Math.random()*10+1);
					e=a/b;
					f=a%b;
					if(f!=0) {
					k=e+"..."+f;
					}else {
						k=String.valueOf(e);
					}
				}while(e<=0 || e>=10 || b==0);
					

			}
			if(i!=0) {
				s1= s1 + "\n";
			}
			s1= s1 + (j+a+p+b+"=") ;
			s = s + "\n";
			s = s + (j+a+p+b+"=" + k);
		}
		System.out.println(s1+"\n"+"----------------标准答案----------------"+s);
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");//设置日期格式
		System.out.println("         "+"211601233"+"张康凌"+df.format(new Date()));// new Date()为获取当前系统时间
}

	public static void main(String[] args) {
		boolean isNum = args[0].matches("[^0]\\d*");
		if ((isNum == true && args.length == 1 && args[0].matches("^[0-9]*[1-9][0-9]*$") && args[0].length()<4) || (isNum == true && args.length == 2 && args[1].matches("[1]")&& args[0].matches("^[0-9]*[1-9][0-9]*$")&& args[0].length()<4)) {
			int num = Integer.valueOf(args[0]);
			Math(num);
			createtxt();
		} else if (isNum == true && args.length == 2 && args[1].matches("[2]")&& args[0].matches("^[0-9]*[1-9][0-9]*$")&& args[0].length()<4) {
			int num = Integer.valueOf(args[0]);
			Math2(num);
			createtxt();
		}
		else {
			System.out.println("输入错误，请重新输入");
		}
	}
}