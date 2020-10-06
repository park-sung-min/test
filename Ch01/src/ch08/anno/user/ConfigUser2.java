package ch08.anno.user;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch02.service.User;
import ch02.service.UserRepository;

@Configuration		//컨테이너
public class ConfigUser2 {
	
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
	
	
}
