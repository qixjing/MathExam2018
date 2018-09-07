public class RandomOfMultiply extends RandomNumber {
	//二年级的乘法
	//(A*B)的值应该小于100，A和B都应为一位数或者两位数	
	public void createRandomAandB(Bean bean) {
		//为方便B的取值，将A的取值范围设置为 5到30
		int randomA = 5 + random.nextInt(26);
		int randomB = random.nextInt(100/randomA);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
