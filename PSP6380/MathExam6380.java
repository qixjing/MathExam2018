


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MathExam6380 {
public static void main(String[] args) throws IOException {
	File file = new File("E:\\out.txt");
	int num[] = new int [args.length];
	
	for(;;) {Scanner input=new Scanner(System.in);
	int []k = new int [args.length];
k[1]=Integer.parseInt(args[1]);
k[0]=Integer.parseInt(args[0]);
	int l=k[1];
	int o=k[0];

if(o<=0||l<=0) {
args[1] = input.next();	
args[0] = input.next();	
	
continue;
	
	
}

FileOutputStream in =new FileOutputStream("out.txt");
	num [0] = Integer.parseInt(args[0]);
	String num1[] = new String [num[0]];
	String num2[] = new String [num[0]];
	String num3[] = new String [num[0]];

	for (int i = 0; i < num3.length; i++) {
		num3[i]="0";
	}
		
	for(int i = 0;i<k[0];i++) {
	int one = (int) (Math.random()*20);
	int two = 1+(int) (Math.random()*20);
	int three = (int) (Math.random()*2);

if(three==0) {
	System.out.println("("+(i+1)+")"+one+"-"+two+"=");
	num1[i]="("+(i+1)+")"+one+"-"+two+"=";
	num2[i]=" "+(one-two);
}
else if(three==1) {
	
	System.out.println("("+(i+1)+")"+one+"+"+two+"=");
	num1[i]="("+(i+1)+")"+one+"+"+two+"=";
	num2[i]=" "+(one+two);
}


byte[] s =num1[i].getBytes();
String d ="\r\n";
byte[] y = d.getBytes(); 
in.write(s);
in.write(y);




	}

String e ="-----------±ê×¼´ð°¸-----------";
byte[] m = e.getBytes(); 
String b="\r\n";
byte[] z = b.getBytes();
in.write(m);
in.write(z);

for(int i=0;i<k[0];i++) {
	String d ="\r\n";
	byte[] y = d.getBytes(); 
	byte[] s =num1[i].getBytes();
	byte[] p =num2[i].getBytes();

	in.write(s);
	in.write(p);
	
	in.write(y);



	}
break;
	}
	
}
}






