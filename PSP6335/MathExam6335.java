
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathExam6335 {
	/*
	 * 完成一个命令行工具MathExam，自动生成一份小学一年级的数学四则运算题。
	 *     1.为加减乘除运算方法添加了符合实际的限制；
	 *     
	 *     【ps：还存在输入“00000000001”的识别错误bug，待修正】
	 * 		coding ： GBK
	 * 		MathExam_V1.0.6
	 */	
	int firstNumber, secondNumber;		
	int symbol;	
	static int grade;
	static int count;		
	int result;		
	String cutLine = "====================标准答案====================";
	
	String[] str_ArithmeticProblem = new String[100+1];	//存放算术题
	String[] str_MathAnswer = new String[100+1];	//存放算术题及答案
	
	public MathExam6335() {
		// TODO Auto-generated constructor stub
		mathProblem(count);
		
		for (int i = 0; i < count; i++) {
			System.out.println(str_ArithmeticProblem[i]);
		}
		System.out.println(cutLine);
		for (int i = 0; i < count; i++) {
			System.out.println(str_MathAnswer[i]);
		}
		
		outPut();
	}
	
	private static void inPut(String args0,String args1) {
		// TODO Auto-generated method stub
		boolean flag;
		Scanner in = new Scanner(System.in);
		String regex = "[1-9]{1}[0-9]{0,1}";		//正则表达式判断输入参数为非零正整数
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		while (true) {
			matcher = pattern.matcher(args0);
			try {
				flag = matcher.matches();
				if(!flag){
					throw new NumberFormatException();
				} else {
					count = Integer.valueOf(args0);
					grade = Integer.valueOf(args1);
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("输入错误，请重新输入题目数量 : ");
				args0 = in.next();
				continue;
			}			
			break;
		}
	}
	
	private void outPut() {
		// TODO Auto-generated method stub
		File file = new File("out.txt");
		
		if(!file.exists()){	//判断文件是否存在
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("文件创建时出现错误!");
			}
		}
		
		try {
			String str = "\r\n";
			byte[] bytes = str.getBytes();		//string类型转换为能被机器识别的二进制码
			byte[] bytescut = cutLine.getBytes();
			
			FileOutputStream fos = new FileOutputStream(file);	
			for (int i = 0; i < count; i++) {
				byte[] b_ArithmeticProblem = str_ArithmeticProblem[i].getBytes();
				fos.write(b_ArithmeticProblem);
				fos.write(bytes);
			}
			fos.write(bytescut);
			fos.write(bytes);
			fos.flush();	//刷新内存
			for (int i = 0; i < count; i++) {
				byte[] b_MathAnswer = str_MathAnswer[i].getBytes();
				fos.write(b_MathAnswer);
				fos.write(bytes);
			}
			fos.flush();
			fos.close();	//关闭文件输出流
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("未找到指定文件!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件写入有误!");
		} 
		
	}
	
	/*
	 * 加法：
	 *  1.一二年级的加法的两个加数在20以内。
	 * 
*/
	private void add(int n1, int n2,int i) {
		// TODO Auto-generated method stub
		result = n1 + n2;
		str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " + " + n2 + " = ";
		str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " + " + n2 + " = " + result;
	}
	
	/*
	 * 减法：
	 * 
	 * 1.一二年级两数之差应该在大于0；
	 * 2.被减数和减数在20以内。
*/
	private void sub(int n1, int n2,int i) {
		// TODO Auto-generated method stub
		if (n1 < n2) {
			int num;
			num = n1;
			n1 = n2;
			n2 = num;
		}
		result = n1 - n2;
		str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " - " + n2 + " = ";
		str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " - " + n2 + " = " + result;
	}
	
	/*
	 * 乘法：
	 * 
	 * 1.一二年级的乘法运算应该在0-9以内【九九乘法表】；
	 * 
*/
	private void mul(int n1, int n2,int i) {
		// TODO Auto-generated method stub
		if (n1 > 9) {
			n1 = (int)(Math.random()*10);
		} 
		if (n2 > 9) {
			n2 = (int)(Math.random()*10);
		}
		result = n1 * n2;
		str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " x " + n2 + " = ";
		str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " x " + n2 + " = " + result;
	}
	
	/*
	 * 除法：
	 * 
	 * 1.一二年级的除法运算应该在”九九乘法表“范围以内；
	 * 2.分母不能为”0“。
	 * 
*/
	private void div(int n1, int n2,int i) {
		// TODO Auto-generated method stub
		while(true){
			if(n1 % n2 == 0){
				result = n1 / n2;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = " + result;
			}else if(n1 % n2 != 0){
				n1 = (int)(Math.random()*82);
				n2 = (int)(Math.random()*81+1);
				continue;
			}
			break;
		}
	}
	
	//生成算术题
	public void mathProblem(int count) {	
		Random rnd = new Random();
		
		for (int i = 0; i < count; i++) {
			symbol = rnd.nextInt(grade*2);
			firstNumber = (int)(Math.random()*100+1);
			secondNumber = (int)(Math.random()*100+1);
			
			if(grade == 1){
				switch (symbol) {
				case 0:
					add(firstNumber,secondNumber,i);
					break;
					
				case 1:
					sub(firstNumber,secondNumber,i);
					break;

				default:
					break;
				}
			} else {
				switch (symbol) {
				case 0:
					add(firstNumber,secondNumber,i);
					break;
					
				case 1:
					sub(firstNumber,secondNumber,i);
					break;
					
				case 2:
					mul(firstNumber,secondNumber,i);
					break;
					
				case 3:
					div(firstNumber,secondNumber,i);
					break;

				default:
					break;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathExam6335.inPut(args[0], args[1]);
		new MathExam6335();

	}
}
