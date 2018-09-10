

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MathExam6318 {

	public static void main(String[] args) throws Throwable {
		
		File file =new File("out.txt");
		if(!file.exists()){						//创建文件
			file.createNewFile();
           System.out.println("文件创建完成");
        }
		
		
		
		int []n =new int [args.length] ;
	    n[0] = Integer.parseInt(args[0]);
	    n[1] = Integer.parseInt(args[1]);

		int i=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("请依次输入要生成的题数与年级");
		String [] as=new String[n[0]+1];
		String [] bs=new String[n[0]+1];	
		String [] cs=new String[n[0]+1];	
		StringBuffer qs = null;
		StringBuffer rs = null;
		FileOutputStream in=new FileOutputStream(file);
		if(n[1]==1) {
		for(i=0;i<n[0];i++)
		{													
		int a=(int)(Math.random()*100+1);
		int b=(int)(Math.random()*a+1);
		int c=(int)(Math.random()*2);
		if(c%2==0) {
			System.out.println("("+(i+1)+")"+a+"+"+b+"=");			//加法运算
			qs = new StringBuffer("("+(i+1)+")"+a+"+"+b+"=");	
			rs = new StringBuffer(" "+(a+b));
			as[i]=("("+(i+1)+")"+a+"+"+b+"=");
			qs.append(rs);
			cs[i]=qs.toString();
			}
			else {
			System.out.println("("+(i+1)+")"+a+"-"+b+"=");			//减法运算
			qs = new StringBuffer("("+(i+1)+")"+a+"-"+b+"=");
			rs = new StringBuffer(" "+(a-b));
			as[i]=("("+(i+1)+")"+a+"-"+b+"=");
			qs.append(rs);
			cs[i]=qs.toString();
			}
			byte[] ba = as[i].getBytes();
			String ka ="\n\r";
			byte[] ra = ka.getBytes(); 
			in.write(ba);
			in.write(ra);	
		}
		
		String daan ="-------------标准答案--------------";
		byte[] pa = daan.getBytes();									//写入“标准答案”
		String ka ="\n\r";
		byte[] ra = ka.getBytes(); 
		in.write(pa);	
		in.write(ra);
		System.out.println("-------------标准答案--------------");
		for(i=0;i<n[0];i++)
		{																//输出答案并写入文本
			System.out.println(cs[i]);
			byte[] ta = cs[i].getBytes();
			in.write(ta);
			in.write(ra);
			
		}
				
				}
		else {
			for(i=0;i<n[0];i++)								
			{
			int a=(int)(Math.random()*10+1);						
			int b=(int)(Math.random()*10+1);
			int c=(int)(Math.random()*2);
			if(c%2==0) {
				System.out.println("("+(i+1)+")"+a+"x"+b+"=");				//乘法运算
				qs = new StringBuffer("("+(i+1)+")"+a+"x"+b+"=");
				rs = new StringBuffer(" "+(a*b));
				as[i]=("("+(i+1)+")"+a+"x"+b+"=");
				qs.append(rs);
				cs[i]=qs.toString();
				}
			else {
				if(a%b==0) {
				System.out.println("("+(i+1)+")"+a+"÷"+b+"=");				//除法运算（无余数）
				qs = new StringBuffer("("+(i+1)+")"+a+"÷"+b+"=");			
				rs = new StringBuffer(" "+(a/b));
				as[i]=("("+(i+1)+")"+a+"÷"+b+"=");
				qs.append(rs);
				cs[i]=qs.toString();
				
				}
				else {
				System.out.println("("+(i+1)+")"+a+"÷"+b+"=");			//除法运算（有余数）
				qs = new StringBuffer("("+(i+1)+")"+a+"÷"+b+"=");
				rs = new StringBuffer(" "+(a/b)+"..."+a%b);
				as[i]=("("+(i+1)+")"+a+"÷"+b+"=");
				qs.append(rs);
				cs[i]=qs.toString();
					}
				
				
				}
				
				byte[] ba = as[i].getBytes();							//写入题目（乘与除）
				String ka ="\n\r";
				byte[] ra = ka.getBytes(); 
				in.write(ba);
				in.write(ra);	
			}
			String daan ="-------------标准答案--------------";
			byte[] pa = daan.getBytes();							//写入“标准答案”
			String ka ="\n\r";
			byte[] ra = ka.getBytes(); 
			in.write(pa);
			in.write(ra);
		
		System.out.println("-------------标准答案--------------");
		for(i=0;i<n[0];i++)
		{															//输出答案并写入题目+答案
			System.out.println(cs[i]);
			byte[] ta = cs[i].getBytes();
			in.write(ta);
			in.write(ra);
			
		}
			}
		
															}
}
		
		
		
		

