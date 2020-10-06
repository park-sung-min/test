package ch11.anno.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch10.shop.OrderInfo;
import ch10.shop.OrderService;
import ch10.shop.ProductInfo;
import ch10.shop.ProductService;

public class MainByScan {
	public static void main(String[] args) {
		useXmlWithScan();
		
	}
	private static void useXmlWithScan() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:ch11/anno/xml/config-with-scan.xml");
		useContext(ctx);
		ctx.close();
	}
	private static void useContext(ApplicationContext ctx) {
		ProductService productService = ctx.getBean("productService", ProductService.class);
		productService.createProduct(new ProductInfo());
		
		OrderService orderService = ctx.getBean("orderSvc",OrderService.class);
		orderService.order(new OrderInfo());
	}
}
