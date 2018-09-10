package com.java.exam1;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;


public class exam1 {
	public static void main(String[] args) throws FileNotFoundException {
		//确定输出的文件
		File file = new File("out.txt");
		//创建指向文件的数据输出流
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		// TODO Auto-generated method stub	
		Scanner s=new Scanner(System.in);
		System.out.println("请输入年级：");
		int grade = s.nextInt();
		if(grade == 1) {
			grade_one();
		}else if(grade ==2) {
			grade_two();
		}
		}
	
		public static void grade_one() {	
			System.out.println("请输入需要出题的数目：");
			Scanner s=new Scanner(System.in);
			int n = s.nextInt();
			int ai[]=new int[n];
			int aj[]=new int[n];
			int ax[]=new int[n];
			for(int a=0; a<n;a++)
			{
				int i=(int) Math.floor(Math.random()*20+1);
				int j=(int) Math.floor(Math.random()*20+1);
				int x=(int) Math.floor(Math.random()*2+1);
				ai[a]=i;
				aj[a]=j;
				ax[a]=x;
				int m1=1;
				ax[a]=x;
				if(x%2==1) {
				System.out.println("(" + m1 + ") "+ i +" + " + j + "=");
				}else {
					if(i>j){
				System.out.println("(" + m1 + ") "+ i + " - "+j+"= ");
				}else {
					System.out.println("(" + m1 + ") "+ j + " - "+i+"= ");
					}
				m1++;
			}	
			System.out.println("                  ");		
			int m2=1;
			for(int a1=0;a1<n;a1++)
			{
			if(ax[a1]%2==1) 
			{
			System.out.println("("+ m2 +") "+ ai[a1] +" + "+ aj[a1] +" = "+(ai[a1]+aj[a1]));
			String str = ("("+ m2 +") "+ ai[a1] +" + "+ aj[a1] +" = "+(ai[a1]+aj[a1]));
			}else {
			System.out.println("("+ m2 +") "+ ai[a1] +" - "+ aj[a1] +" = "+(ai[a1]-aj[a1]));
			String str = ("("+ m2 +") "+ ai[a1] +" - "+ aj[a1] +" = "+(ai[a1]-aj[a1]));
			}
			m2++;
			
		}
	}	
}
		
		
		public static void grade_two() {
			System.out.println("请输入需要出题的数目：");
			Scanner s=new Scanner(System.in);
			int m = s.nextInt();
			double ai[]=new double[m];
			double aj[]=new double[m];
			double ax[]=new double[m];
			for(int a=0; a<m;a++)
			{
				int i=(int) Math.floor(Math.random()*10+1);
				int j=(int) Math.floor(Math.random()*10+1);
				int x=(int) Math.floor(Math.random()*2+1);
				ai[a]=i;
				aj[a]=j;
				ax[a]=x;
				int m1=1;
				ax[a]=x;
				if(x%2==1) {
				System.out.println("(" + m1 + ") "+ i +" * " + j + "=");
				}else {
				System.out.println("(" + m1 + ") "+ i + " / " + j + "= ");
				}
				m1++;
			}	
			System.out.println("                  ");		
			int m2=1;
			for(int a1=0;a1<m;a1++)
			{
				int B[]=new int[m];
			    B[m-1]=(int) (ai[a1]%aj[a1]);
			if(ax[a1]%2==1) 
			{
			System.out.println("("+ m2 +") "+ ai[a1] +" * "+ aj[a1] +" = "+(ai[a1]*aj[a1]));
			}else {
				if(ai[a1]%aj[a1]==0)
				{
					System.out.println("("+ m2 +") "+ ai[a1] +" / "+ aj[a1] +" = "+floor((ai[a1]/aj[a1])));
				}else {
			System.out.println("("+ m2 +") "+ ai[a1] +" / "+ aj[a1] +" = "+floor((ai[a1]/aj[a1]))+"..."+B[m-1]);
			}
				}
			m2++;
		}
		
			
	}

		private static String floor(double d) {
			// TODO Auto-generated method stub
			return null;
		}
	
}