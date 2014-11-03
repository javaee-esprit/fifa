package beans;

import com.fifa.persistence.Admin;
import com.fifa.persistence.User;
import com.fifa.services.UserServiceLocal;

public class AuthenticationBean {
	private UserServiceLocal userServiceLocal;

	private String login;
	private String password;

	public AuthenticationBean(String login, String password,
			UserServiceLocal userServiceLocal) {
		this.login = login;
		this.password = password;
		this.userServiceLocal = userServiceLocal;
	}
	
	public String doLogin(){
		String navigateTo = null;
		User user = userServiceLocal.authenticate(login, password);
		if (user != null) {
			System.out.print("ACCESS GRANTED");
			if (user instanceof Admin) {
				System.out.println(" AS ADMIN");
				navigateTo = "/home.xhtml";
			}

		} else {
			System.out.println("ACCESS DENIED");
			navigateTo = "/error.xhtml";
		}
		return navigateTo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
