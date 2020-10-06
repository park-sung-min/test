package ch02.service;

public class User {
	private String id;
	private String password;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public boolean matchPassword(String inputPasswd) {
		return password.equals(inputPasswd);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if(!matchPassword(oldPassword))
			throw new IllegalArgumentException("illegal password");
		password = newPassword;
		System.out.println("패스워드 수정  :"  + this);

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + "]";
	}
	
}
