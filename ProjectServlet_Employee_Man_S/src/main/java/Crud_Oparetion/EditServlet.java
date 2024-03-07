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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     PrintWriter pw=response.getWriter();
	     
	     String id=request.getParameter("id");
	     int id1=Integer.parseInt(id);
	     String name=request.getParameter("name");
	     String email=request.getParameter("email");
	     String password=request.getParameter("password");
	     String country=request.getParameter("country");
	     String city=request.getParameter("city");
	     
	     EmployeeBo ob=new EmployeeBo();
	     ob.setId(id1);
	     ob.setName(name);
	     ob.setEmail(email);
	     ob.setPassword(password);
	     ob.setCountry(country);
	     ob.setCity(city);
	     
	     int result=EmployeeDao.update(ob);
	     if (result>0) {
			response.sendRedirect("DataFetch");
		} else {
			pw.print("Sorry! something want wrong..");
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
