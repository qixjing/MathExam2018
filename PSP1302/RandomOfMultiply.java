public class RandomOfMultiply extends RandomNumber {
	//���꼶�ĳ˷�
	//(A*B)��ֵӦ��С��100��A��B��ӦΪһλ��������λ��	
	public void createRandomAandB(Bean bean) {
		//Ϊ����B��ȡֵ����A��ȡֵ��Χ����Ϊ 5��30
		int randomA = 5 + random.nextInt(26);
		int randomB = random.nextInt(100/randomA);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
