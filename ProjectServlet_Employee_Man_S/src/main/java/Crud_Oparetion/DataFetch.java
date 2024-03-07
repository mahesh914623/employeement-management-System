package Crud_Oparetion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmployeeBO.EmployeeBo;
import EmployeeDAO.EmployeeDao;

/**
 * Servlet implementation class DataFetch
 */
@WebServlet("/DataFetch")
public class DataFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataFetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title>Employees detail</title>");
		pw.print("<link rel='stylesheet' type='text/css' href='style.css'>");
		pw.print("</head>");

		pw.print("<body>");
		pw.println("<h1>Employee Details</h1>");
		List<EmployeeBo> al= EmployeeDao.DataFetch();
		
		pw.print("<table  border=1  width=75% style='border-collapse:collapse;margin-left:195px' ");
		pw.print("<tr><th>ID</th><th>NAME</th><th>Email id</th><th>Password</th><th>country</th><th>City</th> <th>Delete</th><th>Edit</th></tr>");
		for( EmployeeBo e:al)
		{
			pw.print("<tr><td>"+e.getId()+"</td>"+"<td>"+e.getName()+"</td>"+"<td>"+e.getEmail()+"</td>"+"<td>"+e.getPassword()+"</td>"+"<td>"+e.getCountry()+"</td>"+"<td>"+e.getCity()+"</td><td><a href='Deleteservlet?id="+e.getId()+"'>delete</a></td><td><a href='EditservletPage?id="+e.getId()+"'>Edit</a></td></tr>");
		}
		pw.print("</table>");
		
		pw.print("<a href='sign.html' class='add'><b>Add employee</b></a>");
		pw.print("<a href='Search.html' class='add'><b>Search</b></a>");

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
