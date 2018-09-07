package ict.sp.test.ch1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("cg")
public class ConsoleGame {
	private List<Game> gList = new ArrayList<Game>();

	@Autowired
	public void setGame(List<Game> gList) {
		this.gList = gList;

	}

	public void on() throws Exception {
		if (gList.size() == 0) {
			throw new Exception("NO GAME");
		}
		System.out.println("READY");
	}

	public void startGame() {
		for (Game g : this.gList) {
			g.start();
			g.attack();
			g.jump();
			g.end();
		}
	}

}
