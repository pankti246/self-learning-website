package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ansquebean;
import bean.numsubmitbean;
import dao.ansquedao;
import dao.numsubmitdao;

/**
 * Servlet implementation class numsubmitservlet
 */
@WebServlet("/numsubmitservlet")
public class numsubmitservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public numsubmitservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String queno = request.getParameter("hidden");
		String que = request.getParameter("hidden1");
		System.out.println("queno");

		System.out.println(queno);

		String ans = request.getParameter("ans");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		numsubmitbean l = new numsubmitbean();
		l.setans(ans);
		l.setqueno(queno);
		l.setusername(username);
		System.out.println('2');

		numsubmitdao d = new numsubmitdao();
		String uservalidate = d.authenticateUser(l);
		System.out.println('3');

		if(uservalidate.equals("SUCCESS"))
		{
			System.out.println('4');

			request.setAttribute("errMessage", "Congratulations! Your answer is correct");
			request.getRequestDispatcher("/congo.jsp").forward(request,response);
		
		}
		
		else {
			request.setAttribute("queno", queno);
			request.setAttribute("quedb", que);
			request.setAttribute("hint", l.gethint());
			request.setAttribute("errMessage", "Try again using a hint");
			request.getRequestDispatcher("/ansnum.jsp").forward(request,response);

		}
		



	}

}
