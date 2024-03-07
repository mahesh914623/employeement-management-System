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
 * Servlet implementation class EditservletPage
 */
@WebServlet("/EditservletPage")
public class EditservletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditservletPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		pw.print("<!DOCTYPE html>");
		pw.print("<head><title>Update Employees</title><link rel='stylesheet' href='UpdateEMP.css'></head>");
		pw.print("<body>");
		pw.println("<h1>Update employee Details</h1>");
	     String id=request.getParameter("id");
	     int id1=Integer.parseInt(id);
	     EmployeeBo ob= EmployeeDao.search(id1);
	    
	    pw.print("<table>");
		pw.print("<form action='EditServlet' method='post'>");
		pw.print("<tr><td></td><td><input type='hidden' name='id' value= "+ob.getId()+ "></td></tr>");
	    pw.print("<tr><td>Name :</td><td><input type='text' name='name' value= "+ob.getName()+ "></td></tr>");
		pw.print("<tr><td>Email ID :</td><td><input type='text' name='email' value= "+ob.getEmail()+ "></td></tr>");
		pw.print("<tr><td>Password :</td><td><input type='text' name='password' value= "+ob.getPassword()+ "></td></tr>");
	    pw.print("<tr><td>Country :</td><td><input type='text' name='country' value= "+ob.getCountry()+ "></td></tr>");
		pw.print("<tr><td>City :</td><td><input type='text' name='city' value= "+ob.getCity()+ "></td></tr>");
		 
		 pw.print("<tr><td><input type='submit' value='Edit and save'/></td><td><button type='DataFetch.java'>Back</button></td></tr>");
		pw.print("</form>");
		pw.print("</table>");
		pw.print("</body>");
		pw.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
