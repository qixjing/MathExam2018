import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class MathExam6382 {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int result = 0; 
		int n=input.nextInt();
		int grade=input.nextInt();
		String[] str1=new String[n];
		String[] str2=new String[n];
		String fengge="\n";
		File file = new File("out.txt");
		FileOutputStream shuchu = new FileOutputStream("out.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		if(n<=0) {System.out.println("请输入大于零的数");}
			if(grade==1) {
			for(int i=0;i<n;i++) {
				int operator = (int)(Math.random()*2);
				if(operator==0){
					int num1 = (int)(Math.random()*21);
					int num2 = (int)(Math.random()*21);
					result = num1 + num2;
					System.out.println("("+(i+1)+") " + num1 + " + " + num2);
					str1[i]="("+(i+1)+") " + num1 + " + " + num2;
					str2[i]="("+(i+1)+") " + num1 + " + " + num2 + " = " + result;
					byte[] x1 =str1[i].getBytes();
					byte[] x2 =str2[i].getBytes();
					byte[] x3 =fengge.getBytes();
					shuchu.write(x1);
					shuchu.write(x3);
				}
				else if(operator==1){
					int x = (int)(Math.random()*21);
					int y = (int)(Math.random()*x);
					result = x - y;
					System.out.println("("+(i+1)+") " + x + " - " + y);
					str1[i]="("+(i+1)+") " + x + " - " + y;
					str2[i]="("+(i+1)+") " + x + " - " + y + " = " + result;
					byte[] x1 =str1[i].getBytes();
					byte[] x2 =str2[i].getBytes();
					byte[] x3 =fengge.getBytes();
					shuchu.write(x1);
					shuchu.write(x3);
				}	
			}
			}
			else if(grade==2) {
				for(int i=0;i<n;i++) {
					int operator = (int)(Math.random()*2);
					if(operator==0){
						int num1 = (int)(Math.random()*21);
						int num2 = (int)(Math.random()*21);
						result = num1 * num2;
						System.out.println("("+(i+1)+") " + num1 + " * " + num2);
						str1[i]="("+(i+1)+") " + num1 + " * " + num2;
						str2[i]="("+(i+1)+") " + num1 + " * " + num2 + " = " + result;
						byte[] x1 =str1[i].getBytes();
						byte[] x2 =str2[i].getBytes();
						byte[] x3 =fengge.getBytes();
						shuchu.write(x1);
						shuchu.write(x3);
					}
					else if(operator==1){
						int x = (int)(Math.random()*21);
						int y = (int)(Math.random()*21);
						if(x%y==0 && y!=0 && x>y) {
							result = x / y;
							System.out.println("("+(i+1)+") " + x + " / " + y);
							str1[i]="("+(i+1)+") " + x + " / " + y;
							str2[i]="("+(i+1)+") " + x + " / " + y + " = " + result;
							byte[] x1 =str1[i].getBytes();
							byte[] x2 =str2[i].getBytes();
							byte[] x3 =fengge.getBytes();
							shuchu.write(x1);
							shuchu.write(x3);	
						}
						if(x%y!=0 && y!=0 ) {
							 result = x / y;
							 System.out.println("("+(i+1)+") " + x + " / " + y);
							 	str1[i]="("+(i+1)+") " + x + " / " + y;
							 	str2[i]="("+(i+1)+") " + x + " / " + y + " = " + result + "..." + (x%y);
								byte[] x1 =str1[i].getBytes();
								byte[] x2 =str2[i].getBytes();
								byte[] x3 =fengge.getBytes();
								shuchu.write(x1);
								shuchu.write(x3);	 
						}
				
						}
					}
				}
		
			System.out.println();
			byte[] x3=fengge.getBytes();
			shuchu.write(x3);
			for(int i=0;i<n;i++) {
				System.out.println(str2[i]);
				byte[] x2 =str2[i].getBytes();
				shuchu.write(x2);
				shuchu.write(x3);
				}
				shuchu.close();
		}
}
	
	


