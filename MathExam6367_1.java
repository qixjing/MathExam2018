
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MathExam_1 {
	static Scanner input = new Scanner(System.in);
	static String filename ="out.txt";
	static String[] str = {"+","-","*","/"};
	static List<String> Calculation_problem = new ArrayList<String>();
	static int number1 = 0,Symbol = 0,number2 = 0,Sum = 0,
			Remainder = 0,number = -1,grade = -1,Calculation_Num = 0;			
	static Random ranNum = new Random(101);
	static Random ranStr = new Random(4);
	static String word = null,check_message = null;
	static File file = new File(filename),parent = null;
	static OutputStream out = null;
	static Pattern pattern = Pattern.compile("[0-9]*");
	public static void main(String[] args) {
			file_Initialization(file);//文档初始化生成
			Input_Message();//输入信息检测
			//生成合格的题目
			for (int i = 1; i <= number; i++) 
			{
				number1 = ranNum.nextInt(100);
				number2 = ranNum.nextInt(100);
				Symbol = ranStr.nextInt(2);
				if(str[Symbol].equals("+") && number1 + number2 > 100
					|| str[Symbol].equals("-") && number1 - number2 < 0
					)
				{	
					i--;
					continue;
				}
				else
				{
					if(str[Symbol].equals("+"))
						Sum = number1 + number2;
					else if(str[Symbol].equals("-"))
						Sum = number1 - number2;
					else
						return;
					file_write_problem(str, number1, number2, Sum, Symbol, out, i);//将题目写入文档
				}
			}
			if(number!=0)
				file_write_answer();//将答案写入文档
	}


	private static void Input_Message() {
		System.out.print("请问需要出多少道题：");
		while(number<0)
		{
			check_message = input.nextLine();
			if(!pattern.matcher(check_message).matches())
			{	
				System.out.println("输入的题数不合法！请重新输入题数：");
				continue;
			}
			number = Integer.parseInt(check_message);
			if(number < 0)
				System.out.println("输入的题数不合法！请重新输入题数：");
			
		}
		check_message = null;
		System.out.print("请输入年级(请输入1或2)：");
		while(grade!=1 && grade!=2)
		{
			check_message = input.nextLine();
			if(!pattern.matcher(check_message).matches())
			{
				System.out.println("输入的年级不合法!请重新输入年级(1或2)：");
				continue;
			}
			grade = Integer.parseInt(check_message);
			if(grade!=1 && grade!=2)
				System.out.println("输入的年级不合法!请重新输入年级(1或2)：");
		}
	}

	
	private static void file_write_answer() {
		try {
			out.write("\n".getBytes());
			for (int i = 0; i < Calculation_Num; i++)
			{
				out.write(Calculation_problem.get(i).getBytes());
			}
		} 
		catch (IOException e) {
			System.out.println("程序在写入计算题答案时异常："+e.getMessage());
		}
	}

	private static void file_write_problem(String[] str, int number1, int number2, int Sum, int Symbol, OutputStream out, int i) {
		try {
			word ="("+Integer.toString(i)+") "
					+Integer.toString(number1)+" "+str[Symbol]+" "+Integer.toString(number2)+" =";
			out.write((word+"\r\n").getBytes());
			if(Remainder!=0)
			{
				Calculation_problem.add(word+" "+Integer.toString(Sum)+"..."+Integer.toString(Remainder)+"\r\n");
				Calculation_Num++;
				Remainder = 0;
			}
			else
			{	
				Calculation_problem.add(word+" "+Integer.toString(Sum)+"\r\n");
				Calculation_Num++;
			}
		} 
		catch (IOException e) 
		{
			System.out.println("程序在out.write()时抛出异常"+e.getMessage());
		}
	}

	private static void file_Initialization(File file) {
		if(!file.exists()) 
		{		parent = file.getParentFile();
				if(parent !=null && !parent.exists())
				{	parent.mkdir();//创建目录
					System.out.println("创建目录："+parent);
				}
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.out.println("程序在file.createNewFile()时抛出异常"+e.getMessage());
				}
				System.out.println("创建新文件："+file.getAbsolutePath());
		}//获取绝对路径
		try {
			out = new FileOutputStream(file);
		} 
		catch (FileNotFoundException e) {
			System.out.println("程序在new FileOutputStream(file)时抛出异常"+e.getMessage());
		}
	}

}
