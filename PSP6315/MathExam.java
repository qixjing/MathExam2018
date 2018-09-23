package com.java315;

	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.IOException;
	import java.io.FileWriter;
	import java.util.Scanner;
	import java.util.Random;
	
	public class MathExam315 {	
		
		public static void save(String[] a,String[] b) throws IOException{
			File file=new File("out.txt");
			BufferedWriter bw=null;
			try {
				bw=new BufferedWriter(new FileWriter(file));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if(!file.exists()){
				try {
					file.createNewFile();
			} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		    for(int i=0;i<b.length;i++) {
				try {
					bw.write(b[i]);
					bw.newLine();
					bw.flush();
				
			} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		    bw.newLine();
		    bw.flush();
		    for(int i=0;i<b.length;i++) {
				try {
					bw.write(a[i]);
					bw.newLine();
					bw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
		}

		public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入正整数");
		String z=input.next();
	    String regex="\\d+";
	    System.out.println(z.matches(regex));
	    String[] s=new String[Integer.valueOf(z)];
	    String[] s1=new String[Integer.valueOf(z)];
	    if(z.matches(regex)==false) {
	    	System.out.println("有误，请重新输入正整数");
	    }else {
		for(int i=0;i<Integer.valueOf(z);i++) {
		Random q=new Random();
		int a1=q.nextInt(2);
		int a2=q.nextInt(10);
		int a3=q.nextInt(10);
		if(a1==1) {
			s[i]="("+(i+1)+")"+" "+a2+"+"+a3+"="+(a2+a3);
			s1[i]="("+(i+1)+")"+" "+a2+"+"+a3+"=";
			
		}
		if(a1==0) {
			if(a2-a3>=0) {
				s[i]="("+(i+1)+")"+" "+a2+"-"+a3+"="+(a2-a3);
				s1[i]="("+(i+1)+")"+" "+a2+"-"+a3+"=";
			}
			if(a2-a3<0) {
				s[i]="("+(i+1)+")"+" "+a3+"-"+a2+"="+(a3-a2);
				s1[i]="("+(i+1)+")"+" "+a3+"-"+a2+"=";
			}
		}
	}
		}
		save(s,s1);
		}
	}
