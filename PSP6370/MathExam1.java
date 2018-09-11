import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class MathExam1{

	public static void main(String[] args) {
		Random ran = new Random();
		int a;
		Scanner reader = new Scanner(System.in);
		int n=reader.nextInt();
		String[] question = new String[n+1];
		String[] answer = new String[n+1];
		File file = new File ("out.txt");
		try {
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("out.txt")), true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		a=ran.nextInt(2);
		for(int k=1;k<=n;k++) {
			int i, j;
			i=ran.nextInt(100);
			j=ran.nextInt(100);	
			if(a==0) {
				int sum;
				sum=i+j;
				question[k]="("+k+") "+i+" + "+j;
				answer[k]="("+k+") "+i+" + "+j +" = "+ sum;
			}
			if(a==1) {
				int minus;
				minus=i-j;
				question[k]="("+k+") "+i+" - "+j;
				answer[k]="("+k+") "+i+" - "+j +" = "+ minus;
				
			}
		}
		for(int k=1;k<=n;k++) {
			System.out.println(question[k]);
			}
		System.out.println();
		for(int k=1;k<=n;k++) {
			System.out.println(answer[k]);
			}
	}
}
