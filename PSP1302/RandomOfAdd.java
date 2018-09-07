import java.util.Random;

public class RandomOfAdd extends RandomNumber {
	// 生成一年级加法运算的题目 A+B
	// 先生成A的值,再根据A的值生成B，A和B可以为个位数或者两位数
	// A和B之和应该不大于100
	public void createRandomAandB(Bean bean) {
		int randomA = random.nextInt(100);
		int randomB = random.nextInt(100 - randomA);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
