public class RandomOfDiv extends RandomNumber {
	// 二年级的除法题
	// A为一位数或者两位数,B设为个位数
	// A/B=C,C应该为个位数

	public void createRandomAandB(Bean bean) {
		int result = 0;
		int randomB = 0;
		int randomA = 0;
		do {
			// 将A的取值范围设置为10到99
			randomA = 10 + random.nextInt(90);
			// 将B的取值范围设置为1到9
			randomB = 1 + random.nextInt(9);
			result = randomA / randomB;
		} while (result >= 10);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
