public class RandomOfDiv extends RandomNumber {
	//二年级的除法题
	// （A/B）的值应该为整数，A和B应为一位数或者两数位
	//  A应该大于等于B
	
	public void createRandomAandB(Bean bean) {
		//将A的取值范围设置为10到99
		int randomA = 10 + random.nextInt(90);
		int randomB=0;
		while(true){
			//将B的取值范围设置为1到randomA
			randomB = 2+ random.nextInt(randomA+1);
			if(randomA % randomB==0)
				break;
		}
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
