package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.mcqbean;
import bean.numsubmitbean;
import dao.mcqsubmitdao;
import dao.numsubmitdao;

/**
 * Servlet implementation class mcqsubmitservlet
 */
@WebServlet("/mcqsubmitservlet")
public class mcqsubmitservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mcqsubmitservlet() {
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
		String queno = request.getParameter("hidden");
		String que = request.getParameter("hidden1");
		String A = request.getParameter("hidden2");
		String B = request.getParameter("hidden3");
		String C = request.getParameter("hidden4");
		String D = request.getParameter("hidden5");
		
		String ans = request.getParameter("options");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		
		mcqbean l = new mcqbean();
		l.setanswer(ans);
		l.setqueno(queno);
		l.setusername(username);
		l.setA(A);
		l.setB(B);
		l.setC(C);
		l.setD(D);

		mcqsubmitdao d = new mcqsubmitdao();
		String uservalidate = d.authenticateUser(l);
		if(uservalidate.equals("SUCCESS"))
		{

			request.setAttribute("errMessage", "Congratulations! Your answer is correct");
			request.getRequestDispatcher("/congo.jsp").forward(request,response);
		
		}
		
		else {
			request.setAttribute("queno", queno);
			request.setAttribute("quedb", que);
			request.setAttribute("hint", l.gethint());
			request.setAttribute("Adb", l.getA());
			request.setAttribute("Bdb", l.getB());
			request.setAttribute("Cdb", l.getC());
			request.setAttribute("Ddb", l.getD());

			request.setAttribute("errMessage", "Try again using a hint");
			request.getRequestDispatcher("/ansmcq.jsp").forward(request,response);

		}
		



	
		
		
		
	}

}
