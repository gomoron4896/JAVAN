package ict.sp.test.ch3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("rstr")
public class Restaurant {

	@Autowired
	private List<Food> fList;
	
	@Autowired
	@Qualifier("stake")
	private Food food1;
	
	@Autowired
	@Qualifier("pasta")
	private Food food2;
	
	@Autowired
	@Qualifier("pizza")
	private Food food3;
	
	public Food getStake() {
		return food1;
	}

	public Food getPasta() {
		return food2;
	}
	
	public Food getPizza() {
		return food3;
	}
	
	public List<Food> getSetMenu() {
		return fList;
	}
	
	
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("ch3/ioc.xml");
		
		Restaurant rstr = (Restaurant)ac.getBean("rstr");
		
		for(Food f : rstr.getSetMenu()) {
		
		f.buy();
		f.sell();
		
		}
	}
}
