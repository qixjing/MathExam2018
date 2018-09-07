

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;


public class MathExam1302 {
	static Bean bean = new Bean();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String number = input.nextLine();
		input.close();
		bean.setQuizNumber(number);// ���ó�����
		// ����Ϊ��+-�� �������������Ϊһ�꼶�ļӼ���
		// ����Ϊ��*/�� �������������Ϊ���꼶�ĳ˳���
		bean.setOperationType("+-");
		for (int n = 0; n < bean.getQuizNumber(); n++) {
			getSymbol(); // �����������
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
		switch (bean.getOperationType()) {
		case "+-":
			// �������true��false����true��Ϊ��+������false��Ϊ��-��
			if (ran.nextBoolean()) {
				bean.setSymbol("+");
			} else {
				bean.setSymbol("-");
			}
			break;
		case "*/":
			// �������true��false����true��Ϊ��*������false��Ϊ��/��
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

}
