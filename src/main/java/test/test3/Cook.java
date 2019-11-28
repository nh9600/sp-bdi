package test.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cook")
public class Cook {
	private Food f;

	public Food getF() {
		return f;
	}
	@Autowired
	public void setF(Food f) {
		this.f = f;
	}
	
}
