public class RandomOfSubtract extends RandomNumber {
	// 生成一年级减法运算的题目 A-B
	// A应该大于B
	public void createRandomAandB(Bean bean) {
		// 为方便B的取值，将A的取值范围设置成 [5-9] 和 [10 20 30 ....90]
		int randomA = 0;
		//当 true时，生成 [5-9], false时，生成 [10 20 30 ....90]
		if (random.nextBoolean()) {
			randomA = random.nextInt(5) + 5;
		} else {
			randomA = 10 * (random.nextInt(9) + 1);
		}
		// A应该大于等于B
		int randomB = random.nextInt(randomA + 1);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
