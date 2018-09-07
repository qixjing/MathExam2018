import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MathExam6348 {
	public static void init(StringBuffer strbuf ,String[] s) {
		int answer = 0;
		StringBuffer strbuf1 = new StringBuffer();
		for (int i = 1; i <= Integer.valueOf(s[0]); i++) {
			String number = "(" + i + ")" + " ";
			int first = (int) (Math.random() * 100);
			String mark = first % 2 == 0 ? "+" : "-";
			int second = (int) (Math.random() * 100);
			if (mark.equals("+")) {
				answer = first + second;
			} else {
				answer = first - second;
			}
			strbuf.append(number + first + " " + mark + " " + second + "\n");
			strbuf1.append(number + first + " " + mark + " " + second + " " + "=" + " " + answer + "\n");
		}
		strbuf = strbuf.append("\n" + strbuf1);
		System.out.println(strbuf);
	}

	public static void main(String[] args) {
		StringBuffer strbuf = new StringBuffer();
		init(strbuf,args);
		byte[] bytes = new String(strbuf).getBytes();
		try {
			FileOutputStream fos = new FileOutputStream("out.txt");
			try {
				fos.write(bytes);
			} catch (IOException e) {
				System.out.println("二进制转换错误");
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到！！");
		}
	}
}
