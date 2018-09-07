

import java.util.Random;

public abstract class RandomNumber {
	Random random = new Random();
	
	//因为和类“MathExam”不在同一个包
	//所以RandomNumber类里的方法和属性只有设置成public
	//才能被其他包访问
	abstract public void createRandomAandB(Bean bean);

}
