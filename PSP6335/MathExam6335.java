
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathExam6335 {
	/*
 * 完成一个命令行工具MathExam，自动生成一份小学一年级的数学四则运算题。
 *     1.增加了对年级参数的识别。；
 *     2.确保命令行接受的参数是空、一个参数、两个参数和多个参数都能运行。
 *     【默认值——空参数：题数为”10“，年级为”2“；    一个参数：年级默认值为”2“； 
 *     						两个参数无需使用默认值；       多个参数只接受前两个参数值。】
 *     【ps：还存在输入“00000000001”的识别错误bug，待修正】
 * 		coding ： GBK
 * 		MathExam_V1.0.8
 */	
	int firstNumber, secondNumber;		
	int symbol;	
	static int grade;
	static int count;		
	int result;		
	String cutLine = "====================标准答案====================";
	
	String[] str_ArithmeticProblem = new String[100+1];	//存放算术题
	String[] str_MathAnswer = new String[100+1];	//存放算术题及答案
	
	//输入的参数为空值
	public MathExam6335(){
		String count_Default = "10";	//定义参数默认值
		String grade_Default = "2";
		inPut(count_Default, grade_Default);
		mathProblem(count);
		outPut();
	}
	
	//输入的参数只有一个
	public MathExam6335(String args0){
		String grade_Default = "2";
		inPut(args0, grade_Default);
		mathProblem(count);
		outPut();
	}
	
	//输入的参数个数正常
	public MathExam6335(String args0,String args1){
		inPut(args0, args1);
		mathProblem(count);
		outPut();
	}

	public void inPut(String str0,String str1) {
		// TODO Auto-generated method stub
		boolean flag1 = true;
		boolean flag2 = true;
		
		Scanner in = new Scanner(System.in);
		String regex1 = "[1-9]{1}[0-9]{0,1}";		//正则表达式判断输入参数为非零正整数
		String regex2 = "[1-2]{1}{0}";
		Pattern pattern1 = Pattern.compile(regex1);
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher1,matcher2;
		
		while (true) {
			
			matcher1 = pattern1.matcher(str0);
			matcher2 = pattern2.matcher(str1);
			
			try {
				flag1 = matcher1.matches();
				flag2 = matcher2.matches();
				
				if(!flag1 || !flag2){	
						throw new NumberFormatException();		
				} else {	
					count = Integer.valueOf(str0);
					grade = Integer.valueOf(str1);
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				if(!flag1){
					System.out.println("输入错误，只能输入99以内的题目数量，请按规定重新输入题目数量 : ");
					str0 = in.next();
				} 
				if(!flag2){
					System.out.println("输入错误，年级为\"1\"或\"2\" ，请按规定重新输入年级 : ");
					str1 = in.next();
				}
				continue;
			}			
			break;
		}
	}
	
	private void outPut() {
		// TODO Auto-generated method stub
		File file = new File("out.txt");
		Date date = new Date();//创建一个时间对象，获取到当前的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置时间显示格式
		String currentTime = "\r\n         211606335   吴沂章   " + sdf.format(date);//将当前时间格式化为需要的类型
		byte[] bytesdate = currentTime.getBytes();

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
			fos.write(bytesdate);
			fos.flush();
			fos.close();	//关闭文件输出流
			
			System.out.print("-------  本次共生成" + count + "道小学"+ grade + "年级算数题，请打开out.txt文件查看详情    -------");
			
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
	private void div(int i) {
		// TODO Auto-generated method stub
		while(true){
			int n1 = (int)(Math.random()*82);
			int n2 = (int)(Math.random()*81+1);
			if(n1 % n2 == 0){
				result = n1 / n2;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = " + result;
			}else if(n1 % n2 != 0){
				result = n1 / n2;
				str_ArithmeticProblem[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = ";
				str_MathAnswer[i] = "(" + (i+1) +") " + n1 + " / " + n2 + " = " + result + "..." + (n1 % n2);
			}
			break;
		}
	}
	
	//生成算术题
	public void mathProblem(int count) {	
		Random rnd = new Random();
		
		for (int i = 0; i < count; i++) {
			symbol = rnd.nextInt(grade*2);
			firstNumber = (int)(Math.random()*20+1);
			secondNumber = (int)(Math.random()*20+1);
			
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
					div(i);
					break;

				default:
					break;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 0){
			new MathExam6335();
		} else if(args.length == 1){
			new MathExam6335(args[0]);
		}
		else if(args.length == 2){
			new MathExam6335(args[0], args[1]);
		}else {
			new MathExam6335(args[0], args[1]);
		}
		

	}
}
