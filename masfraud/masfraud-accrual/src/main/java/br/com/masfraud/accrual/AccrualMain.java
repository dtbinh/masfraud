package br.com.masfraud.accrual;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccrualMain {

	
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-masfraud-accrual.xml");
	}
}
