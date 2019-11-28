package test.test5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("pcRoom")
public class PCRoom {
	private Game game;
	
	@Autowired
	public PCRoom(@Qualifier("LOL")Game game) {
		this.game = game;
	}
	
	public void play() {
		this.game.on();
		this.game.play();
		this.game.off();
	}
}
