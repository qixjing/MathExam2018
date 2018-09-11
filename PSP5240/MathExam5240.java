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
	public static void main(String[] args){
		// TODO 自动生成的方法存根
		String s = String.valueOf(args[0]);
		int n = Integer.parseInt(s);
		try {
			math(n);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		

	}

}
