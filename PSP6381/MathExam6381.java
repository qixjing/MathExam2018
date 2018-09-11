import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MathExam6381 {
	private static int n,p;
	public static void main(String[] args) { 
		for(int i=0;i<args[0].length();i++) {
			if(args[0].charAt(i)>'9' || args[0].charAt(i)<'0') {
				System.out.println("输入有误，请重新输入");
				return;
			}
		}
		n=Integer.parseInt(args[0]);
//		System.out.println("请输入正整数表示题目数量：");
//	    Scanner sc=new Scanner(System.in);
//	    n=sc.nextInt();
//	    while(n<=0) {
//	    	System.out.println("输入数字错误，请重新输入题目数量：");
//		    Scanner s=new Scanner(System.in);
//		    n=s.nextInt();
//	    }
//创建两个StringBuffer对象，用来保存输出的题目和标准答案
StringBuffer timu= new StringBuffer();
StringBuffer daan = new StringBuffer();
//n = Integer.parseInt(args[0]);
for(int i = 1; i <= n; i++) {
 //获取两个随机数; 
 int num1=(int) (Math.random()*101);
 int num2=(int) (Math.random()*101);
 //得到运算符号;
 String ysf;
 p=(int) (Math.random()*101)%2;
 if(p==0) {
	 ysf="+";
 }
 else {
	 ysf="-";
 }
 //得到结果
 int m;
 if(ysf.equals("+")) {
	 m=num1+num2;
 }
 //为避免出现负数，在进行减运算时，保证第一个数大于第二个数。
 else {
	  if(num1 < num2) {
  int t;
  t= num1;
  num1 = num2;
  num2 = t;
 }
	  m=num1-num2;
 }
 //记录题目和答案
 timu.append("(" + i + ") " + num1 +" "+ ysf +" "+ num2 +" ="+ System.lineSeparator());
 daan.append("(" + i + ") " + num1 + " "+ysf +" "+ num2 + " = " + m + System.lineSeparator());
}
//把题目和答案写入文件
try {
 write("out6381.txt",timu,daan);
 System.out.println("题目已生成");
} catch (IOException e) {
 e.printStackTrace();
}
}

private static void write(String filename,StringBuffer timu,StringBuffer daan) throws IOException {
   // 步骤1：确定输出的文件（目的地）
// 如果filename中包含路径，必须确保路径已存在
  File file = new File(filename);
  File parentFile = file.getParentFile();
  if(parentFile!=null&&!parentFile.exists()) {
   parentFile.mkdirs();
   System.out.println("创建目录：" + parentFile);
  }
  file.createNewFile();
// 步骤2：创建指向文件的输出流
  OutputStream out = new FileOutputStream(file);
// 步骤3：写入数据
  out.write(timu.toString().getBytes());
  out.write(System.lineSeparator().getBytes());
  String str="--------------------标准答案--------------------";
  byte[] d=str.getBytes();
  out.write(d);
  out.write(System.lineSeparator().getBytes());
  out.write(System.lineSeparator().getBytes());
  out.write(daan.toString().getBytes());
  out.write(System.lineSeparator().getBytes());
  String s="          211606381 姓名：吴伟华   "+LocalDateTime.now();
  out.write(s. getBytes());
   // 步骤4：关闭
  out.close();
 }
}

