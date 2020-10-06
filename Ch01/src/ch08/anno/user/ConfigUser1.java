package ch08.anno.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch02.service.AuthFailLogger;
import ch02.service.AuthenticationService;
import ch02.service.PasswordChangeService;
import ch02.service.UserRepository;

@Configuration		//Container임을 알림
public class ConfigUser1 {
	
	@Autowired		// 1.해당 컨테이너의 타입을 자동으로 찾아 세팅 but 2.해당 컨테이너에는 하나의 타입만 존재해야함
	private UserRepository userRepository;
	
	@Bean
	public PasswordChangeService pwChangeSvc() {
		return new PasswordChangeService(userRepository);
	}
	
	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}
	
	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository);
		return authSvc;
	}
}
