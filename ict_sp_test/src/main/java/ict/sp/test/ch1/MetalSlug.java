package ict.sp.test.ch1;

import org.springframework.stereotype.Service;

//@Service("ms")
public class MetalSlug extends Game {

	@Override
	public void attack() {
		System.out.println("FIRE AT WILL");
		
	}

	@Override
	public void jump() {
		System.out.println("FLY HIGH");
		
	}
	

}
