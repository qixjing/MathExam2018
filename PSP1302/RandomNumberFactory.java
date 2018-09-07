

public class RandomNumberFactory {

	public static RandomNumber createRan(String symbol) {
		RandomNumber ran = null;
		switch (symbol) {
		case "+":
			ran = new RandomOfAdd();
			break;
		case "-":
			ran = new RandomOfSubtract();
			break;
		case "*":
			ran = new RandomOfMultiply();
			break;
		case "/":
			ran = new RandomOfDiv();
			break;
		}
		return ran;
	}

}
