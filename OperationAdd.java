

public class OperationAdd extends Operation {
	public OperationAdd(Bean bean) {
		this.bean = bean;
	}

	public void calculate() {
		int result = bean.getNumberA() + bean.getNumberB();
		bean.setResult(result);
	}

}
