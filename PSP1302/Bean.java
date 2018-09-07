
public class Bean {
	private int count = 1; // 题号，初始为1
	private int quizNumber = 0; // 题目数
	private int grade = 0; // 年级
	private int StudentId = 1302; // 学号
	private String OperationType = null; // 题目类型，加减题还是乘除题
	private String symbol = null; // 题目的运算符号
	private int numberA = 0;
	private int numberB = 0;
	private int result = 0; // 运算结果
	private int mod = 0; //除法运算中的余数
	private String text1 = ""; // 题目， 格式: A + B =
	private String text2 = ""; // 答案 ，格式: A + B = C
	private String txt = null; // txt = text1 + text2

	public int getQuizNumber() {
		return quizNumber;
	}

	public void setQuizNumber(String input) {
		// 用正则表达式检查输入的字符串是否是“非0开头的纯数字”
		if (input.matches("[0-9]\\d*")) {
			int number = Integer.valueOf(input);
			// 检查输入的数字是否负数或者过大（大于10万）
			if (number < 0 || number >= 100000) {
				exception();
			}
			quizNumber = number;
		} else {
			exception();
		}
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		// 用正则表达式检查grade是否为“1”或者“2”
		if (grade.matches("[12]")) {
			this.grade = Integer.valueOf(grade);
		} else {
			exception();
		}
	}

	static void exception() {
		System.out.println("输入有误,程序终止！");
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
			text1 = text1 + "\n";
		text1 = text1 + "(" + count + ")" + " " + String.valueOf(this.getNumberA()) + " " + symbol + " "
				+ String.valueOf(this.getNumberB()) + " =";
	}

	private void setText2() {
		text2 = text2 + "\n";
		text2 = text2 + "(" + count + ")" + " " + String.valueOf(this.getNumberA()) + " " + symbol + " "
				+ String.valueOf(this.getNumberB()) + " = " + String.valueOf(this.getResult());
		if(mod!=0){
			text2= text2 + "..." + String.valueOf(mod);
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

}
