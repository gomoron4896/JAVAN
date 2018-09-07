package ict.sp.test.ch1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PreExecute {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ch1/ioc.xml");

		ConsoleGame cg = (ConsoleGame) ac.getBean("cg");

		try {
			cg.on();
			cg.startGame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
