package com.java.primarymath;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("out.txt");
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		int[] first=new int[100]; // 第一个数
		int[] second=new int[100];//第二个数
		String[] fuhao=new String[100]; //符号
		int[] pass=new int[100];//答案
		Scanner s = new Scanner(System.in);
		System.out.println("请输入需要的题目数量：");
		int n=s.nextInt();
		Random  r=new Random();
		int k,m,f,i=0;
		boolean p=true;
			while(p)
			{
			k=r.nextInt(100);
			m=r.nextInt(100);
			f=r.nextInt(10);
			if (f%2==0) {  //加法
				if(k+m<=100)
				{
					first[i]=k;
					second[i]=m;
					fuhao[i]="+";
					pass[i]=k+m;
					i++;
					
				}
			}
			else	//减法
			{
				if(k-m>=0)
				{
					//System.out.println("("+(i+1)+") "+k+" - "+m+" = ");
					first[i]=k;
					second[i]=m;
					fuhao[i]="-";
					pass[i]=k-m;
					i++;
				}
			}
			if(i==n)
				break;
		}
			for (int j = 0; j < n; j++) {
				System.out.println("("+(j+1)+") "+first[j]+" "+fuhao[j]+" "+second[j]+" =");
				
			}
			System.out.println("标准答案");
			for (int j = 0; j < n; j++) {
				System.out.println("("+(j+1)+") "+first[j]+" "+fuhao[j]+" "+second[j]+" = "+pass[j]);
				
			}
			 // byte[] ti =timu[i-1].getBytes();	// 将字符串转换为字节流为了写入txt文件
		      //byte[] da =daan[i-1].getBytes();
		      //byte[] h=huanhang.getBytes();
		      //u.write(ti);	// 将转换好的字节流写入txt
		      //u.write(h);

	}
	}
	
