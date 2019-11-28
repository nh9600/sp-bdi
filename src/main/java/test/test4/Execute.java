package test.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execute {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc/ioc-4.xml");
		Computer c = (Computer)ac.getBean("computer");
		Monitor m1 = (Monitor)ac.getBean("monitor");
		Monitor m2 = (Monitor)ac.getBean("monitor");
		System.out.println(m1==m2);
	}
}
