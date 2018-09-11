package test1;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MathExam6324 {
	public static void main(String[] args)  throws IOException {

		int n;
		while (true) {
			Scanner input = new Scanner(System.in);
			try {
				n=input.nextInt();
			}catch(Exception e) {
				System.out.println("输入的不是整数请重新输入");
				continue;}
			if(n<0) {
				System.out.println("输入的不是正数请重新输入");
			}
			break;
		}
				
		 Scanner x = new Scanner(System.in);
		int G = x.nextInt();
		if(G==1) {
			grade_one();
		}else if(G == 2) {
			grade_two();
		}
	
		}
	
 static void grade_one() throws FileNotFoundException {
	 List<String> list = new ArrayList<String>();PrintStream out = System.out;
		PrintStream s = new PrintStream("d:\\output.txt");
			         

			 int a = (int) (Math.random() * 50);        
			 int b = (int) (Math.random() * 50);  
			 int ans;
	         int x = (int) (Math.random() * 2);
			 if (x == 1) { 
				 ans=a+b;
			 System.setOut(s);
			 System.out.println(a + "+" + b + "=");
			list.add(a + "+" + b + "="+ans);
			 if(x==0) {
				 while(a-b<0) {b = (int) (Math.random() * 50);}
				 ans=a-b;
				 System.setOut(s);
				 System.out.println(a + "-" + b + "=");
				 list.add(a + "-" + b + "="+ans);
				
			 }}}
			 
 static void grade_two() throws IOException {
	 List<String> list = new ArrayList<String>();PrintStream out = System.out;
	PrintStream s = new PrintStream("d:/output.txt");
			
			 int ans1;
			 int ans2;
			 Scanner sc = new Scanner(System.in);         
			 
			 int a = (int) (Math.random() * 20);        
			 int b = (int) (Math.random() * 20);  
			 int ans;
	         int x = (int) (Math.random() * 2);
			 if (x == 1) { 
				 ans=a*b;
			 System.setOut(s);
			 System.out.println(a + "*" + b + "=");
			list.add(a + "*" + b + "="+ans);
			 if(x==0) {
				 while(a<b) {b = (int) (Math.random() * 10);}
				 ans=a%b;
				 ans1=a/b;
				 ans2=ans1-ans;
				 System.setOut(s);
				 System.out.print(a + "/" + b + "=");
				 list.add(a + "/" + b + "="+ans+"..."+ans2);
				 
			 }
			 }
	System.setOut(s);
		 System.out.println("-----标准答案-----");
	 for(int i = 0; i < list.size(); i++);{
		 PrintStream s1 = new PrintStream("d:\\output.txt");
		System.setOut(s);
		 System.out.println("list.get(i)");}
	 SimpleDateFormat formater=new SimpleDateFormat("        211606324 聂寒冰 yyyy年MM月dd日 HH:mm");
	 String strCurrentTime=formater.format(new Date(x));
	 System.setOut(s);
	 System.out.println(strCurrentTime);
	 File file = new File("d:/output.txt");
	   FileReader reader = new FileReader(file);
	   int fileLen = (int)file.length();
	   char[] chars = new char[fileLen];
	   reader.read(chars);
	   String txt = String.valueOf(chars);
	System.setOut(out);
	   System.out.println(txt);
 
 
 }}


	 