

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
public class MathExam6360 {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		File file = new File ("out.txt");//创建文本
		int num[] = new int [args.length];//创建数组，用于读取参数
	
		if(!file.exists())//判断文件是否存在，不存在侧创建
		{
		file.createNewFile();
		System.out.println("out.txt创建完成");
		}
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		num [0] = Integer.parseInt(args[0]);//将参数转化为整型
		int first=0,symbol=0,second=0,sign=1,q=0,mark=0,w=0;
		int [] an=new int[num[0]];
		int [] bn=new int[num[0]];
		int [] cn=new int[num[0]];
		int [] dn=new int[num[0]];
		
		Random r =new Random(); 
		while(sign<=num[0]) {
			if(mark==0) {//判断题号是否需要更新，若需要则输入题号。
		bw.write(String.valueOf("("+sign+")"+" "));
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
			 {  bw.write(String.valueOf(" "+ first+" "));
				bw.write(String.valueOf("+"));
			 	bw.write(String.valueOf(" "+second+" "));
			 	bw.write(String.valueOf("="));
				sign++;
				mark=0;//证明式子成功写入，题号需要更新。
				bn[w]=first;
				cn[w]=0;
				dn[w]=second;
				w++;
				}
			 else if(symbol==1)//判断符号，0为+号，1为-号
			 {
				 if(first-second < 0)//判断式子的结果是否为负数，若是，则退出内循环，重新开始while循环。
					{mark=1;break;}
				bw.write(String.valueOf(" "+ first+" "));
				bw.write(String.valueOf("-"));
				bw.write(String.valueOf(" "+second+" "));
				bw.write(String.valueOf("="));
			 	sign++;
			 	mark=0;
				bn[w]=first;
				cn[w]=1;
				dn[w]=second;
				w++;
			 	}
			for(;;)
			 {
				if(symbol==0)//判断符号，然后把答案存入数组an
				{	an[q]=first+second;q++;break;}	
				else if(symbol==1)
				{	an[q]=first-second;q++;break;}
			 }
			}
			
		}
		if(mark==0)
		bw.newLine();
		}
		bw.write(String.valueOf("-----------------标准答案 -----------------------"));
		bw.newLine();
		int flag=1;
		for(int i=0;i<num[0];i++)//循环输出答案，利用数组。
		{
			if(cn[i]==0) {
			bw.write(String.valueOf("(" + flag +")"));
			bw.write(String.valueOf(" "+ bn[i]+" "));
			bw.write(String.valueOf("+"));
			bw.write(String.valueOf(" "+dn[i]+" "));
			bw.write(String.valueOf("="));
			bw.write(String.valueOf(" "+an[i]));
			bw.newLine();
			flag++;
			}
			else if(cn[i]==1) {
			bw.write(String.valueOf("(" + flag +")"));
			bw.write(String.valueOf(" "+ bn[i]+" "));
			bw.write(String.valueOf("-"));
			bw.write(String.valueOf(" "+dn[i]+" "));
			bw.write(String.valueOf("="));
			bw.write(String.valueOf(" "+an[i]));
			bw.newLine();
			flag++;
			}
		}
		bw.close();
		fw.close();
		}
}
	/*	while((data=BR.readLine())!=null) {
		bw.write(String.valueOf(data));		
		bw.write(String.valueOf(' '));
		bw.write(String.valueOf(an[q]));
		bw.newLine();
		bw.flush();
		q++;		
		}
		
		BR.close();
		fr.close();
		//cd eclipse/作业/作业1/01work6360/src
	 for(q=0;q<num[0];q++)
		{
		bw.write(String.valueOf(an[q]));
		bw.newLine();}
		*/
		
		

	

