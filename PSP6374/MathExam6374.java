
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class MathExam6374 {

	public static void main(String[] args) throws IOException {
		int i,a,b,fuhao;
		Scanner input=new Scanner(System.in);
		int flag=0;
		int []c =new int [args.length] ;    // 创建一个数组存入参数
	    c[0] = Integer.parseInt(args[0]);
	    c[1] = Integer.parseInt(args[1]);
		String[] timu=new String[c[0]+1];	// 创建数组存入题目
		String[] daan=new String[c[0]+1];
		String huanhang="\r\n";    // windows的换行，在cmd运行方便观看
		File file = new File("out.txt");
        FileOutputStream u = new FileOutputStream("out.txt");
		if(!file.exists()) {
			file.createNewFile();
		}    // 创建out.txt文本
		for(;;) {
			if(c[0]>400&&c[1]==1) {
			System.out.println("请输入1-400之间的题目数，否则题目重复，请重新输入");
			 c[0]=input.nextInt();
			 c[1]=input.nextInt();
			continue;
			}
			if(c[0]<1) {
			System.out.println("输入的题目数请大于1,请重新输入");
			 c[0]=input.nextInt();
			 c[1]=input.nextInt();
			continue;
			}
			if(c[0]>81&&c[1]==2) {
				System.out.println("请输入1-81之间的题目数，否则题目重复，请重新输入");
				 c[0]=input.nextInt();
				 c[1]=input.nextInt();
				continue;
			}
			if(c[1]>2) {
				System.out.println("本程序仅支持1年级和2年级，请重新输入");
				c[0]=input.nextInt();
				 c[1]=input.nextInt();
				 continue;
			}
			else {
			flag=1;
			if(flag==1)
				break;
		}
		}
		if(c[1]==1) {
		for(i=1;i<=c[0];i++) {
			fuhao=(int)(Math.random()*2);
			if(fuhao==0) {
			 a=(int)(Math.random()*21);   
	         b=(int)(Math.random()*21);
	         int answer=a+b;
	         System.out.println("("+i+")"+a+"+"+b+"=");
	         timu[i-1]="("+i+")"+a+"+"+b+"=";
	         daan[i-1]="("+i+")"+a+"+"+b+"="+answer;
	         byte[] ti =timu[i-1].getBytes();	// 将字符串转换为字节流为了写入txt文件
	         byte[] da =daan[i-1].getBytes();
	         byte[] h=huanhang.getBytes();
	         u.write(ti);	// 将转换好的字节流写入txt
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
		String xieru="题目与答案已经写入out.txt";
		byte[] xr=xieru.getBytes();
        byte[] fg=fengexian.getBytes();
		 byte[] h=huanhang.getBytes();
        u.write(fg);u.write(h);
		for(i=1;i<=c[0];i++) {
			System.out.println( daan[i-1]);
	         byte[] da =daan[i-1].getBytes();
	         u.write(da);
	         u.write(h);
		}
			 u.write(xr);
			 System.out.println("题目与答案写入out.txt");
		}	
		else if(c[1]==2) {
			for(i=1;i<=c[0];i++) {
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
		String xieru="题目与答案已经写入out.txt";
		byte[] xr=xieru.getBytes();
        byte[] fg=fengexian.getBytes();
		 byte[] h=huanhang.getBytes();
        u.write(fg);u.write(h);
		for(i=1;i<=c[0];i++) {
			System.out.println( daan[i-1]);
	         byte[] da =daan[i-1].getBytes();
	         u.write(da);
	         u.write(h);
		}
		u.write(xr);
		System.out.println("题目与答案已经写入out.txt");
		}	
		}		
}