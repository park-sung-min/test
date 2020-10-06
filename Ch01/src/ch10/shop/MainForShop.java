package ch10.shop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch07.xml.search.SearchClientFactory;
import ch07.xml.search.SearchServiceHealthChecker;

public class MainForShop {
	public static void main(String[] args) {
		runByUsingXmlConfig();
	}
		private static void runByUsingXmlConfig() {
			//xml방식!!
			//GenericXmlApplicationContext ctx 
			//= new GenericXmlApplicationContext("classpath:ch10/shop/config-shop.xml");
			
			//annotation방식
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigShop.class);
			useBean(ctx);
			ctx.close();
		}
		private static void useBean(ApplicationContext ctx) {
			ProductService productService = ctx.getBean(ProductService.class);
			productService.createProduct(new ProductInfo());
			OrderService orderService = ctx.getBean(OrderService.class);
			orderService.order(new OrderInfo());
			SearchClientFactory orderSearchClientFactory = ctx.getBean("orderSearchClientFactory",SearchClientFactory.class);
			System.out.println(orderSearchClientFactory);
			SearchServiceHealthChecker healthChecker = ctx.getBean("searchServiceHealthChecker", SearchServiceHealthChecker.class);
			healthChecker.check();
		}
		
		
		
}
