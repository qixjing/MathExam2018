

public class OperationFactory {
	public static Operation createOperate(Bean bean) {
		Operation oper = null;
		switch (bean.getSymbol()) {
		case "+":
			oper = new OperationAdd(bean);
			break;
		case "-":
			oper = new OperationSubtract(bean);
			break;
		case "*":
			oper = new OperationMultiply(bean);
			break;
		case "/":
			oper = new OperationDiv(bean);
			break;
		}

		return oper;
	}
}
