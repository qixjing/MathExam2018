package com.java328.MathExam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class MathExam328b {
	public static void main(String[] args) throws IOException {
		MathExam328a mathexam1 = new MathExam328a();
		MathExam328b mathexam2 = new MathExam328b();
		Scanner in=new Scanner(System.in);
		String str1=in.nextLine();
		String str2=in.nextLine();
		int n=0,m=0;
		if(mathexam2.isNumber(str1)) {
			n=Integer.parseInt(str1);
		}
		else System.out.println("请输入正确的题数！");
		if(mathexam2.isNumber(str2)) {
			m=Integer.parseInt(str2);
			if(m!=1&&m!=2) System.out.println("请输入正确的年级！");
		}
		if(str2.equals("")) mathexam1.grade1(n);
		if(m==1) mathexam1.grade1(n);
		if(m==2) mathexam2.grade2(n);
	}
	public void grade2(int n) throws IOException {
		int number1[]=new int[n];
		int number2[]=new int[n];
		int number3[]=new int[n];		
		char sign[]=new char[n];
		input(number1, number2, number3, sign);
		int number4[]=calculate1(number1, sign, number2);
		int number5[]=calculate2(number1, sign, number2);
		output(number1, sign, number2, number4,number5);
	}
	
	private boolean isNumber(String str) {
		String regex="\\d*";
		if(str.charAt(0)=='0'&&str.length()>1) return false;
		return str.matches(regex);
	}

	public void input(int[] a,int[] b,int[] c,char[] d) {
		for (int i = 0; i < a.length; i++) {
			c[i]=(int)(Math.random()*2);
			if(c[i]==0) {
				a[i]=(int)(Math.random()*10);
				b[i]=(int)(Math.random()*10);
			}
			else {
				a[i]=(int)(Math.random()*82);
				b[i]=(int)(Math.random()*9)+1;
			}
			if(c[i]==0) d[i]='*';
			else d[i]='/';
		}
	}
	
	public int[] calculate1(int[] a,char[] b,int[] c) {
		int d[]=new int[a.length];
		for (int i = 0; i < a.length; i++) {
			if(b[i]=='*') d[i]=a[i]*c[i];
			else d[i]=a[i]/c[i];
		}
		return d;
	}
	
	public int[] calculate2(int[] a,char[] b,int[] c) {
		int d[]=new int[a.length];
		for (int i = 0; i < a.length; i++) {
			if(b[i]=='*') d[i]=0;
			else d[i]=a[i]%c[i];
		}
		return d;
	}
	
	public void file(File file) {
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
	
	public void output(int[] number1,char[] sign,int[] number2,int[] number4,int[] number5) throws IOException {
		String filename="d:\\out.txt";
		File file=new File(filename);
		file(file);
		String str="-----------标准答案-----------\r\n";
		String str1[] = new String[number1.length];
		String str2[] =new String[number1.length];
		OutputStream out = new FileOutputStream(file);
		for (int i = 0; i < number1.length; i++) {
			str1[i]="("+String.valueOf(i+1)+") "+String.valueOf(number1[i])+" "+String.valueOf(sign[i])+" "+String.valueOf(number2[i])+" =\r\n";
			out.write(str1[i].getBytes());
		}
		out.write(str.getBytes());
		for (int i = 0; i < number1.length; i++) {
			if(number5[i]==0) str2[i]="("+String.valueOf(i+1)+") "+String.valueOf(number1[i])+" "+String.valueOf(sign[i])+" "+String.valueOf(number2[i])+" = "+String.valueOf(number4[i])+"\r\n";
			else str2[i]="("+String.valueOf(i+1)+") "+String.valueOf(number1[i])+" "+String.valueOf(sign[i])+" "+String.valueOf(number2[i])+" = "+String.valueOf(number4[i])+"..."+String.valueOf(number5[i])+"\r\n";
			out.write(str2[i].getBytes());
		}
		out.close();
	}
}
