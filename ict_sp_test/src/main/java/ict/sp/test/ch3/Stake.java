package ict.sp.test.ch3;

import org.springframework.stereotype.Service;

@Service
public class Stake implements Food {

	@Override
	public void sell() {
		System.out.println("delicious stake");
		
	}

	@Override
	public void buy() {
		System.out.println("materials : meat, source, oil");
		
	}

}
