/*
 *第一条保留了原有规范的4空格缩进
 *第二条:放松了对import语句的组织方式要求,只要有一定逻辑性即可，不做严格限制.
 *第三条:但要求未使用的import语句必须删除 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MathExam6320 {
	public static void CreateFile() {
		/* 生成txt文件 */
		String filename="out.txt";
		File file=new File(filename);
		if(!file.exists()) {
			System.out.println("文件创建成功");
		}else {
			System.out.println("文件已存在");
		}
	}
	
	public static void print(int N,int M) {
		char sign[]= {'+','-','*','/'};
		Random random=new Random();
		Map<Integer,String> map1=new HashMap<Integer,String>();
		Map<Integer,Integer> map2=new HashMap<Integer,Integer>();
		/* 生成随机数并添加到数组存储 */
		for(int i = 1; i <= N; i++) {
			int x=random.nextInt(M);
			int y=random.nextInt(M);
			int f=random.nextInt(M)%2;
			int num = 0;
			
			switch (f) {
				case 0:num=x+y;	break;
				case 1:
					while(y>x) {
						y=random.nextInt(M);
					}
					num=x-y;	break;
			}
			map1.put(i,x+" "+sign[f]+" "+y);
			map2.put(i,num);
		}
		
		/* 向文件写入计算题 */
		PrintStream pS=null;
		try {
			pS = new PrintStream(new FileOutputStream("out.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载文件失败");
			e.printStackTrace();
		}
		/* 题目 */
		for (int i = 1; i <= N; i++) {
			pS.println("("+i+") "+map1.get(i));
		}
		pS.println("");
		System.out.println("");
		/* 标准答案 */
		for (int i = 1; i <= N; i++) {
			pS.println("("+i+") "+map1.get(i)+" = "+map2.get(i));
		}
		pS.close();
	}
	
	public static void main(String[] args) {
		try	{
			if(args[0] != null && args[0].matches("0*[0-9]{0,3}")){
			Integer N=Integer.parseInt(args[0]);
			CreateFile();
			print(N,50);
			}else {
				System.out.println("请输入合法参数(范围在1~999的整数)");
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("请输入参数");
		}
	}
}