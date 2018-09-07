package ict.sp.test.ch1;

import org.springframework.stereotype.Service;

//@Service("ma")
public class Mario extends Game {

	@Override
	public void attack() {
		System.out.println("FIRE");

	}

	@Override
	public void jump() {
		System.out.println("JUMP");

	}

}
