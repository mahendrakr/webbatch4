package mywebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/reg.do")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Collect the data
				String name = request.getParameter("fname");
				String email = request.getParameter("uemail");
				String phone = request.getParameter("phnumber");
				String gender = request.getParameter("gender");
				String[] course = request.getParameterValues("course");
				String time = request.getParameter("timing");
				
				// process the data
				System.out.println(name);
				System.out.println(email);
				System.out.println(phone);
				System.out.println(gender);
				for(String c: course) {
					System.out.println(c);
				}
				System.out.println(time);
				
				// prepare the response.
				PrintWriter out = response.getWriter();
				out.write("<h1>Data submitted successfully</h1>");
	}

}
