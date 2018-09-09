import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MathExam6335 {
	/*
	 * 完成一个命令行工具MathExam，自动生成一份小学一年级的数学加减计算题。
	 *     1.输入：用命令行参数接收一个n，表示出n道题
	 *     2.输出：把题目和标准答案写入out.txt文件[未完成]
	 * 		coding ： utf-8
	 * 		MathExam_V1.0.1
	 */	
	int firstNumber, secondNumber;		
	int symbol;	
	int count;		
	int result;		
	
	String[] str_ArithmeticProblem = new String[100];	//存放算术题
	String[] str_MathAnswer = new String[100];	//存放算术题及答案
	
	public MathExam6335() {
		// TODO Auto-generated constructor stub
//		this.count = count
//		System.out.print("请输入算术题数目：");
//		Scanner in =new Scanner(System.in);
//		count = in.nextInt();
		inPut();
		mathProblem(count);
		for (int i = 0; i < count; i++) {
			System.out.println(str_ArithmeticProblem[i]);
		}
		System.out.println("===============标准答案===============");
		for (int i = 0; i < count; i++) {
			System.out.println(str_MathAnswer[i]);
		}
	}
	
	private void inPut() {
		// TODO Auto-generated method stub
		System.out.print("请输入算术题数目：");
		Scanner in =new Scanner(System.in);
		count = in.nextInt();
	}
	
	//生成算术题
	public void mathProblem(int count) {	
		Random rnd = new Random();
		
		for (int i = 0; i < count; i++) {
			symbol = rnd.nextInt(2);
			firstNumber = (int)(Math.random()*100+1);
			secondNumber = (int)(Math.random()*100+1);
			
			if(symbol == 0){		//判断符号类型
				result = firstNumber + secondNumber;
				
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " + " + secondNumber + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " + " + secondNumber + " = " + result;
			}else if(symbol == 1){
				result = firstNumber - secondNumber;
				
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " - " + secondNumber + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " - " + secondNumber + " = " + result;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MathExam6335();

	}
}
