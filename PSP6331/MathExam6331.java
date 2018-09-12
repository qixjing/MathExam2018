package MathExam6331;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;

public class MathExam6331 {
	public static void main(String [] args) throws IOException {
		Scanner reader=new Scanner(System.in);
		System.out.println("输入出题数目");
		String number=reader.nextLine();
		while(isNumer(number)==false) {
			number=reader.nextLine();	
		}
	}
public static boolean isNumer(String number) throws IOException {
	Scanner reader=new Scanner(System.in);
	String regex="\\d*";
	if (number.matches(regex)==true) {
		int number1=Integer.parseInt(number);
		int[] s1=new int[number1];
		int[] s2=new int[number1];
		int[] s3=new int[number1];
		char[] sign=new char[number1];
		System.out.print("请输入年级");
		int grade=reader.nextInt();
		if (grade==1||grade==2) {
			random(number,grade,s1,s2,s3,sign);
		}
		else {
			System.out.println("请输入正确年级，1或者2");
			isNumer(number);
		}
	}
	else
	{
		System.out.println("请输入数字");
		return false;
	}
	return true;
}
public static void random(String number,int grade,int[] s1,int[] s2,int[] s3,char[] sign) throws IOException{
	Random ra=new Random();
	int H;
	String[] str=new String[s1.length];
	String[] str2=new String[s1.length];
	if (grade==1) {
	char[] ch= {'+','-'};
	for (int i=0;i<s1.length;i++) {
		s1[i]=(int)(Math.random()*100+1);
		s2[i]=(int)(Math.random()*100+1);
		sign[i]=ch[ra.nextInt(ch.length)];
		if (s1[i]<s2[i]) {
			H=s1[i];s1[i]=s2[i];s2[i]=H;
		}
		if (sign[i]=='+') {
			s3[i]=s1[i]+s2[i];	
		}
		else {
			s3[i]=s1[i]-s2[i];
		}
		str[i]="("+(i+1)+")"+" "+String.valueOf(s1[i])+" "+String.valueOf(sign[i])+" "+String.valueOf(s2[i])+"\r\n";
		str2[i]="("+(i+1)+")"+" "+String.valueOf(s1[i])+" "+String.valueOf(sign[i])+" "+String.valueOf(s2[i])+" "+"="+String.valueOf(s3[i])+"\r\n";
	}
	getFile(str,str2);
	
}
	else {
		char[] ch2= {'*','/'};
		for(int a=0;a<s1.length;a++) {
			s1[a]=(int)(Math.random()*100+1);
			s2[a]=(int)(Math.random()*100+1);
			sign[a]=ch2[ra.nextInt(ch2.length)];
			if (sign[a]=='*') {
				s3[a]=s1[a]*s2[a];
				str[a]="("+(a+1)+")"+" "+String.valueOf(s1[a])+" "+String.valueOf(sign[a])+" "+String.valueOf(s2[a])+"\r\n";
				str2[a]="("+(a+1)+")"+" "+String.valueOf(s1[a])+" "+String.valueOf(sign[a])+" "+String.valueOf(s2[a])+" "+"="+String.valueOf(s3[a])+"\r\n";
			}
			else {
				H=s1[a]%s2[a];
				s3[a]=(s1[a]-H)/s2[a];
				str[a]="("+(a+1)+")"+" "+String.valueOf(s1[a])+" "+String.valueOf(sign[a])+" "+String.valueOf(s2[a])+"\r\n";
				str2[a]="("+(a+1)+")"+" "+String.valueOf(s1[a])+" "+String.valueOf(sign[a])+" "+String.valueOf(s2[a])+" "+"="+String.valueOf(s3[a])+"....."+H+"\r\n";
			}
		}
		getFile(str,str2);	
	}
}
	public static void getFile(String[] str,String[] str2) throws IOException {
		File file =new File("d:\\EXAM.txt");
		file.createNewFile();
		OutputStream out=new FileOutputStream(file);
		for (int i=0;i<str.length;i++) {
			out.write(str[i].getBytes());	
		}
		String a="*****************正确答案******************\r\n";
		out.write(a.getBytes());
		for (int i=0;i<str2.length;i++) {
			out.write(str2[i].getBytes());	
		}
	}	
}
