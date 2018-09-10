
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
	 *     1.修改input()方法为static类型，并接受一个命令行传入的string参数；
	 *     2.在input()方法内添加正则表达式判断接收的参数为非零正整数；
	 *     【ps：还存在输入“00000000001”的识别错误bug，待修正】
	 *     3.将全局变量count增加static类型。
	 * 		coding ： GBK
	 * 		MathExam_V1.0.4
	 */	
		int firstNumber, secondNumber;		
		int symbol;	
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
		
		private static void inPut(String args0) {
			// TODO Auto-generated method stub
			boolean flag;
			Scanner in = new Scanner(System.in);
			String regex = "[1-9]{1}[0-9]{0,2}";		//正则表达式判断输入参数为非零正整数
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
		
		//生成算术题
		public void mathProblem(int count) {	
			Random rnd = new Random();
			
			for (int i = 0; i < count; i++) {
				symbol = rnd.nextInt(4);
				firstNumber = (int)(Math.random()*100+1);
				secondNumber = (int)(Math.random()*100+1);
				
				switch (symbol) {
				case 0:		//加法
					result = firstNumber + secondNumber;
					str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " + " + secondNumber + " = ";
					str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " + " + secondNumber + " = " + result;
					break;
					
				case 1:		//减法
					result = firstNumber - secondNumber;
					str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " - " + secondNumber + " = ";
					str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " - " + secondNumber + " = " + result;
					
				case 2:		//乘法
					result = firstNumber * secondNumber;
					str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " x " + secondNumber + " = ";
					str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " x " + secondNumber + " = " + result;
					
	/*
	 * 2个整数相除结果会取整，除数和余数之中有一个为小数，则结果也是小数，当被除数为0时，有三种情况： 
	 * 1. 除数为整数时：发生异常
	 * 2. 除数为小数时：Infinity（正无穷大）或-Infinity（负无穷大） 
	 * 3. 除数为0.0时：NaN （非数字）
	*/
				case 3:		//除法
					if(firstNumber % secondNumber == 0){
						result = firstNumber / secondNumber;
						str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " / " + secondNumber + " = ";
						str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " / " + secondNumber + " = " + result;
					}else if(firstNumber % secondNumber != 0){
						result = firstNumber / secondNumber;
						str_ArithmeticProblem[i] = "(" + (i+1) +") " + firstNumber + " / " + secondNumber + " = ";
						str_MathAnswer[i] = "(" + (i+1) +") " + firstNumber + " / "
								+ secondNumber + " = " + result + "..." + (firstNumber % secondNumber);
					}
						
				default:
					break;
				}
			}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathExam6335.inPut(args[0]);
		new MathExam6335();

	}
}
