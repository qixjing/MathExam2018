public class RandomOfSubtract extends RandomNumber {
	// ����һ�꼶�����������Ŀ A-B
	// ������A��ֵ,�ٸ���A��ֵ����B��A��B����Ϊ��λ��������λ��
	// A-B��ֵӦ�ô��ڵ���0
	public void createRandomAandB(Bean bean) {
		// Ϊ����B��ȡֵ����A��ȡֵ��Χ���ó� 10��89
		int randomA = 10 + random.nextInt(90);
		// AӦ�ô��ڵ���B
		int randomB = random.nextInt(randomA + 1);
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
		// System.out.println(randomA + " " + randomB);
	}

}
