import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class MathExam2{

	public static void main(String[] args) {
		Random ran = new Random();
		int a;
		int n=Integer.parseInt(args[0]);
		String[] question = new String[n+1];
		String[] answer = new String[n+1];
		File file = new File ("out.txt");
		try {
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("out.txt")), true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int k=1;k<=n;k++) {
			int i, j;
			a=ran.nextInt(4);
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
				if(minus<0) {
					k--;
					continue;
				}
				question[k]="("+k+") "+i+" - "+j;
				answer[k]="("+k+") "+i+" - "+j +" = "+ minus;

			}
			if(a==2) {
				int multiplication;
				i=ran.nextInt(10);
				j=ran.nextInt(10);
				multiplication=i*j;
				question[k]="("+k+") "+i+" * "+j;
				answer[k]="("+k+") "+i+" * "+j +" = "+ multiplication;
			}
			if(a==3) {
				int division;
				i=ran.nextInt(10);
				j=ran.nextInt(10);
				if(j==0) {
					k--;
					continue;
				}
				division=i/j;
				if(i%j==0) {
					question[k]="("+k+") "+i+" / "+j;
					answer[k]="("+k+") "+i+" / "+j +" = "+ division;
				}
				else {
					question[k]="("+k+") "+i+" / "+j;
					answer[k]="("+k+") "+i+" / "+j +" = "+ division +"..."+(i%j);
				}
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