package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AuthenticationBean;

import com.fifa.persistence.Admin;
import com.fifa.persistence.Employee;
import com.fifa.persistence.User;
import com.fifa.services.UserServiceLocal;

@WebServlet(urlPatterns =  {"/control"}, loadOnStartup = 1)
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UserServiceLocal userServiceLocal;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		String navigateTo = null;
//		if ("4GL1".equals(login)
//					&& "esprit".equals(password)) {
//			navigateTo = "/home.xhtml";
//		}else{
//			navigateTo = "/error.xhtml";
//		}
		AuthenticationBean bean = new AuthenticationBean(login,password,userServiceLocal);
		navigateTo = bean.doLogin();
		rd = getServletContext().getRequestDispatcher(navigateTo);
		rd.forward(request, response);
	}

}
