

public class Bean {
	private int count = 1; // ��ţ���ʼΪ1
	private int quizNumber = 0; // ��Ŀ��
	private int StudentId = 1302; // ѧ��
	private String OperationType = null; // ��Ŀ���ͣ��Ӽ��⻹�ǳ˳���
	private String symbol = null; // ��Ŀ���������
	private int numberA = 0;
	private int numberB = 0;
	private int result = 0;
	private String text1 = ""; // �洢��Ŀ ��ʽ�� A + B =
	private String text2 = ""; // �洢�� ��ʽ�� A + B = C
	private String txt = null; // txt = text1 + text2

	public int getQuizNumber() {
		return quizNumber;
	}

	public void setQuizNumber(String input) {
		// ��������ʽ���������ַ����Ƿ��ǡ���0��ͷ�Ĵ����֡�
		if (input.matches("[1-9]\\d*")) {
			int number = Integer.valueOf(input);
			// �������������Ƿ������߹��󣨴���10��
			if (number < 0 || number >= 100000) {
				exception();
			}
			quizNumber = number;
		} else {
			exception();
		}
	}

	static void exception() {
		System.out.println("��������,������ֹ��");
		System.exit(0);
	}

	public String getOperationType() {
		return OperationType;
	}

	public void setOperationType(String operationType) {
		OperationType = operationType;

	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setText() {
		setText1();
		setText2();
		count++;
	}

	private void setText1() {
		if(count!=1)
			text1 = text1 + "\n";
		text1 = text1 + "(" + count + ")" + " " +
				String.valueOf(this.getNumberA()) +
				" " + symbol + " " + 
				String.valueOf(this.getNumberB()) + " =";
	}

	private void setText2() {
		text2 = text2 + "\n";
		text2 = text2 + "(" + count + ")" + " " 
				+ String.valueOf(this.getNumberA()) + " " +
				symbol + " "+ String.valueOf(this.getNumberB()) + 
				" = " + String.valueOf(this.getResult());
	}

	public int getNumberA() {
		return numberA;
	}

	public void setNumberA(int numberA) {
		this.numberA = numberA;
	}

	public int getNumberB() {
		return numberB;
	}

	public void setNumberB(int numberB) {
		this.numberB = numberB;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt() {
		txt = text1 + "\n" +  text2;
	}

}
