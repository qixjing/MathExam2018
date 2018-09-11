



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MathExam6318 {

	public static void main(String[] args) throws Throwable {
		
		File file =new File("out.txt");
		if(!file.exists()){						//创建文件
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("文件创建失败！");
				e.printStackTrace();
			}
		}
		Scanner sc=new Scanner(System.in);
		for(;;)								 {
        int flag=4;
		int []n =new int [args.length] ;
		n[0]=Integer.parseInt(args[0]);
		n[1]=Integer.parseInt(args[1]);
	    	if(args[0].length()>5 && Integer.parseInt(args[0])>100) {
	    		System.out.print(" 输入的题目数太大");					//限制题数过大
				flag=0; }												  
			if(Integer.parseInt(args[1])>2){
				System.out.print(" 输入的年级数太大");					//限制年级数过大													 
				flag=1; }									  
	    	if(n[0]<=0 && !args[0].matches("\\d*")) {
	    		System.out.print(" 输入的题目数不对，应为正整数");			//限制题数为正整数
	    		flag=2;
	    				}
	    	if(n[1]<=0 && !args[1].matches("\\d*")) {
	    		System.out.print(" 输入的年级数不对，应为正整数");			//限制年级数为正整数
	    		flag=3;
	    				}
	    	if(flag!=4) {System.out.println("\n"+"请输入题目数与年级");	args[0]=sc.next();args[1]=sc.next();continue;}//如果输入的两个参数不对 则继续输入 直至正确为止
		int i=1;
		
		//System.out.println("请依次输入要生成的题数与年级");
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
		int b=(int)(Math.random()*100+1);
		int c=(int)(Math.random()*2);
		while(a+b>=100 && c%2==0) {						//限定加法运算和不会超过100
			 a=(int)(Math.random()*100+1);
			 b=(int)(Math.random()*100+1);
		}
		if(c%2==0) {
			System.out.println("("+(i+1)+")"+a+"+"+b+"=");			//加法运算
			qs = new StringBuffer("("+(i+1)+")"+a+"+"+b+"=");	
			rs = new StringBuffer(" "+(a+b));
			as[i]=("("+(i+1)+")"+a+"+"+b+"=");
			qs.append(rs);
			cs[i]=qs.toString();
			}
			else {
				while(a-b<0 && c%2!=0) {						//限定减法运算差不会小于0
					 a=(int)(Math.random()*100+1);
					 b=(int)(Math.random()*a+1);
				}	
			System.out.println("("+(i+1)+")"+a+"-"+b+"=");			//减法运算
			qs = new StringBuffer("("+(i+1)+")"+a+"-"+b+"=");
			rs = new StringBuffer(" "+(a-b));
			as[i]=("("+(i+1)+")"+a+"-"+b+"=");
			qs.append(rs);
			cs[i]=qs.toString();
			}
			byte[] ba = as[i].getBytes();
			String ka ="\r\n";
			byte[] ra = ka.getBytes(); 
			in.write(ba);
			in.write(ra);	
		}
		
		String daan ="-------------标准答案--------------";
		byte[] pa = daan.getBytes();									//写入“标准答案”
		String ka ="\r\n";
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
			int b=(int)(Math.random()*10+1);						//保证除数不为0
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
				String ka ="\r\n";
				byte[] ra = ka.getBytes(); 
				in.write(ba);
				in.write(ra);	
			}
			String daan ="-------------标准答案--------------";
			byte[] pa = daan.getBytes();							//写入“标准答案”
			String ka ="\r\n";
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
		System.out.println("请选择继续还是退出，退出的话输入0，继续的话输入1");
			int gg=sc.nextInt(); 
			while(gg!=0&&gg!=1){
				System.out.println("您输入的数字有误，无法匹配相应功能，请选择继续还是退出，退出的话输入0，继续的话输入1");      //若选择输入的数字不是0或1则一直循环至正确为止
				gg=sc.nextInt(); 
			}	 
			if(gg==0) {System.out.println("谢谢使用");break;}														//循环生成题目+答案（可自选题目数与年级）
			else if(gg==1){
				System.out.println("请输入题目数与年级");	//新的题目数与年级
				int []p =new int [args.length] ;
				args[0]=sc.next();args[1]=sc.next();	
				flag=4;
				for(;;) {		
					if(args[0].length()>5 &&Integer.parseInt(args[0])>10000) {
		    		System.out.print("输入的题目数太大");					//限制题数过大
					flag=0;}
				if(p[1]>2){
					System.out.print("输入的年级数太大");					//限制年级数过大													 
					flag=1;}									  
		    	if(Integer.parseInt(args[0])<=0 && !args[0].matches("\\d*")) {
		    		System.out.print("输入的题目数不对，应为正整数");			//限制题数为正整数
		    		flag=2;}
		    	if(Integer.parseInt(args[1])<=0 && !args[1].matches("\\d*")) {
		    		System.out.print("输入的年级数不对，应为正整数");			//限制年级数为正整数
		    		flag=3;}
		    	if(flag!=4) {
		    		System.out.println("\n"+"请输入题目数与年级");	args[0]=sc.next();args[1]=sc.next();break;}	//如果输入的两个参数不对 则继续输入 直至正确为止	
		    		}continue;
			
							}
											}
														}					
				}
		
		
		
		

