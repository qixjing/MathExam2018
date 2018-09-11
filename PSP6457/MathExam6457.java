
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

class MathExam6457{
	public static void main(String args[]) throws IOException{
		int n = 0; int grade = 0;
		MathExam6457 math = new MathExam6457();
		System.out.print("请输入1或2（1表示一年级、2表示二年级）：");
		Scanner input1 = new Scanner(System.in);
		grade = input1.nextInt(); 
	/*  
	    String str1 = args[0];
		if(str1 != null) {
		    grade = Integer.parseInt(str1);
		    System.out.println("java MathExam " + n + grade);
		}else
			System.out.println("您输入的是空值，请重新输入！"); 
	 */
		System.out.print("请输入出题数：");
		Scanner input2 = new Scanner(System.in);
		n = input2.nextInt();
		System.out.println("java MathExam " + n + " " + grade);
	//  String str2 = args[1];
		
	
		if (grade == 1) {
			math.Random1(n);
		}else
			math.Random2(n);
		System.out.println("-----------------标准答案-----------------");
	}
	
   // public static boolean isInteger(String str) {    
   //	    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
   //	    return pattern.matcher(str).matches();    
   // }  
	    
	public void Random1(int n) throws IOException {
		
		File file = new File("out.txt");
	    DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
	    
	    
	    int a = 0; int b = 0; int sum = 0; char c;	 
		for(int i = 1;i <= n;i ++) {
		    a = (int) (Math.random() * 100);
		    b = (int) (Math.random() * 100);
		    char[] ch = {'+','-'};
		    Random r = new Random();
		    int index = r.nextInt(ch.length);
		    c = ch[index];
		    if (c == '-') {
		    	if(a<b) {
			    	int t = 0;
			    	a = t;
			    	a = b;
			    	t = b;
		        }
		        sum = a - b;
		    }else
		    	sum = a + b;
		    System.out.println("("+ i +") " + a + " " + ch[index] + " " + b + " = " + sum);
		    out.writeChars("("+ i +") " + a + " " + ch[index] + " " + b + " = " + sum+"\n");
			}
		
		out.close();
	}
	    
	
	public void Random2(int n) throws IOException{

		File file = new File("out.txt");
	    DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		
	    int a = 0; int b = 0; int yu = 0; int sum = 0; char c;	 
		for(int i = 1;i <= n;i ++) {
		    a = (int) (Math.random() * 100);
		    b = (int) (Math.random() * 100);
		    char[] ch = {'*','/'};
		    Random r = new Random();
		    int index = r.nextInt(ch.length);
		    c = ch[index];
		    if (c == '/') {
		    	if(a < b) {
			    	int t = 0;
			    	a = t;
			    	a = b;
			    	t = b;
		    }
		    sum = a / b;
		    
		    if(a % b != 0) {
		    	yu = a % b;
		    	System.out.println("(" + i +") " + a + " " + ch[index] + " " + b + " = " + sum + "..." + yu);
		    	out.writeChars("(" + i +") " + a + " " + ch[index] + " " + b + " = " + sum + "..." + yu+"\n");
		    }else {
		    	System.out.println("(" + i +") " + a + " " + ch[index] + " " + b + " = " + sum);
		    	out.writeChars("(" + i +") " + a + " " + ch[index] + " " + b + " = " + sum+"\n");
		    	}
		    }else {
		        sum = a * b;
		    }
		        System.out.println("(" + i +") " + a + " " + ch[index] + " " + b + " = " + sum);
		        out.writeChars("(" + i +") " + a + " " + ch[index] + " " + b + " = " + sum+"\n");
		    }
		out.close();
	}
     
   //     public static int byteArrayToInt(byte[] b) {
   //    	    return b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16 | (b[0] & 0xFF) << 24;//字节数组转换为int
   //    }
     
    //    public static byte[] intToByteArray457(int a) {
    //   	    return new byte[] { (byte) ((a >> 24) & 0xFF), (byte) ((a >> 16) & 0xFF), (byte) ((a >> 8) & 0xFF), (byte) (a & 0xFF) };//int转换成字节数组
    //   }
     
}
