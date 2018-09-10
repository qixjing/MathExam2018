package t2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MathExam6354 {
	
	private static Scanner in;
	private static int x1,x2,n,fh;
	private static String[] ans;
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO 自动生成的方法存根
		in = new Scanner(System.in);
		n = in.nextInt();
		ans = new String[n];
		File file = new File("out6354.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		for (int i = 1; i <= n; i++) {
			x1 =  (int) (Math.random() * 100);
			x2 =  (int) (Math.random() * 100);
			fh =  (int) (Math.random() * 2);

			if (fh==0) {
				System.out.println("("+i+")"+x1+"+"+x2+"=");
				ans [i-1] = "("+i+")"+x1+"+"+x2+"="+(x1+x2);
			} else {
				System.out.println("("+i+")"+x1+"-"+x2+"=");
				ans [i-1] = "("+i+")"+x1+"-"+x2+"="+(x1-x2);
			}
		}
		System.out.println("--------答案--------");
		for (int i = 0; i < n; i++) {
			System.out.println(ans [i]);		
		}
	}

}
