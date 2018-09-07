package ict.sp.test.ch1;

public abstract class Game implements Action {
	
	public Game() {
		System.out.println("게임 생성자");
	}

	@Override
	public abstract void attack();

	@Override
	public abstract void  jump();

	@Override
	public void start() {
		System.out.println("GAME START");
		
	}

	@Override
	public void end() {
		System.out.println("GAME OVER");
		
	}

}
