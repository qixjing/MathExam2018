

public class OperationDiv extends Operation {

	public OperationDiv(Bean bean) {
		this.bean = bean;
	}

	public void calculate() {
		int result = bean.getNumberA() / bean.getNumberB();
		bean.setResult(result);
	}

}
