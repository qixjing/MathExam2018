import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class MathExam4269 {
	static int a;
	static int b;
	static int sym;

	public static boolean check() {
		a = (int) (0 + Math.random() * (100 - 0 + 1));
		b = (int) (0 + Math.random() * (100 - 0 + 1));
		sym = (int) (1 + Math.random() * (2 - 1 + 1));
		if (sym == 1) {
			if ((a + b) > 100) {
				return false;
			} else {
				return true;
			}
		} else {
			if ((a - b) < 0) {
				return false;
			} else {
				return true;
			}

		}

	}

	public static boolean isNum(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void math(int n) {
		String prob;
		String ans;
		ArrayList<String> probs = new ArrayList<String>();
		ArrayList<String> anss = new ArrayList<String>();
		boolean end = false;
		for (int i = 1; i <= n; i++) {
			do {
				end = check();
			} while (!end);

			if (sym == 1) {
				prob = "(" + i + ")" + " " + a + " " + "+" + " " + b;
				ans = "(" + i + ")" + " " + a + " " + "+" + " " + b + " " + "=" + " " + (a + b);
			} else {
				prob = "(" + i + ")" + " " + a + " " + "-" + " " + b;
				ans = "(" + i + ")" + " " + a + " " + "-" + " " + b + " " + "=" + " " + (a - b);
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
				str += "\r\n";
				data = str.getBytes();
				try {
					out.write(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("写入错误!");
					e.printStackTrace();
				}
			}
			String fg = "-----------------标准答案-----------------" + "\r\n";
			data = fg.getBytes();
			try {
				out.write(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("写入错误!");
				e.printStackTrace();
			}
			for (String str : anss) {
				str += "\r\n";
				data = str.getBytes();
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
		if(args.length!=1) {
			System.out.println("输入的参数个数不为1,请重试");
		}else {
			String str = args[0];
			if (isNum(str)) {
				if (str.length() >= 5) {
					System.out.println("输入数据过大,请重试");
				} else {
					math(Integer.parseInt(str));
				}
			} else {
				System.out.println("输入有误,请重新输入");
			}
		}
	}
}
