

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;


public class MathExam1302 {
	static Bean bean = new Bean();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String number = input.next();
		String grade = input.next();
		input.close();
		bean.setQuizNumber(number);// 设置出题数
		bean.setGrade(grade); //设置年级数

		for (int n = 0; n < bean.getQuizNumber(); n++) {
			getSymbol(); // 产生运算符号
			RandomNumber ran = RandomNumberFactory.createRan(bean.getSymbol());
			ran.createRandomAandB(bean);
			Operation oper = OperationFactory.createOperate(bean);
			oper.calculate();
			bean.setText();
		}
		bean.setTxt();
		createMathExamTxt();
	}


	private static void getSymbol() {
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
	
	private static void createMathExamTxt() {
		try {
			FileOutputStream fos = new FileOutputStream("out.txt");
			PrintStream ps = new PrintStream(fos);
			ps.println(bean.getTxt());
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	//粗略检测数字是否有误
	@SuppressWarnings("unused")
	private static void checkNumberCorrection() {
		if(bean.getSymbol()=="/"){
			if(bean.getNumberA()<bean.getNumberB()){
				System.out.println("ERROR");
				System.exit(0);
			}
		}
		
	}

}
