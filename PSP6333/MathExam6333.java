import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MathExam6333 {
	static int n;
	static int grade;
	public static void main(String args[]) throws FileNotFoundException {
		if(args.length==1) {//判断参数个数
			try {
 				n = Integer.parseInt(args[0]);
 				if (n <= 0) {
 					System.out.println("题目数量不能为0或负数，请重新输入！");
 				}
 			} catch(NumberFormatException e) {
 				System.out.println("题目数量必须为正整数，请重新输入！");
 			}
			String[] str=  new String[50];
			File file =new File("out6333.txt");//把题目答案放到txt文件里
			PrintStream ps = new PrintStream(file);
			System.setOut(ps);
			n = Integer.parseInt(args[0]);
			grade1(n,str);
			System.out.println("-------------标准答案------------");
			answer(n,str);
			}
		if(args.length==2) {//如果参数是两个该如何处理
			try {
 				n = Integer.parseInt(args[0]);
 				grade=Integer.parseInt(args[1]);
 				if (n <= 0) {
 					System.out.println("题目数量不能为0或负数，请重新输入");
 				}
 				else if(grade>2) {
 					System.out.println("高年级题目还未编译完成，敬请期待！");
 				}
 				else if(grade<=0) {
 					System.out.println("年级不能为0或负数，请重新输入！");
 				}
 			} catch(NumberFormatException e) {
 				System.out.println("题目数量必须为正整数，请重新输入！");
 			}
			n=Integer.parseInt(args[0]);//判断题目个数
			grade=Integer.parseInt(args[1]);//判断年级
			String[] str=  new String[50];
			File file =new File("out6333.txt");//把题目答案放到txt文件里
			PrintStream ps = new PrintStream(file);
			System.setOut(ps);
			if(grade==1) {
				grade1(n,str);
				System.out.println("-------------标准答案------------");
				answer(n,str);
			}
			if(grade==2) {
			grade2(n,str);
			System.out.println("-------------标准答案------------");
			answer(n,str);
			}
		}
	}
	public static void grade1(int n,String[] str) {//出题的方法
		for(int i=0;i<n;i++) {
			int n1=(int)(0+Math.random()*(2-1+1));//随机生成0和1，用来判断加法或者减法，0为加法，1为减法
			int n2=(int)(0+Math.random()*(100-1+1));
			int n3=(int)(0+Math.random()*(100-1+1));
			if(n1==0) {
				while(n2+n3>100) {//两数之和不能大于100
					n2=(int)(0+Math.random()*(100-1+1));
					n3=(int)(0+Math.random()*(100-1+1));
				}
				int n4 = n2+n3;
				System.out.println("("+(i+1)+")"+n2+" "+"+"+" "+n3+" "+"=");
				 str[i]= "("+(i+1)+")"+n2+" "+"+"+" "+n3+" "+"="+" "+n4;//把题目和答案保存在str数组里面	
			}
			if(n1==1) {
				while(n2-n3<0) {//两数之差不能小于0
				 n2=(int)(0+Math.random()*(100-1+1));
				 n3=(int)(0+Math.random()*(100-1+1));
				}
				System.out.println("("+(i+1)+")"+n2+" "+"-"+" "+n3+" "+"=");
				int n4 = n2-n3;
				 str[i]= "("+(i+1)+")"+n2+" "+"-"+" "+n3+" "+"="+" "+n4;
				}
			}
	}
	public static void grade2(int n,String[] str) {
		for(int i=0;i<n;i++) {
			int n1=(int)(0+Math.random()*(2-1+1));//随机生成0和1，用来判断加法或者减法，0为乘法，1为除法
			
			
			if(n1==0) {
				int n2=(int)(1+Math.random()*(10-1+1));
				int n3=(int)(1+Math.random()*(10-1+1));
				int x=n2*n3;
				System.out.println("("+(i+1)+")"+n2+" "+"*"+" "+n3+" "+"=");	
				str[i]= "("+(i+1)+")"+n2+" "+"*"+" "+n3+" "+"="+" "+x;
			}
			if(n1==1) {
				int n2=(int)(0+Math.random()*(100-1+1));
				int n3=(int)(1+Math.random()*(100-1+1));
				int x =n2/n3;
				int y=n2%n3;
				System.out.println("("+(i+1)+")"+n2+" "+"÷"+" "+n3+" "+"=");
				str[i]= "("+(i+1)+")"+n2+" "+"÷"+" "+n3+" "+"="+" "+x+"..."+y;
			}
			}
		
	}
	public static void answer(int n,String[] str) {//用来输出答案
		int i;
		for(i=0;i<n;i++) {
			System.out.println(str[i]);
			 
		}SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
			 System.out.println("              211606333 姓名：温志铭  " +sdf.format(new Date()));
	}
}