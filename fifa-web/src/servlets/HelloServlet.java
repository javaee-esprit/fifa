package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns = {"/hello", "/welcome"},
			 loadOnStartup = 1,
			 initParams = {@WebInitParam(name = "uni", value = "ISI")}
)
public class HelloServlet extends HttpServlet{
	
	private int visitCount;

	public void init() throws ServletException {
		super.init();
		visitCount = 0;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
	}
	
	public void destroy() {
		super.destroy();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		visitCount++;
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String unversity = getInitParameter("uni");
		String year = getServletContext().getInitParameter("year");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("esprit");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>This is "+unversity+" ("+year+")!</h1>");
		for(int i = 0; i< 3; i++){
			out.println("<h2>Hello "+name+"!</h2>");
		}
		out.println("<h2>visits: "+visitCount+"</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
