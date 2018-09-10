package com.MathExam6364;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MathExam6364 {
	public static void main(String[] args) throws FileNotFoundException{
	Scanner input = new Scanner(System.in);
	boolean flag = true;// 做一个标记
	while(flag) {
	String str = input.nextLine();
	int num = 0;
	int grade = 1;// 默认年级为一年级
	int i = 0;
	char ch = str.charAt(i);
	while (ch != ' ') {
		i++;
		if (i == str.length()) {
			break;
		}else {
			ch = str.charAt(i);
		}
		}
    num = Integer.parseInt(str.substring(0, i));// 获取第一个数字赋值给num
	if (i != str.length()) {
		grade = Integer.parseInt(str.substring(i+1,str.length()));}// 若有第二个值，则获取第二个值给grade
	if (grade > 2) {
		System.out.println("请输入正确的年级！(1 or 2)");
	}else{
		if (num <= 0 || num >= 10000){
			System.out.println("输入的数字不在范围之内（1~10000）！请重新输入！");
		}else {
			flag = false;
			mathExam6364(num,grade);// 产生随机数和运算的方法
		}
		}
	}
}
	static void mathExam6364(int num,int grade) throws FileNotFoundException {
		// 没输入的话grade默认为1，进行任务1
		PrintStream ps = new PrintStream("e:/out.txt"); 
		List<String> list1 = new ArrayList<String>();// 用来存放式子
		List<String> list2 = new ArrayList<String>();// 用来存放式子加答案
		if (grade == 1) {
			for (int i = 0;i < num;i ++){
				int num1 = (int)(Math.random()*100);// 产生第一个随机整数
				int num2 = (int)(Math.random()*100);// 产生第二个随机整数
				int c = Math.random()>0.5?1:0;// 随机0或1，0为加法，1为减法
				int k;
				if(c == 0){
					k = num1 + num2;
					if (k <= 50) {// 若和大于100， 则舍弃
						list1.add(num1 + " + " + num2 + " = ");
						list2.add(num1 + " + " + num2 + " = "+k);
				}else { 
					i--;}
				}
				if(c == 1){
					k = num1 - num2;
					if (k >= 0) {// 若差小于0，则舍弃
						list1.add(num1 + " - " + num2 + " = ");
						list2.add(num1 + " - " + num2 + " = " + k);
					}else {
						i--;}
					}
			}
			for (int s = 0;s < num;s ++) 
				System.out.println("(" + (s+1) + ") " + list1.get(s));
			System.out.println(" ");
			for (int p = 0;p < num;p ++) 
				System.out.println("(" + (p+1) + ") " + list2.get(p)); 
		}
		// 若grade为2，进行任务2
		if (grade == 2) {	
			for (int i = 0;i < num;i ++){
				int num1 = (int)(Math.random()*20);// 产生第一个随机整数
				int num2 = (int)(Math.random()*20);// 产生第二个随机整数
				int c = Math.random()>0.5?1:0;// 随机0或1，0为乘法，1为除法
				int k;
				int x;
				if(c == 0){
					k = num1 * num2;
					if (k <= 100) {// 若乘积大于100， 则舍弃
						list1.add(num1 + " × " + num2 + " = ");
						list2.add(num1 + " × " + num2 + " = " + k);
						}
					else
						i--;
					}
				if(c == 1){
					k = num1 / num2;
					x = num1 % num2;
					if (num2 != 0) {//若除数等于0，则舍弃
						list1.add(num1 + " ÷ " + num2 + " = ");
					if (x != 0) {
						list2.add(num1 + " ÷ " + num2 + " = " + k + "..." + x);
					}else
						list2.add(num1 + " ÷ " + num2 + " = " + k);
					}else
						i--;
					}
				}
				for (int s = 0;s < num;s ++) System.out.println("(" + (s+1) + ") " + list1.get(s));
				System.out.println(" ");
				for (int p = 0;p < num;p ++) System.out.println("(" + (p+1) + ") " + list2.get(p)); 
			}
			Date day = new Date();
			// 获取当前系统时间，并将输出改为yyyy年MM月dd日  HH:mm
			SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日  HH:mm"); 
			System.out.println("                 211606364李冠锐"+df.format(day));  
	}
	}
	