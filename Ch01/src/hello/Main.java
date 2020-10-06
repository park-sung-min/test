package hello;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/applicationContext.xml");
		User user = (User) ctx.getBean("user1");
		user.print();
		
	}
}
