package com.java.Task01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MathExam6353 {
	public static void main(String[] args) throws IOException {

		int x;
		int y;
		int f;
		
		File file = new File("out.txt");
		//创建指向文件的数据输出流
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("小学一年级数学加减计算题");
		System.out.println("请输入题目数量：");
		//获取控制台输入题目数量n
		
	
		int n = input.nextInt();

		//生成题目
		for (int i = 1; i <= n; i++) {
			//生成两个随机数
			x = (int)(Math.random()*100+1);
			y = (int)(Math.random()*100+1);
			f = (int)(Math.random()*2);
			//判断加法和减法  0为加法
			if(f==0) {
				//生成减法
				System.out.println("("+ i +") " + x +" - "+ y + " =");
				String str1 = ("("+ i +") " + x +" - "+ y + " = " + (x-y));
				//写入数据
				out.writeUTF(str1);
//				System.out.println(str);
			}	
			else {
				//生成加法
				System.out.println("("+ i +") " + x +" + "+ y + " =");
				String str1 = ("("+ i +") " + x +" + "+ y + " = " + (x+y));
				//写入数据吧
				out.writeUTF(str1);
//				System.out.println(str);
			}
		}
		out.close();
		
		System.out.println("------------------标准答案------------------");
		
		//创建指向文件的数据输入流
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		//读数据
		for (int i = 0; i < n; i++) {
			System.out.println(in.readUTF());
		}
		in.close();
		//输出日期和学号姓名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		System.out.println("              211606353 姓名：陈炳旭  " +sdf.format(new Date(n)));
	}//main

	
	
}

