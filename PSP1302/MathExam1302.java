import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class MathExam1302 {
	public static void main(String[] args) {
		Bean bean = new Bean();
		bean.setArgsLength(args.length);
		bean.setQuizNumber(args[0]);// 设置出题数
		if (args.length == 2) {
			bean.setGrade(args[1]); // 设置年级数
		}
		long time1=0; long time2=0; long time=0; // 用来测试字符串拼接花费的时间
		for (int n = 0; n < bean.getQuizNumber(); n++) {
			getSymbol(bean); // 产生运算符号
			//随机数工厂，根据运算符号的不同，即可返回对应的对象
			RandomNumber ran = RandomNumberFactory.createRan(bean.getSymbol());
			ran.createRandomAandB(bean);
			Operation oper = OperationFactory.createOperate(bean);
			oper.calculate();
			//测试拼接字符串所花时间
//			time1=System.currentTimeMillis();
			
			bean.setText();  //生成存储题目和答案的字符串
			
//			time2=System.currentTimeMillis();
//			time = time + (time2-time1);
			//时间测试 end
		}
//		System.out.println(time);   //输出拼接字符串所花时间
		bean.setTxt();
		createMathExamTxt(bean);
	}

	private static void getSymbol(Bean bean) {
		Random ran = new Random();
		switch (bean.getGrade()) {
		case 1:
			// 随机产生true或false，若true则为“+”，若false则为“-”
			if (ran.nextBoolean()) {
				bean.setSymbol("+");
			} else {
				bean.setSymbol("-");
			}
			break;
		case 2:
			// 随机产生true或false，若true则为“*”，若false则为“/”
			if (ran.nextBoolean()) {
				bean.setSymbol("*");
			} else {
				bean.setSymbol("/");
			}
			break;
		}
	}

	private static void createMathExamTxt(Bean bean) {
		try {
			FileOutputStream fos = new FileOutputStream("out.txt");
			PrintStream ps = new PrintStream(fos);
			ps.println(bean.getTxt());
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
