package ch07.xml.search;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSearch {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch02/config-search.xml");
		SearchClientFactory factory = ctx.getBean("searchClientFactory" , SearchClientFactory.class);
		System.out.println("================");
		System.out.println(factory);
		System.out.println("================");
		SearchClientFactory factory2 = ctx.getBean("searchClientFactory" , SearchClientFactory.class);
		System.out.println("same instance = " + (factory == factory2) );
		ctx.close();
	}
}
