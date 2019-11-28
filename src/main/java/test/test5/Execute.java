package test.test5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execute {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc/ioc-5.xml");
		PCRoom pcr = (PCRoom)ac.getBean("pcRoom");
		pcr.play();
				
	}
}
