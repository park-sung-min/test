package ch08.anno.user;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch02.service.AuthFailLogger;
import ch02.service.AuthenticationService;
import ch02.service.PasswordChangeService;
import ch02.service.User;
import ch02.service.UserRepository;

@Configuration		//Container���� �˸�
public class ConfigUser {
	
	@Bean
	public User user1() {
		return new User("bkchoi", "1234");
	}
	
	@Bean(name = "user2")
	public User user() {
		return new User("madvirus", "qwer");
	}
	
	@Bean
	public UserRepository userRepository() {
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(), user()));
		return userRepo;
	}
	
	@Bean
	public PasswordChangeService pwChangeSvc() {
		return new PasswordChangeService(userRepository());
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
		authSvc.setUserRepository(userRepository());
		return authSvc;
	}
}
