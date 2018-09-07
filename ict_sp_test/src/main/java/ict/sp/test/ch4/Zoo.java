package ict.sp.test.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Zoo {

	private Animal cat;
	
	public Zoo() {}

	public Zoo(Animal cat) {
		this.cat = cat;
	}
	
	public void doSome() {
		cat.attack();
		cat.howl();
		cat.sleep();
	}
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("ch4/ioc.xml");
		
		Zoo zoo = (Zoo) ac.getBean("zoo");
		zoo.doSome();
		
	}

}
