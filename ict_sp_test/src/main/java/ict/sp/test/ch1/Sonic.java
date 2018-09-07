package ict.sp.test.ch1;

import org.springframework.stereotype.Service;

//@Service("so")
public class Sonic extends Game {

	@Override
	public void attack() {
		System.out.println("GOTTA GO ATTACK");
		
	}

	@Override
	public void jump() {
		System.out.println("GOTTA GO JUMP");
		
	}

}
