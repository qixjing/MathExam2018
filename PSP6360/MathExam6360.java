

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class MathExam6360 {
	
	public static void create(int count) {
		File file = new File ("out.txt");//创建文本
		FileWriter fw=null;
			try {
				fw = new FileWriter(file);
			
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}	
			BufferedWriter bw = new BufferedWriter(fw);
		int first=0,symbol=0,second=0,sign=1,mark=0,w=0;
		int [] an=new int[count+5];
		int [] bn=new int[count+5];
		int [] cn=new int[count+5];
		int [] dn=new int[count+5];
		Random r =new Random(); 
		while(sign<=count) {
			if(mark==0) {//判断题号是否需要更新，若需要则输入题号。
		try {
			bw.write(String.valueOf("("+sign+") "));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			}
		for(int i=0;i<4;i++)//循环四次，随机生成三个数。并在第四次进行符号判断，最后在文本输入式子。
		{
			if(i==0)
			{int number = (int)Math.floor((r.nextDouble()*100.0));//生成式子的第一个数
			first=number;}
			else if(i==1)
			{
			 int number = (int)Math.floor((r.nextDouble()*2.0));//生成第二个数字，用于判断符号
			 symbol=number;
			}
			else if(i==2)
			{int number = (int)Math.floor((r.nextDouble()*100.0));//生成第三个数字
				second=number;}		
			else if(i==3)
			{
			 if (symbol==0)//判断符号，0为+号，1为-号
			 {  try {
				bw.write(String.valueOf(first+" + "+second+" = "));
				
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
				}
			 else if(symbol==1)//判断符号，0为+号，1为-号
			 {
				 if(first-second < 0)//判断式子的结果是否为负数，若是，则退出内循环，重新开始while循环。
					{mark=1;break;}
				try {
					bw.write(String.valueOf(first+" - "+second+" = "));
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			 	
			 	}
				if(symbol==0)//判断符号，然后把答案存入数组an
					{an[w]=first+second;}
				else if(symbol==1)
					{an[w]=first-second;}

				bn[w]=first; //将式子的数字存入数组中，方便之后的提取
				cn[w]=symbol;
				dn[w]=second;
				sign++;
			 	mark=0;//用于判断式子是否需要更新题号、
				w++;
			}
			
		}
		if(mark==0)
			try {
				bw.newLine();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		try {
			bw.write(String.valueOf("-----------------标准答案 -----------------------"));
			bw.newLine();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		

		for(int i=0;i<count;i++)//循环输出答案，利用数组。
		{
			if(cn[i]==0) {
				try {
					bw.write(String.valueOf("(" + (i+1) +") "+ bn[i]+" + "+dn[i]+" = "+an[i]));
					bw.newLine();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
			else if(cn[i]==1) {
				try {
					bw.write(String.valueOf("(" + (i+1) +") "+ bn[i]+" - "+dn[i]+" = "+an[i]));
					bw.newLine();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
					}
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
		int num[] = new int [args.length];//创建数组，用于读取参数
		num [0] = Integer.parseInt(args[0]);//将参数转化为整型
		create(num[0]);
		
		}	
	}

		
		

	

