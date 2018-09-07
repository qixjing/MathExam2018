import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;

public class MathExam {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String filename ="out.txt";
		String str[]= {"+","-"};
		File file = new File(filename);
		if(!file.exists()) 
		{		File parent = file.getParentFile();
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
		try 
		{
			OutputStream out = new FileOutputStream(file);
			System.out.print("请问需要出多少道题：");
			int number = input.nextInt();
			int Symbol;
			Random ranNum = new Random(101);
			Random ranStr = new Random(4);
			int number1 = 0,number2 = 0,Sum = 0;
			String left_brackets="(",right_brackets=")";
			for (int i = 1; i <= number; i++) 
			{
				number1 = ranNum.nextInt(100);
				number2 = ranNum.nextInt(100);
				Symbol = ranStr.nextInt(2);
				if(str[Symbol].equals("+")==true && number1 + number2 >100
					|| str[Symbol].equals("-")==true && number1 - number2 <0
					)
				{	
					i--;
					continue;
				}
				else
				{
					if(str[Symbol].equals("+")==true)
						Sum = number1 + number2;
					else
						Sum = number1 - number2;
					try {
						out.write(left_brackets.getBytes());
						out.write(Integer.toString(i).getBytes());
						out.write(right_brackets.getBytes());
						out.write(" ".getBytes());
						out.write(Integer.toString(number1).getBytes());
						out.write(" ".getBytes());
						out.write(str[Symbol].getBytes());
						out.write(" ".getBytes());
						out.write(Integer.toString(number2).getBytes());
						out.write(" ".getBytes());
						out.write("=".getBytes());
						out.write(" ".getBytes());
						out.write(Integer.toString(Sum).getBytes());
						out.write("\n".getBytes());
					} 
					catch (IOException e) 
					{
						System.out.println("程序在out.write()时抛出异常"+e.getMessage());
					}
					
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("程序在new FileOutputStream(file)时抛出异常"+e.getMessage());
		}
		
		
		
	}

}
