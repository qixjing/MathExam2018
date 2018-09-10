package xys;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class MathExam6368 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i;
		int x[] = new int[n+1];
		int y[] = new int[n+1];
		int z[] = new int[n+1];
		int d = sc.nextInt();
		int e = 0;
		char[] c = new char[n+1];
		for(i = 1;i <= n;i++){
			e = (int) (0 + Math.random() * (2));
			if(d == 1){
				int a = (int) (0 + Math.random() * (101));
				int b = (int) (0 + Math.random() * (101));
				x[i] = a;
				y[i] = b;
				if(e == 0){
					c[i] = '+';
					z[i] = x[i] + y[i];
				}
				else{
					c[i] = '-';
					z[i] = x[i] - y[i];
				}
			}
			else if(d == 2){
				int a = (int) (0 + Math.random() * (10));
				int b = (int) (0 + Math.random() * (10));
				x[i] = a;
				y[i] = b;
				if(e == 0){
					c[i] = '*';
					z[i] = x[i] * y[i];
				}
				else{
					c[i] = '/';
					z[i] = x[i] / y[i];
				}
			}
			System.out.println("(" + i + ") " + x[i] + c[i] + y[i] + "=");
			String word = "(" + i + ") " + x[i] + c[i] + y[i] + "=";
			String path = "D:\\java\\out.txt";
	        BufferedWriter out = new BufferedWriter(
	                new OutputStreamWriter(new FileOutputStream(path,true)));
	        out.write(word+"\r\n");
	        out.close();
		}
		for(i = 1;i <= n;i++){
			System.out.println("(" + i + ") " + x[i] + c[i] + y[i] + "=" + z[i]);
			String word = "(" + i + ") " + x[i] + c[i] + y[i] + "=" + z[i];
			String path = "D:\\java\\out.txt";
	        BufferedWriter out = new BufferedWriter(
	                new OutputStreamWriter(new FileOutputStream(path,true)));
	        out.write(word+"\r\n");
	        out.close();
		}

	}

}
