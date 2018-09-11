package chenbin211614354;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

public class Grade1 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Random random = new Random();
		int i = 0;
		boolean g ;
		int j=0;
		for (i = 0; i < 10; i++) {
			g = random.nextBoolean();
			if (g == true) {
				j++;
				x(list,j);               //调用减法运算方法
			} else if (g == false) {
				j++;
				y(list,j);               //调用加法运算方法
			}

		}
	
		h(list);
		
	}

	public static void x(ArrayList<String> list,int j) {
		// 減法运算方法
		Random r = new Random();
		int answer = 0;
		int a = 0;
		int b = 0;

		do {
			a = r.nextInt(100);
			// a为第一个随机数
			b = r.nextInt(100);
			// b为第二个随机数
			answer = a - b;
		} while (answer < 0);
		String answer1 = String.valueOf(answer);
		String a1 = String.valueOf(a);
		String b1 = String.valueOf(b);
		
		list.add("(" + ( j) + ") " + a1 + " - " + b1 + " = ");
	
		list.add(answer1);

	}

	public static void y(ArrayList<String> list,int j) {
		// 加法运算方法
		Random r = new Random();
		int answer = 0;
		int a = 0;
		int b = 0;

		do {
			a = r.nextInt(100);
			// a为第一个随机数
			b = r.nextInt(100);
			// b为第二个随机数
			answer = a + b;
		} while (answer >= 100);
		String answer1 = String.valueOf(answer);
		String a1 = String.valueOf(a);
		String b1 = String.valueOf(b);
		
		list.add("(" + (j ) + ") " + a1 + " + " + b1 + " = ");
		
		list.add(answer1);

	}

	public static void h(ArrayList<String> list) { // 新建一个方法用来专门输出
		int i=0;
		File toFile=new File("out.txt");
		PrintStream ps= null;
		OutputStream os=null;
		try {
			// ps=new PrintStream(toFile);//可直接传File
			os=new FileOutputStream(toFile,true);//true在原文件上追加
			ps=new PrintStream(os,true);//true自动刷新
			ps.println(list.get(i));
			ps.println(list.get(i+1));
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			ps.close();
		}
		for ( i = 0; i <=2 * 10 - 2; i = i + 2) {
			System.out.println(list.get(i));
		}
		System.out.print("\n");
		for ( i = 0; i <= 2 * 10 - 2; i = i + 2) {
			System.out.print(list.get(i));
			System.out.println(list.get(i + 1));
		}

	}
}
		
		
		
			
	

