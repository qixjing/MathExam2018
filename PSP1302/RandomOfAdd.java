public class RandomOfAdd extends RandomNumber {
	// ����һ�꼶�ӷ��������Ŀ A+B
	// ������A��ֵ,�ٸ���A��ֵ����B��A��B����Ϊ��λ��������λ��
	// A��B֮��Ӧ�ò�����100
	public void createRandomAandB(Bean bean) {
		int randomA = random.nextInt(100);
		int randomB = random.nextInt(100 - randomA);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
