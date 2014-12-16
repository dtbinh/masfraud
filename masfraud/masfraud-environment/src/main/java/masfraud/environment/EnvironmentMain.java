package masfraud.environment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EnvironmentMain {

	
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-masfraud-environment.xml");
	}
}
