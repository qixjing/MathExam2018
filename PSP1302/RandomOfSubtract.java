public class RandomOfSubtract extends RandomNumber {
	// 生成一年级减法运算的题目 A-B
	// 先生成A的值,再根据A的值生成B，A和B可以为个位数或者两位数
	// A-B的值应该大于等于0
	public void createRandomAandB(Bean bean) {
		// 为方便B的取值，将A的取值范围设置成 10到89
		int randomA = 10 + random.nextInt(90);
		// A应该大于等于B
		int randomB = random.nextInt(randomA + 1);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
