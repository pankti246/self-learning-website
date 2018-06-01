package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.loginbean;
import dao.logindao;

/**
 * Servlet implementation class editservlet
 */
@WebServlet("/editservlet")
public class editservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editservlet() {
        super();
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
		// TODO Auto-generated method stub
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("username");
		editbean l = new editbean();
		l.setfirstname(firstname);
		l.setlastname(lastname);
		l.setpassword(password);
		l.setusername(username);
		editdao d = new editdao();
		
		String uservalidate = d.authenticateUser(l);
		
		if(uservalidate.equals("SUCCESS"))
		{
			request.getRequestDispatcher("/Home.jsp").forward(request,response);
		}
		else
		{
			request.setAttribute("errMessage", uservalidate);
			request.getRequestDispatcher("/editprofile.jsp").forward(request,response);
		}


		
	}

}
