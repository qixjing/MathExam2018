package dwowjd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class MathExam6349 {

	public static void main(String[] args)throws IOException {
		int n = Integer.parseInt(args[0]);
		int grade = Integer.parseInt(args[1]);
		
		File file;//创建文件夹
	    FileOutputStream stream = null;//new文件流
	    try {
	    file = new File("out.txt");
	    stream = new FileOutputStream (file);//将文件夹放在文件流中
	    if (!file.exists()) {
	     file.createNewFile();
	      }
	    //byte contentInBytes[] = resultChar.getBytes();//转化成字节形
	    InputStream in = new FileInputStream(file);//创建指向文件的输入流
	    OutputStream out = new FileOutputStream(file);//创建指向文件的输出流
	    //stream.write(contentInBytes);//写入
	    stream.flush(); //写完之后刷新
	    stream.close();//关闭流
	    Math(n,grade);
	    }
	}
	
	public static void Math(int n,int grade) throws IOException{
		File file = new File("out.txt");
		OutputStream out = new FileOutputStream(file);
		int re1=0, left1=0,right1=0;
		int re2=0, left2=0,right2=0;
		String c[] ={"+","-","×","÷"};
		byte c1[]=new byte[n];
		Random rand=new Random();
		for (int i=0;i<=n;i++) {
			int a=rand.nextInt(c.length);
			String resultChar=c[a];
			byte contentInBytes1[] =resultChar.getBytes();
			out.write(contentInBytes1);
			
			if (grade==1) {
				for (int i1=0;i1<=n;i1++) {
					left1=rand.nextInt(100);
					right1=rand.nextInt(100);
					String b= left1+resultChar+right1+"=";
					byte contentInBytes2[]=b.getBytes();
					out.write(contentInBytes2);
					if(resultChar=="+"){
			            System.out.println(left1+resultChar+right1+"="+(left1+right1)); 
			            byte c1[0]=(byte)(left1+right1);
						out.write(c1);
			        }else if(resultChar=="-"){
			            re1=left1-right1;
			            System.out.println(left1+resultChar+right1+"="+(left1-right1));
			            
			        }
				}
			}
}
	}
}
