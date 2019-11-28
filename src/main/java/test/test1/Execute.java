package test.test1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Execute {
	public static void main(String[] args) {
		FileSystemResource fsr = new FileSystemResource("src/main/resources/ioc/ioc-1.xml");
		BeanFactory beanFactory = new XmlBeanFactory(fsr);
		Cat c = (Cat)beanFactory.getBean("c");
		Human h = (Human)beanFactory.getBean("h");
		c.setAge(4);
		c.setName("젤리");
		h.setAge(24);
		h.setName("하늘");
		System.out.println(c);
		System.out.println(h);
		
	}
}
