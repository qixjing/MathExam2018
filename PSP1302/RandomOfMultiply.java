public class RandomOfMultiply extends RandomNumber {
	//二年级的乘法
	//(A*B)的值应该小于100，A和B都应为一位数或者两位数	
	public void createRandomAandB(Bean bean) {
		//为使生成的题目更接近二年级的乘除题，故将A的取值范围设置为 5到30
		int randomA = 5 + random.nextInt(26);
		// B的取值范围为 1到 (100/A)
		int randomB = 1 + random.nextInt((100/randomA)+1-1);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
