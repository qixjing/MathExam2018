

public class OperationSubtract extends Operation {

	public OperationSubtract(Bean bean) {
		this.bean = bean;
	}

	public void calculate() {
		int result = bean.getNumberA() - bean.getNumberB();
		bean.setResult(result);
	}

}
