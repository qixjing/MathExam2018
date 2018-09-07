package com.java.exam1;
import java.util.Scanner;

public class exam1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner s=new Scanner(System.in);
		System.out.println("请输入需要出题的数目：");
		int n = s.nextInt();
		int ai[]=new int[n];
		int aj[]=new int[n];
		int ax[]=new int[n];
		int m1=1;
		for(int a=0; a<n;a++)
		{
			int i=(int) Math.floor(Math.random()*20+1);
			int j=(int) Math.floor(Math.random()*20+1);
			int x=(int) Math.floor(Math.random()*10+1);
			ai[a]=i;
			aj[a]=j;
			ax[a]=x;
			if(x%2==1) {
			System.out.println("("+m1+") "+ i+"+"+j+"=");
			}else {
			System.out.println("("+m1+") "+ i+"-"+j+"=");
			}
			m1++;
		}	
		
		System.out.println("------------标准答案-----------");
		int m2=1;
		for(int a=0;a<n;a++) {
		if(ax[a]%2==1) {
		System.out.println("("+m2+") "+ ai[a]+"+"+aj[a]+"="+(ai[a]+aj[a]));
		}else {
		System.out.println("("+m2+") "+ ai[a]+"-"+aj[a]+"="+(ai[a]-aj[a]));
		}
		m2++;
		}
		System.out.println("211606316  李震  2018年9月6日  0：07");
	}	
}

