package mywebapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/ulogin.do")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("uemail");
		String password = request.getParameter("pwd");
		System.out.println(email);
		System.out.println(password);
		System.out.println("User Login servlet started");
		RequestDispatcher rd1 = request.getRequestDispatcher("header.jsp");
		rd1.include(request, response);
		RequestDispatcher rd2 = request.getRequestDispatcher("success.jsp");
		rd2.include(request, response);
		RequestDispatcher rd3 = request.getRequestDispatcher("footer.jsp");
		rd3.include(request, response);
		System.out.println("User Login servlet finished");
	}

}
