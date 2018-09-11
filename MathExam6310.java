package com.MathExam.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MathExam6310 {
	
	private static StringBuffer topic = new StringBuffer();
	private static StringBuffer standAnswer = new StringBuffer();
	//用来保存输出的题目和标准答案
	private static int len;
	// 用户输入的题目数量
	private static String[] Operator = { " + ", " - "};

	public static void main(String[] args) {
		
		{
			int grade = 1;
			generatingTopic(len,grade);
			// 写入文件
			try {
				write310("out.txt");
				System.out.println(grade+"年级题目生成");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static void generatingTopic(int len,int grade) {
		for (int i = 1; i <= len; i++) {
			
			int a = (int) (Math.random() * 100);
			int b = (int) (Math.random() * 100);
			int n = 0;
			if(n%1!=0)
			System.out.println("error"+"输入的值必须是正整数");
			if(n<0 || n==0)
			System.out.println("error"+"输入的值必须是正整数");
			// 获取两个符合要求的数
			int index = (1 == grade) ? ((int) (Math.random() * 10)) % 2 : ((int) (Math.random() * 10)) % 4;
			String symbol = Operator[index];
			
			//确保和不超过100
			while(0 == index && a + b >= 100) {
				a = (int) (Math.random() * 100);
				b = (int) (Math.random() * 100);
			}
			
			// 计算结果
			int sum = 0;//和
			int job = 0;//差
			int merchant = 0;//商
			int ji = 0;//积
			int remainder = 0; // 余数
			switch (symbol) {
			case " + ":
				//确保数字符合要求
				if(grade==1 && a>10 && b >10 && a%10 != 0 && b%10 !=0) {
					b = b/10*10;
				}
				sum = a + b;
				break;
			case " - ":		
				//确保数字符合要求
				if (a < b) {
					int temp = a;
					a = b;
					b = temp;
				}
				//确保题目为两位数加减整十数和两位数加减一位数
				if(grade==1 && a>10 && b >10 && b%10 !=0) {
					b = b/10*10;
				}	
				job = a - b;
				break;
			case " * ":
				//确保为表内乘法
				a %= 10;
				b %= 10;
				ji = a * b;
				break;
			case " / ":
				//防止除数为0
				while(0 == b) {
					b = (int) (Math.random() * 100);
				}
				
				//确保为表内除法
				if(b>10) {
					b /=10 ;
				}
				
				merchant = a / b;
				remainder = a % b;
				break;
			
			}
			// 将题目和答案记录
			if(sum!=0)System.out.println(sum);
			if(job!=0)System.out.println(job);
			if(merchant!=0)System.out.println(merchant);
			if(ji!=0)System.out.println(ji);
				}
		}
	private static void write310(String filename) throws IOException {
		// ①：明确输入文件
		File file = new File(filename);
		File parentFile = file.getParentFile();
		if (parentFile != null && !parentFile.exists()) {
			parentFile.mkdirs();
			System.out.println("创建目录：" + parentFile);
		}
		file.createNewFile();
		// ②建立文件输入流
		OutputStream out = new FileOutputStream(file);
		// ③数据输入
		out.write(topic.toString().getBytes());
		out.write(System.lineSeparator().getBytes());
		out.write(standAnswer.toString().getBytes());
		// ④结束
		out.close();
	}
}