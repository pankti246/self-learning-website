package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class updateservlet
 */
@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateservlet() {
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
		String passwordold = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("username");
		updatebean l = new updatebean();
		l.setpasswordold(passwordold);
		l.setnewpassword(newpassword);

		l.setusername(username);
		updatedao d = new updatedao();
		
		String uservalidate = d.authenticateUser(l);
		
		if(uservalidate.equals("SUCCESS"))
		{
			request.getRequestDispatcher("/Home.jsp").forward(request,response);
		}
		else
		{
			request.setAttribute("errMessage", uservalidate);
			request.getRequestDispatcher("/updatepassword.jsp").forward(request,response);
		}


		
	}

}
