package Crud_Oparetion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmployeeBO.EmployeeBo;
import EmployeeDAO.EmployeeDao;

/**
 * Servlet implementation class Crud_Oparetion
 */
@WebServlet("/Crud_Oparetion")
public class Crud_Oparetion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Crud_Oparetion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String country=request.getParameter("country");
		String city=request.getParameter("city");
//		 pw.print(name);
//		 pw.print(email);
//		 pw.print(password);
//		 pw.print(country);
//		 pw.println(city);
		 
		EmployeeBo ob=new EmployeeBo();
		ob.setName(name);
		ob.setEmail(email);
		ob.setPassword(password);
		ob.setCountry(country);
		ob.setCity(city);
		
		int result=EmployeeDao.insert(ob);
		
		if (result>0) {
			//pw.print("Your data has been successfully inserted..!");
			pw.print("<head><script>alert('Your data has been successfully inserted..!')</script></head>");
			//response.sendRedirect("Login.html");
		} else {
			//pw.print("something want wrong..!");
			pw.print("<head><script>alert('something want wrong..!')</script></head>");
			
		}
	}

}
