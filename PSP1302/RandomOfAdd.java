public class RandomOfAdd extends RandomNumber {
	// 生成一年级加法运算的题目 A+B
	// A为个位数
	// B为个位数或者整十数
	public void createRandomAandB(Bean bean) {
		// A的取值范围为 [1-9]
		int randomA = random.nextInt(9) + 1;
		int randomB = 0;
		// B为个位数或者整十数
		// true生成 个位数,false生成整十数
		if (random.nextBoolean()) {
			randomB = random.nextInt(9) + 1;
		} else {
			randomB = 10 * (random.nextInt(9) + 1);
		}
		
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
