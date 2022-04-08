package mywebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.util.JdbcUtil;

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
	//			String[] course = request.getParameterValues("course");
				String course = request.getParameter("course");
				String time = request.getParameter("timing");
				
				// process the data
				System.out.println(name);
				System.out.println(email);
				System.out.println(phone);
				System.out.println(gender);
				
				System.out.println(time);
				//insert into database
				Connection con = JdbcUtil.getMySQLConnection();
				PreparedStatement ps=null;
				String sql="insert into registration values(?,?,?,?,?,?)";
				try {
					 ps = con.prepareStatement(sql); 
					ps.setString(1, name);
					ps.setString(2, email);
					Long ph =Long.valueOf(phone);
					ps.setLong(3,ph);
					ps.setString(4, gender);
					ps.setString(5, course);
					ps.setString(6, time);
					int x = ps.executeUpdate(); 
					if(x==1) {
						System.out.println("Record Inserted");
					}
					else {
						System.out.println("Record not inserted");
						
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					JdbcUtil.cleanUp(con, ps);
				}
				// prepare the response.
				PrintWriter out = response.getWriter();
				out.write("<h1>Data submitted successfully</h1>");
	}

}
