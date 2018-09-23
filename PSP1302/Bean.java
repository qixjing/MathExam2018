
public class Bean {
	private int argsLength=0; //�������еĲ���args����ĳ���
	private int count = 1; // ��ţ���ʼΪ1
	private int quizNumber = 0; // ��Ŀ��
	private int grade = 1; // �꼶��Ĭ��Ϊ1
	private int StudentId = 1302; // ѧ��
	private String OperationType = null; // ��Ŀ���ͣ��Ӽ��⻹�ǳ˳���
	private String symbol = null; // ��Ŀ���������
	private int numberA = 0;
	private int numberB = 0;
	private int result = 0; // ������
	private int mod = 0; //���������е�����
	private StringBuffer text1 = new StringBuffer(""); // ��Ŀ�� ��ʽ: A + B =
	private StringBuffer text2 = new StringBuffer(""); // �� ����ʽ: A + B = C
	private String txt = null; // txt = text1 + text2

	public int getQuizNumber() {
		return quizNumber;
	}

	public void setQuizNumber(String input) {
		// ��������ʽ���������ַ����Ƿ��ǡ�����Ĵ����֡�
		if (input.matches("0||[1-9]\\d*")) {
			if(input.length()>4){
				exception();
			}
			else{
				int number = Integer.valueOf(input);
				// �������������Ƿ�Ϊ�������߹��󣨴���1��
				if (number < 0 || number > 10000) {
					exception();
				}
				quizNumber = number;
			}
		} else {
			exception();
		}
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		// ��������ʽ���grade�Ƿ�Ϊ��1�����ߡ�2��		
		if (grade.matches("[12]")) {
			this.grade = Integer.valueOf(grade);
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
		if (count != 1)
			text1.append("\n") ;
		text1.append("(" + count + ")" + " " + String.valueOf(this.getNumberA()) + " " + symbol + " "
				+ String.valueOf(this.getNumberB()));
	}

	private void setText2() {
		text2 = text2.append("\n");
		text2.append("(" + count + ")" + " " + String.valueOf(this.getNumberA()) + " " + symbol + " "
				+ String.valueOf(this.getNumberB()) + " = " + String.valueOf(this.getResult()));
		if(mod!=0){
			text2.append("..." + String.valueOf(mod));
			mod=0;
		}
		
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
		txt = text1 + "\n" + text2;
	}

	public int getMod() {
		return mod;
	}

	public void setMod(int mod) {
		this.mod = mod;
	}

	public int getArgsLength() {
		return argsLength;
	}

	public void setArgsLength(int argsLength) {
		if(argsLength ==1 || argsLength==2){	
			this.argsLength=argsLength;
		}
		else{
			exception();
		}
	}

}
