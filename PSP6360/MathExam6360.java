

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MathExam6360 {
	
	public static void create(int count,int grade) {
		File file = new File ("out.txt");//创建文本
		FileWriter fw=null;
			try {
				fw = new FileWriter(file);
			
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}	
			BufferedWriter bw = new BufferedWriter(fw);
		int first=0,symbol=0,second=0,mark=0,w=0;
		int [] an=new int[count];//创建数组，用于存储数据，存储答案。
		int [] bn=new int[count];//存储第一个数字，式子的第一个数；
		int [] cn=new int[count];//存储第二个数字，用于判断符号；
		int [] dn=new int[count];//存储第三个数字，式子的第二个数
		int [] en=new int[count];//存储余数；
		Random r =new Random(); 
		while(w <count) {
			
			
			if(mark==0) //判断题号是否需要更新，若需要则输入题号。
			{
				try {
					bw.write(String.valueOf("("+ (w+1) +") "));
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
			
		for(int i=0;i<4;i++)//循环四次，随机生成三个数。并在第四次进行符号判断，最后在文本输入式子。
		{
			if(i==0)
			{
				int number = (int)Math.floor((r.nextDouble()*100.0));//生成式子的第一个数
				first=number;
				bn[w]=first; //将式子的数字存入数组中，方便之后的提取
			}
			
			
			else if(i==1)
			{
				if(grade==1) 
				{
					int number = (int)Math.floor((r.nextDouble()*2.0));//生成第二个数字，用于判断符号
					symbol=number;
				}
				
				else if(grade==2)
				{
					int number = (int)Math.floor((r.nextDouble()*4.0));//生成第二个数字，用于判断符号
					symbol=number;
				}
				cn[w]=symbol;//将式子的数字存入数组中，方便之后的提取
				
			}
			
			
			else if(i==2)
			{	
				int number = 1+(int)Math.floor((r.nextDouble()*100.0));//生成第三个数字
				second=number;
				dn[w]=second;//将式子的数字存入数组中，方便之后的提取
			}		
			
			
			else if(i==3)
			{
				en[w]=0;//输入余数
				
				if (symbol==0)//判断符号，0为+号，1为-号，2为×号，3为÷号
				{   
					try {
						bw.write(String.valueOf(" "+ first+ " + " +second+" = "));//输入式子
						an[w]=first+second;//将答案存储在数组an中
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				
				}


				else if((symbol==1))
				{
					if(first-second < 0)
					{mark=1;break;}
					try {
						bw.write(String.valueOf(" "+ first+ " - " +second+" = "));//输入式子
						an[w]=first-second;//将答案存储在数组an中
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				}


				
				else if((symbol==2)) 
				{
					try {
						bw.write(String.valueOf(" "+ first+ " × " +second+" = "));//输入式子
						an[w]=first*second;//将答案存储在数组an中
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}


				
				else if((symbol==3)) 
				{
					
					
					try {
						en[w]=first % second;//将余数存入数组en中
						bw.write(String.valueOf(" "+ first+ " ÷ " +second+" = "));//输入式子
						an[w]=(int)(first/second);//将答案存储在数组an中
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			System.out.println(w);
			mark=0;//证明式子成功写入，题号需要更新。
			w++;
			
			}	
			
				
		}//内循环结束
	
				
		if(mark==0)//判断式子是否成功写入，如果成果则执行换行。
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}//while循环结束。
		
		
		
		try {
				
				bw.write(String.valueOf("-----------------标准答案 -----------------------"));
				bw.newLine();
				
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
		}
		

		for(int i=0;i<count;i++)//循环输出答案，利用数组。
		{
			
			if(cn[i]==0) //判断符号，0为+号，1为-号，2为×号，3为÷号
			{
				try {
					bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " + " +dn[i]+" = "+an[i]));//将整个式子输入进文本。
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
			
			else if(cn[i]==1) //判断符号，0为+号，1为-号，2为×号，3为÷号
			{
				try {
					bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " - " +dn[i]+" = "+an[i]));//将整个式子输入进文本。
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
			
			else if(cn[i]==2) //判断符号，0为+号，1为-号，2为×号，3为÷号
			{
				try {
					bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " × " +dn[i]+" = "+an[i]));//将整个式子输入进文本。
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}
			
			
			else if(cn[i]==3) //判断符号，0为+号，1为-号，2为×号，3为÷号
			{
				
				if(en[i]==0) //判断余数是否为0，为0则执行下列代码
				{
					try {
						bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " ÷ " +dn[i]+" = "+an[i]));//将整个式子输入进文本。
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				
				else if(en[i]!=0)//判断余数是否为0，不为0则执行下列代码
				{
					try {
						bw.write(String.valueOf("("+(i+1)+") "+ bn[i]+ " ÷ " +dn[i]+" = "+an[i]+ " ··· "+ en[i]));//将整个式子输入进文本，包括余数。
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

				}
			}
			
	
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		
		try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				}
	}
	public static void main(String[] args)  {
		// TODO 自动生成的方法存根
		String Regex="[1-9]{1}[0-9]{0,10}";//正则表达式，将输入的参数限定在正整数范围内，同时给予最大极限。
		String Regex2="[1-2]{1}";//正则表达式，将输入的参数限定在正整数范围内，同时给予最大极限。
		Pattern p =Pattern.compile(Regex);
		Pattern p2 =Pattern.compile(Regex2);		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
		Matcher count=p.matcher(args[0]);
		Matcher grade=p2.matcher(args[1]);
		
			if(count.find() &&  grade.find())
			{
				int num[] = new int [args.length];//创建数组，用于读取参数
				num [0] = Integer.parseInt(args[0]);//将参数转化为整型
				num [1] = Integer.parseInt(args[1]);//将参数转化为整型
				create(num[0],num[1]);
				break;
			}
			
			else
			{	
				System.out.println("输入错误，请重新输入参数(题数范围：1-99999999999，年级范围：1-2)：");
				String t = sc.nextLine();
				args = t.trim().split(" ");
				continue;
			}
		}
				
	}
}	
	

		
		

	

