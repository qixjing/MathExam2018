public class RandomOfDiv extends RandomNumber {
	//���꼶�ĳ�����
	// ��A/B����ֵӦ��Ϊ������A��BӦΪһλ����������λ
	//  AӦ�ô��ڵ���B
	
	public void createRandomAandB(Bean bean) {
		//��A��ȡֵ��Χ����Ϊ10��99
		int randomA = 10 + random.nextInt(90);
		int randomB=0;
		while(true){
			//��B��ȡֵ��Χ����Ϊ1��randomA
			randomB = 2+ random.nextInt(randomA+1);
			if(randomA % randomB==0)
				break;
		}
		bean.setNumberA(randomA);
		bean.setNumberB(randomB);
	}

}
