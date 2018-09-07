package ict.sp.test.ch1;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

public class Executor {

	static void load(Game g) {
		g.start();
		g.attack();
		g.jump();
		g.end();
	}

	public static void main(String[] args) {

		DefaultListableBeanFactory fac = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader read = new XmlBeanDefinitionReader(fac);
		FileSystemResource fr = new FileSystemResource("src/main/resources/ch1/ioc.xml");
		read.loadBeanDefinitions(fr);

		ConsoleGame cg = (ConsoleGame) fac.getBean("test");
		

		try {
			cg.on();
			cg.startGame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
