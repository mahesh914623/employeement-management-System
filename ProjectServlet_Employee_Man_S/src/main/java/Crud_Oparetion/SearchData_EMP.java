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
 * Servlet implementation class SearchData_EMP
 */
@WebServlet("/SearchData_EMP")
public class SearchData_EMP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchData_EMP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter ob=response.getWriter();
		
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		 List<EmployeeBo> a =EmployeeDao.searchdata(id);
		    if (a.isEmpty()) {
			ob.print(" <script>alert('This Id not exist in table')</script>");  
			ob.print("<a href='Search.html'>Back</a>");  
			}else { 
		 
		    ob.print("<head><link rel='stylesheet' href='style.css'></head>");
			ob.print("");
			ob.print("<body>");
			
			ob.print("<table class='employee-table' border=1 width=75% style='border-collapse:collapse;margin-left:90px;margin-top:100px;'> ");
			ob.print("<tr><th>ID</th><th>NAME</th><th>Email id</th><th>Password</th><th>country</th><th>City</th> <th>Delete</th><th>Edit</th></tr>");
			for(EmployeeBo e : a) {
			    ob.print("<tr><td>"+e.getId()+"</td>"+"<td>"+e.getName()+"</td>"+"<td>"+e.getEmail()+"</td>"+"<td>"+e.getPassword()+"</td>"+"<td>"+e.getCountry()+"</td>"+"<td>"+e.getCity()+"</td><td><a href='Deleteservlet?id="+e.getId()+"' class='delete-link'>delete</a></td><td><a href='EditservletPage?id="+e.getId()+"' class='edit-link'>Edit</a></td></tr>");
			}
			ob.print("</table>");
			}
		    
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
