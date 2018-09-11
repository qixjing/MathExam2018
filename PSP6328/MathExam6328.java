package com.java328.MathExam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class MathExam6328 {
	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(System.in);
		System.out.println("请输入您所需要的题数与年级:");
		String str1=in.nextLine();
		String str2=in.nextLine();
		int n=0,m=0;
		while (true) {
			if(choose(str1, str2)) {
				n=Integer.parseInt(str1);
				m=Integer.parseInt(str2);
				grade(n, m);
				break;
			}
			else {
				System.out.println("请重新输入题数与年级:");
				str1=in.nextLine();
				str2=in.nextLine();
			}
		}
	}
	public static boolean choose(String str1,String str2) {
		int a=0,b=0;
		if(isNumber(str1)) {
			a=1;
		}else System.out.println("请输入正确的题数！");
		if(isNumber(str2)) {
			if(Integer.parseInt(str2)==1||Integer.parseInt(str2)==2) {b=1;}
		}
		else System.out.println("请输入正确的年级！");
		if(a==1&&b==1) return true;
		else return false;
	}
	
	public static void grade(int n,int m){
		int number1[]=new int[n];
		int number2[]=new int[n];		
		char sign[]=new char[n];
		input(number1, number2, sign,m);
		int number4[]=calculate1(number1, sign, number2,m);
		output(number1, sign, number2, number4,m);
	}
	
	public static boolean isNumber(String str) {
		String regex="\\d*";
		if(str.charAt(0)=='0'&&str.length()>1) return false;
		return str.matches(regex);
	}

	public static void input(int[] a,int[] b,char[] d,int m) {
		int t;
		if(m==1) {
			for (int i = 0; i < a.length; i++) {
				a[i]=(int)(Math.random()*101);
				b[i]=(int)(Math.random()*101);
				t=(int)(Math.random()*2);
				while(a[i]<b[i]&&t==1) {
					a[i]=(int)(Math.random()*101);
					b[i]=(int)(Math.random()*101);
					t=(int)(Math.random()*2);
				}
				if(t==0) d[i]='+';
				else d[i]='-';
			}
		}
		if(m==2) {
			for (int i = 0; i < a.length; i++) {
				t=(int)(Math.random()*2);
				if(t==0) {
					a[i]=(int)(Math.random()*10);
					b[i]=(int)(Math.random()*10);
				}
				else {
					a[i]=(int)(Math.random()*82);
					b[i]=(int)(Math.random()*9)+1;
				}
				if(t==0) d[i]='*';
				else d[i]='/';
			}
		}
	}
	
	public static int[] calculate1(int[] a,char[] b,int[] c,int m) {
		int d[]=new int[a.length];
		if(m==1) {
			for (int i = 0; i < a.length; i++) {
				if(b[i]=='+') d[i]=a[i]+c[i];
				else d[i]=a[i]-c[i];
			}
			return d;
		}
		if(m==2) {
			for (int i = 0; i < a.length; i++) {
				if(b[i]=='*') d[i]=a[i]*c[i];
				else d[i]=a[i]/c[i];
			}
		}
		return d;
	}
	
	public static int[] calculate2(int[] a,char[] b,int[] c) {
		int d[]=new int[a.length];
		for (int i = 0; i < a.length; i++) {
			if(b[i]=='*') d[i]=0;
			else d[i]=a[i]%c[i];
		}
		return d;
	}
	
	public static void file(File file) {
		if(!file.exists()) {
			File parent = file.getParentFile();
			if(parent!=null&&!parent.exists()) {
				parent.mkdirs();
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void output(int[] number1,char[] sign,int[] number2,int[] number4,int m){
		String filename="d:\\out.txt";
		File file=new File(filename);
		file(file);
		String str="-----------标准答案-----------\r\n";
		String str1[] = new String[number1.length];
		String str2[] =new String[number1.length];
		OutputStream out;
		try {
			out = new FileOutputStream(file);
			for (int i = 0; i < number1.length; i++) {
				str1[i]="("+String.valueOf(i+1)+") "+String.valueOf(number1[i])+" "+String.valueOf(sign[i])+" "+String.valueOf(number2[i])+" =\r\n";
				try {
					out.write(str1[i].getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				out.write(str.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < number1.length; i++) {
				if(m==1) {str2[i]="("+String.valueOf(i+1)+") "+String.valueOf(number1[i])+" "+String.valueOf(sign[i])+" "+String.valueOf(number2[i])+" = "+String.valueOf(number4[i])+"\r\n";}
				if(m==2) {
					int number5[]=calculate2(number1, sign, number2);
					if(number5[i]==0) str2[i]="("+String.valueOf(i+1)+") "+String.valueOf(number1[i])+" "+String.valueOf(sign[i])+" "+String.valueOf(number2[i])+" = "+String.valueOf(number4[i])+"\r\n";
					else str2[i]="("+String.valueOf(i+1)+") "+String.valueOf(number1[i])+" "+String.valueOf(sign[i])+" "+String.valueOf(number2[i])+" = "+String.valueOf(number4[i])+"..."+String.valueOf(number5[i])+"\r\n";
				}
				try {
					out.write(str2[i].getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
