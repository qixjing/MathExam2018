import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class MathExam4269 {
	public static void math(int n) {
		String prob;
		String ans;
		ArrayList<String> probs=new ArrayList<String>();
		ArrayList<String> anss=new ArrayList<String>();
		for(int i=1;i<=n;i++) {
			int a=(int)(1+Math.random()*(99-1+1));
			int b=(int)(1+Math.random()*(99-1+1));
			int sym=(int)(1+Math.random()*(2-1+1));
			if(sym==1) {
				prob="("+i+")"+" "+a+" "+"+"+" "+b;
				 
				ans="("+i+")"+" "+a+" "+"+"+" "+b+" "+"="+" "+(a+b);
			}else{
				prob="("+i+")"+" "+a+" "+"-"+" "+b;
				ans="("+i+")"+" "+a+" "+"-"+" "+b+" "+"="+" "+(a-b);
			}
			probs.add(prob);
			anss.add(ans);
		}
		File file = new File("out.txt");
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("文件创建失败,请重试");
					e.printStackTrace();					
				}
		}
		try {
			OutputStream out = new FileOutputStream(file);
			byte[] data;
			for (String str : probs) {
				str+="\r\n";
				data=str.getBytes();
				try {
					out.write(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("写入错误!");
					e.printStackTrace();
				}
			}
			String fg="-----------------标准答案-----------------"+"\r\n";
			data=fg.getBytes();
			try {
				out.write(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("写入错误!");
				e.printStackTrace();
			}
			for (String str : anss) {
				str+="\r\n";
				data=str.getBytes();
				try {
					out.write(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("写入错误!");
					e.printStackTrace();
				}
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("io错误");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("找不到文件,请重试");
			e.printStackTrace();
		}
	
	}
	public static void main(String[] args) {
		int n=Integer.parseInt(args[0]);
		math(n);
	}
}
