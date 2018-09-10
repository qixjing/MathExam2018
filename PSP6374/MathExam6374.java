



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class MathExam6374 {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入出题的数目和年级");
		Scanner sc=new Scanner(System.in);
		int i,a,b,fuhao;
		int n=sc.nextInt();
		int grade=sc.nextInt();
		String[] timu=new String[n+1];
		String[] daan=new String[n+1];
		String huanhang="\r\n";
		File file = new File("out.txt");
        FileOutputStream u = new FileOutputStream("out.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		if(grade==1) {
		for(i=1;i<=n;i++) {
			fuhao=(int)(Math.random()*2);
			if(fuhao==0) {
			 a=(int)(Math.random()*21);   
	         b=(int)(Math.random()*21);
	         int answer=a+b;
	         System.out.println("("+i+")"+a+"+"+b+"=");
	         timu[i-1]="("+i+")"+a+"+"+b+"=";
	         daan[i-1]="("+i+")"+a+"+"+b+"="+answer;
	         byte[] ti =timu[i-1].getBytes();
	         byte[] da =daan[i-1].getBytes();
	         byte[] h=huanhang.getBytes();
	         u.write(ti);
	         u.write(h);
		 				}
	        else {
	         a=(int)(Math.random()*21);   
	         b=(int)(Math.random()*(a));
	         int answer=a-b;
	         System.out.println("("+i+")"+a+"-"+b+"=");
	         timu[i-1]="("+i+")"+a+"-"+b+"=";
	         daan[i-1]="("+i+")"+a+"-"+b+"="+answer;
	         byte[] ti =timu[i-1].getBytes();
	         byte[] da =daan[i-1].getBytes();
	         byte[] h=huanhang.getBytes();
	         u.write(ti);
	         u.write(h);
	         }	
		}
		System.out.println("------答案分割线------");
		String fengexian="------答案分割线------";
        byte[] fg=fengexian.getBytes();
		 byte[] h=huanhang.getBytes();
        u.write(fg);u.write(h);
		for(i=1;i<=n;i++) {
			System.out.println( daan[i-1]);
	         byte[] da =daan[i-1].getBytes();
	         u.write(da);
	         u.write(h);
		}
		}	
		else if(grade==2) {
			for(i=1;i<=n;i++) {
			fuhao=(int)(Math.random()*2);
			if(fuhao==0) {
			 a=(int)(Math.random()*10);   
	         b=(int)(Math.random()*10);
	         int answer=a*b;
	         System.out.println("("+i+")"+a+"×"+b+"=");
	         timu[i-1]="("+i+")"+a+"×"+b+"=";
	         daan[i-1]="("+i+")"+a+"×"+b+"="+answer;
	         byte[] ti =timu[i-1].getBytes();
	         byte[] da =daan[i-1].getBytes();
	         byte[] h=huanhang.getBytes();
	         u.write(ti);
	         u.write(h);
		 				}
	        else {
	         a=(int)(Math.random()*10);   
	         b=(int)(Math.random()*(a)+1);
	         int answer=a/b;
	         int yushu=a%b;
	         System.out.println("("+i+")"+a+"÷"+b+"=");
	         timu[i-1]="("+i+")"+a+"÷"+b+"=";
	         if(a%b==0) {
	         daan[i-1]="("+i+")"+a+"÷"+b+"="+answer;
	         }
	         else if(a%b!=0) {
	         daan[i-1]="("+i+")"+a+"÷"+b+"="+answer+"....."+yushu;
	         }
	         byte[] ti =timu[i-1].getBytes();
	         byte[] da =daan[i-1].getBytes();
	         byte[] h=huanhang.getBytes();
	         u.write(ti);
	         u.write(h);
	         }	
		}
		System.out.println("------答案分割线------");
		String fengexian="------答案分割线------";
        byte[] fg=fengexian.getBytes();
		 byte[] h=huanhang.getBytes();
        u.write(fg);u.write(h);
		for(i=1;i<=n;i++) {
			System.out.println( daan[i-1]);
	         byte[] da =daan[i-1].getBytes();
	         u.write(da);
	         u.write(h);
		}
		}	
		}		
}