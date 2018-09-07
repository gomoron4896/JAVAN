package ict.sp.test.ch3;

import org.springframework.stereotype.Service;

@Service
public class Pasta implements Food {

	@Override
	public void sell() {
		System.out.println("delicious pasta");
		
	}

	@Override
	public void buy() {
		System.out.println("materials : flour, source, oil, onion");
		
	}

}
