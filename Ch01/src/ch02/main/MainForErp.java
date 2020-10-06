package ch02.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch02.erp.ErpClient;
import ch02.erp.ErpClientFactory;

public class MainForErp {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02/config-erp.xml");
		ErpClientFactory factory = ctx.getBean("factory",ErpClientFactory.class);
		ErpClient client = factory.create();
		client.connect();
		
		client.close();
		ctx.close();
		
	}
}
