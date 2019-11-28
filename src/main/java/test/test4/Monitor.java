package test.test4;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Monitor {
	private String name="LG 24인치";

	@Override
	public String toString() {
		return "Monitor [name=" + name + "]";
	}
}
