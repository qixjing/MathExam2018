public class RandomOfDiv extends RandomNumber {
	//二年级的除法题
	// A和B应为一位数或者两数位
	// A应该大于等于B
	// A/B的值如果有余数
	
	public void createRandomAandB(Bean bean) {
		//将A的取值范围设置为3到99
		int randomA = 3 + random.nextInt(97);
		int randomB= 0;
		//将B的取值范围设置为2到randomA
		randomB = 2+ random.nextInt(randomA+1-2);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
