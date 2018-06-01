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
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
/*		String radio = request.getParameter("supplier_or_consumer");
*/		
		
		loginbean l = new loginbean();
		l.setusername(username);
		l.setpassword(password);
/*		l.setradio(radio);
*/		
		
		logindao d = new logindao();
		HttpSession session = request.getSession();
		String uservalidate = d.authenticateUser(l);
		
		if(uservalidate.equals("SUCCESS"))
		{
			session.setAttribute("username",username);
			session.setAttribute("password", password);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/Home.jsp").forward(request,response);
			/*if(radio.equals("Supplier")) {
				session.setAttribute("type", radio);
				request.getRequestDispatcher("/Home.jsp").forward(request,response);
			}
			else {
				session.setAttribute("type",radio);
				request.getRequestDispatcher("/Home2.jsp").forward(request,response);
			}*/
			
		}
		else
		{
			request.setAttribute("errMessage", uservalidate);
			request.getRequestDispatcher("/Login.jsp").forward(request,response);
		}
	}
}


