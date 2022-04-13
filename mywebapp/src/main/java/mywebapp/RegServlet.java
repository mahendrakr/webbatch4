package mywebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.util.JdbcUtil;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet(urlPatterns="/reg.do",initParams = {
		@WebInitParam(name="website",value="www.sirt.com"),
		@WebInitParam(name="phone",value="8602546990")
} )
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) {
    	this.config=config;
    String website = config.getInitParameter("website");	
    	System.out.println(website);
    	String phone = config.getInitParameter("phone");
        System.out.println(phone);
        }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String website = config.getInitParameter("website");	
    	System.out.println(website);
    	String phone1 = config.getInitParameter("phone");
        System.out.println(phone1);
        System.out.println("**********************************");
        System.out.println("ServletContext Object");
        ServletContext context = config.getServletContext();
        System.out.println("Website : "+context.getInitParameter("website"));
        System.out.println("ContextPath : "+context.getContextPath());
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
				//Case2 : You can access the parameters name and values as a map.
				Map<String, String[]> map = request.getParameterMap();
				for(Map.Entry<String, String[]> e:map.entrySet()) {
					
					for(String v:e.getValue()) {
						System.out.println(e.getKey()+ " " + v);
					}
				}
				System.out.println("*****************");
				//Case 3: To access only request parameters 
				Enumeration<String> enm = request.getParameterNames();
				while(enm.hasMoreElements()) {
					System.out.println(enm.nextElement());
				}
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
