import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MathExam5240 {
	
	public static int addition(int i,OutputStream out) {
		int a =(int) (Math.random()*100);
		int b =(int) (Math.random()*(100-a+1));
		String word=("("+(i+1)+") "+a +" + "+ b +" = ")+"\n";
		try {
			out.write(word.getBytes());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return a+b;
	}
	public static int subtraction (int i,OutputStream out){
		int a =(int) (Math.random()*100);
		int b =(int) (Math.random()*(a+1));
		String word=("("+(i+1)+") "+a +" - "+ b +" = ")+"\n";
		try {
			out.write(word.getBytes());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return a-b;
	}
	public static void math(int n){
		int intArray[] = new int[n];
		String filename="out";
		  File file = new File(filename+".txt"); 
		  OutputStream out;
		try {
			out = new FileOutputStream(file);
			for(int i=0;i<n;i++)
		{
			if ((int) (Math.random()*2)==0) {//进行加法计算
				intArray[i]=addition(i,out);
		}else {//进行减法计算
			intArray[i]=subtraction(i,out);

		}
			
		}

			 String word = "---------------标准答案--------------- "+"\n";
			  out.write(word.getBytes());
			  //读取数据再输出一次
			  Scanner scanner0=new Scanner(file);
			  int i=0;
			  while(scanner0.hasNextLine()&&(i!=n)) {
				  word =(scanner0.nextLine())+intArray[i]+"\n";
				  out.write(word.getBytes());
				  i++;
			  }
			  Date date1=new Date();
			  String str="yyyy年MM月dd日 HH:mm";
			  SimpleDateFormat sdf1 = new SimpleDateFormat(str);
			  String time="211605240 谢孟轩"+sdf1.format(date1)+"\n";
			  out.write(time.getBytes());
			  out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
	public static int Input(String[] args) {
		String regex="\\d*";
		if(args.length!=1) {//解决输入参数为多个
			System.out.println("请输入单个参数。");
			Scanner input=new Scanner(System.in);
			args[0]=input.nextLine();
		}
		
		int n=nonnumeric(regex,args);
		while(n>30 || n<0) {
			System.out.println("请输入一个不大于30不小于0的数字");
			Scanner input=new Scanner(System.in);
			args[0]=input.nextLine();
			n=nonnumeric(regex,args);
		}
		return n;
		
	}
	public static int nonnumeric(String regex,String[] args) {
		
		while(!args[0].matches(regex)) {//解决如果输入不为数字
			System.out.println("请输入正确的数字。");
			Scanner input=new Scanner(System.in);
			args[0]=input.nextLine();
		
			}
			String s = String.valueOf(args[0]);
			int n = Integer.parseInt(s);
			return n;
			
	}
	public static void main(String[] args){
		// TODO 自动生成的方法存根
		System.out.println("---------------欢迎使用MathExam5240程序---------------");
		System.out.println("1.请按照格式：输入“题目数量（数字）”。 例：8，即程序自动生成八道算数题。");
		System.out.println("2.程序最多一次可生成30道算术题。学习是一个循序渐进的过程，不宜操之过急。");
		System.out.println("3.使用过程中若遇到无法解决的bug，可联系博客：乌鸦君一米八进行代码改进。");
		System.out.println("-----------------------------------------------------");
		int n=Input(args);
		try {
			math(n);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		

	}

}
