package ch08.anno.user;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch02.service.AuthenticationService;
import ch02.service.PasswordChangeService;

public class MainByJavaConfig {

	public static void main(String[] args) {
		
		useSingleClass();
		useMultipleClass();
	}
	
	private static void useSingleClass() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigUser.class);
		useBean(ctx);
		ctx.close();
	}

	private static void useBean(AnnotationConfigApplicationContext ctx) {
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		
		authSvc.authenticate("bkchoi", "1234");
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
	}
	
	private static void useMultipleClass() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigUser1.class, ConfigUser2.class);
		useBean(ctx);
		ctx.close();
	}
}
