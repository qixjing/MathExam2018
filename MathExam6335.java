
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MathExam6335 {
	/*
	 * 完成一个命令行工具MathExam，自动生成一份小学一年级的数学加减计算题。
	 *     1.将mathProblem方法中判断运算符号的“if-else”语句改为“switch”；
	 *     2.添加一个全局变量String cutLine；
	 *     3.实现功能：把题目和标准答案写入out.txt文件。
	 * 		coding ： utf-8
	 * 		MathExam_V1.0.2
	 */	
	int firstNumber, secondNumber;		
	int symbol;	
	int count;		
	int result;	
	String cutLine = "====================标准答案====================";
	
	String[] str_ArithmeticProblem = new String[100];	//存放算术题
	String[] str_MathAnswer = new String[100];	//存放算术题及答案
	
	public MathExam6335() {
		// TODO Auto-generated constructor stub
		inPut();
		mathProblem(count);
		for (int i = 0; i < count; i++) {
			System.out.println(str_ArithmeticProblem[i]);
		}
		System.out.println("===============标准答案===============");
		for (int i = 0; i < count; i++) {
			System.out.println(str_MathAnswer[i]);
		}
		outPut();
	}
	
	private void inPut() {
		// TODO Auto-generated method stub
		System.out.print("请输入算术题数目：");
		Scanner in =new Scanner(System.in);
		count = in.nextInt();
	}
	
	private void outPut() {
		// TODO Auto-generated method stub
		File file = new File("out.txt");
		if(!file.exists()){	//判断文件是否存在
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			String str = "\r\n";
			byte[] bytes = str.getBytes();
			byte[] bytescut = cutLine.getBytes();
			
			FileOutputStream fos = new FileOutputStream(file);
			for (int i = 0; i < count; i++) {
				byte[] b_ArithmeticProblem = str_ArithmeticProblem[i].getBytes();
				fos.write(b_ArithmeticProblem);
				fos.write(bytes);
			}
			fos.write(bytescut);
			fos.write(bytes);
			fos.flush();
			for (int i = 0; i < count; i++) {
				byte[] b_MathAnswer = str_MathAnswer[i].getBytes();
				fos.write(b_MathAnswer);
				fos.write(bytes);
			}
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//生成算术题
	public void mathProblem(int count) {	
		Random rnd = new Random();
		
		for (int i = 0; i < count; i++) {
			symbol = rnd.nextInt(2);
			firstNumber = (int)(Math.random()*100+1);
			secondNumber = (int)(Math.random()*100+1);
			
			switch (symbol) {
			case 0:
				result = firstNumber + secondNumber;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " + " + secondNumber + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " + " + secondNumber + " = " + result;
				break;
				
			case 1:
				result = firstNumber - secondNumber;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " - " + secondNumber + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " - " + secondNumber + " = " + result;
				
			default:
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MathExam6335();

	}
}
