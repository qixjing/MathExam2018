

public class OperationMultiply extends Operation {

	public OperationMultiply(Bean bean) {
		this.bean=bean;
	}

	public void calculate() {
		int result = bean.getNumberA() * bean.getNumberB();
		bean.setResult(result);
	}

}
