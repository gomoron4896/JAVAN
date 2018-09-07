package ict.sp.test.ch3;

import org.springframework.stereotype.Service;

@Service
public class Pizza implements Food {

	@Override
	public void sell() {
		System.out.println("delicious pizza");
		
	}

	@Override
	public void buy() {
		System.out.println("materials : meat, source, vagi, flour, milk, egg");
		
	}

}
