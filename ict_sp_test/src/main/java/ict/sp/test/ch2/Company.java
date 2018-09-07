package ict.sp.test.ch2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class Company {
	@Autowired
	List<Emp> empList;

	public void doWorking() {
		for(Emp e : empList) {
			e.doWorking();
		}
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ch2/ioc.xml");
		
		Company c = (Company)ac.getBean("company");
		c.doWorking();
	}
}
