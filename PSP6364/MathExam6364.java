

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MathExam6364 {
	public static void main(String[] args) throws IOException{
		int num = 0 ;
		boolean flag = true;// 做个标记
		int grade = 1;// 默认为一年级
		while(flag) {
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			String stringArray[] = str.split(" ");// 使用" "空格来分隔字符串成一个字符串数组
			if(stringArray.length > 1 ){ // 长度为1即默认只输入题目数目，年级为一年级
				try {
					num = Integer.parseInt(stringArray[0]);
					grade = Integer.parseInt(stringArray[1]);						
					}catch(NumberFormatException e){
						System.out.println("请正确输入！");
						continue;						
					}
				if (stringArray.length > 2) {
					System.out.println("请正确输入！(题目数 年级)");
					continue;
				}
				num = Integer.parseInt(stringArray[0]);
				grade = Integer.parseInt(stringArray[1]);
				if (num < 1 || num >10000) {
					System.out.println("请输入1~10000的正数！");
					continue;
				}
				if (grade != 1 && grade != 2) {
					System.out.println("请输入正确的年级（1 or 2）");
					continue;
				}
				break;					
				}
			else {
				try {
					num = Integer.parseInt(stringArray[0]);
					}catch(NumberFormatException e) {
						System.out.println("请输入正整数的题目数！");
						continue;
					}
			}
			num = Integer.parseInt(stringArray[0]);
			break;
			}
		mathExam6364(num,grade);
}
	static void mathExam6364(int num,int grade) throws IOException {
		// 没输入的话grade默认为1，进行任务1
		PrintStream sysout = System.out;// 先把系统输出流保存到sysout
		PrintStream ps = new PrintStream("e:/out.txt"); // 新创建一个输出流，并在e盘新建一个 out.txt
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
			for (int s = 0;s < num;s ++) {
				System.setOut(ps);
				System.out.println("(" + (s+1) + ") " + list1.get(s));
				}
			System.out.println(" ");
			for (int p = 0;p < num;p ++) {
				System.setOut(ps);
				System.out.println("(" + (p+1) + ") " + list2.get(p));
				}
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
				for (int s = 0;s < num;s ++) {
					System.setOut(ps);
					System.out.println("(" + (s+1) + ") " + list1.get(s));
				}
				System.out.println(" ");
				for (int p = 0;p < num;p ++) {
					System.setOut(ps);
					System.out.println("(" + (p+1) + ") " + list2.get(p)); 
				}
			}
			Date day = new Date();
			// 获取当前系统时间，并将输出改为yyyy年MM月dd日  HH:mm
			SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日  HH:mm");
			System.setOut(ps);
			System.out.println("                 211606364李冠锐"+df.format(day));
			File file = new File("e:/out.txt");
			FileReader reader = new FileReader(file);
			int fileLen = (int)file.length();
			char[] chars = new char[fileLen];
			reader.read(chars);
			String txt = String.valueOf(chars);
			System.setOut(sysout);
			System.out.println(txt);
			
	}
	}