package sim.test.ict;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

public class Pub {
	public static void main(String[] args) {
		
		String path = "src/main/resources/beandi.xml";
		DefaultListableBeanFactory reg = new DefaultListableBeanFactory();
		
		XmlBeanDefinitionReader xdr = new XmlBeanDefinitionReader(reg);
		xdr.loadBeanDefinitions(new FileSystemResource(path));
		Liqueur li = (Liqueur) reg.getBean("soju");
		li.drink();
	}
}
