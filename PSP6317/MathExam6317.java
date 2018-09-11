import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author 林泽宇
 * 这是命令行工具MathExam，自动生成一份小学一年级的数学加减计算题。
 */

public class MathExam6317 {
	public static void main(String[] args) throws IOException {

		//确定输出的文件
		File file = new File("out.txt");
		//创建指向文件的数据输出流
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		
//		@SuppressWarnings("resource")
//		Scanner input = new Scanner(System.in);
//		System.out.println("小学一年级数学加减计算题");
//		System.out.println("请输入题目数量：");
		
		//获取控制台输入题目数量n，格式为String
//		String args[0] = input.nextLine();
		
		//循环判断：输入的是否是一个正整数
//		while(true) {
//			if(!(args[0].matches("\\d+"))) {
//				System.out.println("错误1.您的输入有误，请重新输入一个1~1000的整数：");
//				args[0] = input.nextLine();	
//			}
//			else {
//				break;
//			}
//		}
//		//将n从String类型转换为int类型
//		int n = Integer.parseInt(args[0]);
//		
//		//循环判断：当n的范围属于1~1000时跳出死循环，否则重新获取控制台输入
//		while(true) {
//			if(n>0 && n<=1000) {
//				break;
//			}
//			else {
//				System.out.println("错误2.您的输入有误，请重新输入一个1~1000的整数：");
//				args[0] = input.nextLine();
//			}
//			n = Integer.parseInt(args[0]);
//		}
		
		while(true) {
			if(!(args[0].matches("\\d+"))) {
				return;
			}
			else if(Integer.parseInt(args[0])>0 && Integer.parseInt(args[0])<=1000) {
				break;
			}
			else {
				return;
			}
		}
		
		//生成题目
		for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
			//生成两个随机数
			int num1 = (int)(Math.random()*100+1);
			int num2 = (int)(Math.random()*100+1);
			//生成题序和题目
			if(num1 > num2) {
				//生成减法
				if(num2 >= 10)
					num2 = num2%10*10;
				System.out.println("("+ i +") " + num1 +" - "+ num2 );
				String str = ("("+ i +") " + num1 +" - "+ num2 + " = " + (num1-num2));
				//写入数据
				out.writeUTF(str);
//				System.out.println(str);
			}	
			else {
				//生成加法
				if(num2 >= 10)
					num2 = num2%10*10;
				System.out.println("("+ i +") " + num1 +" + "+ num2 );
				String str = ("("+ i +") " + num1 +" + "+ num2 + " = " + (num1+num2));
				//写入数据
				out.writeUTF(str);
//				System.out.println(str);
			}
		}
		out.close();
		
		System.out.println();
		
		//创建指向文件的数据输入流
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		//读数据   输出题目和答案
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			System.out.println(in.readUTF());
		}
		in.close();
		
	}//main
}