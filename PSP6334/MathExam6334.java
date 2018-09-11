package com.java334.MathExam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MathExam6334 {	
	public static void saveAnswer(String[] a,String[] b) throws IOException{
		File file=new File("out.txt");
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(file));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    for(int i=0;i<a.length;i++) {
			try {
				bw.write(a[i]);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	    bw.newLine();
	    bw.flush();
	    for(int i=0;i<b.length;i++) {
			try {
				bw.write(b[i]);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}

	public static void grade2(int grade) throws IOException {
	    String[] array2=new String[Integer.valueOf(grade)];
	    String[] array3=new String[Integer.valueOf(grade)];
	    for(int i=0;i<Integer.valueOf(grade);i++) {
	    Random R=new Random();
		int a1=R.nextInt(2);
		int a2=R.nextInt(10);
		int a3=R.nextInt(10)*1+1; 
		if(a1==0) {
			array2[i]="("+(i+1)+")"+" "+a2+"*"+a3+"=";
			array3[i]="("+(i+1)+")"+" "+a2+"*"+a3+"="+(a2*a3);
		}
		if(a1==1) {
			if(a2%a3==0) {
			array2[i]="("+(i+1)+")"+" "+a2+"%"+a3+"=";
			array3[i]="("+(i+1)+")"+" "+a2+"%"+a3+"="+(a2%a3);
			}
			if(a2%a3!=0){
				array2[i]="("+(i+1)+")"+" "+a2+"%"+a3+"=";
				String a=String.valueOf(a2/a3);
				String b=String.valueOf(a2%a3);
                String c=a+"..."+b;
                array3[i]="("+(i+1)+")"+" "+a2+"%"+a3+"="+c;
				}	
			}
		}
	    saveAnswer(array2,array3);
		}	

	public static void grade1(int str) throws IOException {
	    String[] array=new String[Integer.valueOf(str)];
	    String[] array1=new String[Integer.valueOf(str)];
		for(int i=0;i<Integer.valueOf(str);i++) {
		Random R=new Random();
		int a1=R.nextInt(2);
		int a2=R.nextInt(20);
		int a3=R.nextInt(20);
		if(a1==0) {
			array1[i]="("+(i+1)+")"+" "+a2+"+"+a3+"=";
			array[i]="("+(i+1)+")"+" "+a2+"+"+a3+"="+(a2+a3);
		}
		if(a1==1) {
			if(a2-a3>=0) {
				array1[i]="("+(i+1)+")"+" "+a2+"-"+a3+"=";
				array[i]="("+(i+1)+")"+" "+a2+"-"+a3+"="+(a2-a3);
			}
			if(a2-a3<0) {
				array1[i]="("+(i+1)+")"+" "+a3+"-"+a2+"=";
				array[i]="("+(i+1)+")"+" "+a3+"-"+a2+"="+(a3-a2);
			}
		}
		}
		  saveAnswer(array1,array);
		}

	public static void main(String[] args) throws IOException {
	Scanner input=new Scanner(System.in);
	Scanner input2=new Scanner(System.in);
	System.out.println("请选择要出几道题,请输入整数,年级");
	String str=input.next();
	String grade=input2.next();
    String regex="\\d+";
    System.out.println(str.matches(regex));
    System.out.println(grade.matches(regex));
    if(str.matches(regex)==false) {
    	System.out.println("请重新输入");
    }
    if(grade.matches(regex)==false) {
    	System.out.println("请重新输入");
    }
    if(Integer.valueOf(grade)==1)
    	grade1(Integer.valueOf(str));
    if(Integer.valueOf(grade)==2)
    	grade2(Integer.valueOf(str));
	}
}