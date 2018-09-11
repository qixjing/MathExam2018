import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MathExam5240 {
	public static int multiplication(int i,OutputStream out) {
		int a =(int) (Math.random()*10);
		int b =(int) (Math.random()*10);
		String word=("("+(i+1)+") "+a +" * "+ b +" = ")+"\n";
		try {
			out.write(word.getBytes());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return a*b;
		
	}

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
	public static void math(int n,int grade){
		int j;
		if(grade==1) {
			j=2;
		}else {
			j=4;
		}
		int intArray[] = new int[n];
		int intArray1[] = new int[n];
		String filename="out";
		  File file = new File(filename+".txt"); 
		  OutputStream out;
		try {
			out = new FileOutputStream(file);
			
			for(int i=0;i<n;i++)
		{	int k=(int) (Math.random()*j);
			if (k==0) {//进行加法计算
				intArray[i]=addition(i,out);
				intArray1[i]=0;
		}else if(k==1){//进行减法计算
			intArray[i]=subtraction(i,out);
			intArray1[i]=0;
		}else if(k==2) {
			intArray[i]=multiplication(i,out);
			intArray1[i]=0;
		}else{
			int a =(int) (Math.random()*100);
			int b =(int) (1+Math.random()*9);
			String word=("("+(i+1)+") "+a +" / "+ b +" = ")+"\n";
			try {
				out.write(word.getBytes());
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			intArray[i]=a/b;
			intArray1[i]=a%b;
		}
			
		}

			 String word = "---------------标准答案--------------- "+"\n";
			  out.write(word.getBytes());
			  //读取数据再输出一次
			  Scanner scanner0=new Scanner(file);
			  int i=0;
			  while(scanner0.hasNextLine()&&(i!=n)) {
				  if(intArray1[i]==0) {
				  word =(scanner0.nextLine())+intArray[i]+"\n";
				  }
				  else {
				  word =(scanner0.nextLine())+intArray[i]+"..."+intArray1[i]+"\n"; 
				  }
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
	public static boolean Input(String[] args) {
		String regex="\\d*";
		if(args.length!=2) {//解决输入参数为多个
			System.out.println("输入的参数应为两个参数");
		}
		else if((!args[0].matches(regex))||(!args[1].matches(regex))) {//解决如果输入不为数字
			System.out.println("输入的参数应为数字且不为-1");
			}
		else{String s = String.valueOf(args[0]);
		String s1=String.valueOf(args[1]);
		int n = Integer.parseInt(s);
		int grade =Integer.parseInt(s1);
		if(n<30 && (grade==1||grade==2)) {
			return true;
		}else {
			System.out.println("输入的题数应小于30题且只能选择一年级或者二年级");
		}
		}
		return false;
	}
	public static void main(String[] args){
		// TODO 自动生成的方法存根
		System.out.println("---------------欢迎使用MathExam5240程序---------------");
		System.out.println("1.请按照格式：输入“题目数量（数字）+空格+年级（数字）”。 例：8 2，即程序自动生成二年级八道算数题。");
		System.out.println("2.程序最多一次可生成30道算术题。学习是一个循序渐进的过程，不宜操之过急。");
		System.out.println("3.使用过程中若遇到无法解决的bug，可联系博客：乌鸦君一米八进行代码改进。");
		System.out.println("-----------------------------------------------------");
		if(Input(args)) {
			String s = String.valueOf(args[0]);
			String s1=String.valueOf(args[1]);
			int n = Integer.parseInt(s);
			int grade =Integer.parseInt(s1);
		try {
			math(n,grade);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		}
	}

}
