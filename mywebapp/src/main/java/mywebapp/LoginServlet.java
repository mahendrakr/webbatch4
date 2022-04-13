package mywebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Collect the data 
		String email = request.getParameter("uemail");
		String password = request.getParameter("pwd");
		System.out.println(email);
		//Process the data
		String msg="";
		if(password.equals("password")) {
			msg="Welcome User";
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		
			
		}
		else {
			msg="Invalid Password";
			RequestDispatcher rd1 = request.getRequestDispatcher("error.jsp");
			rd1.forward(request, response);
			
		}
		//Prepare the response
		PrintWriter printWriter = response.getWriter();
		printWriter.write(msg);
	}

}
