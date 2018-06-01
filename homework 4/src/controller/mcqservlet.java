package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.mcqbean;
import bean.numquebean;
import dao.mcqdao;

/**
 * Servlet implementation class mcqservlet
 */
@WebServlet("/mcqservlet")
public class mcqservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mcqservlet() {
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
		String question = request.getParameter("question");
		String hint = request.getParameter("hint");
		String A = request.getParameter("A");
		String B = request.getParameter("B");
		String C = request.getParameter("C");
		String D = request.getParameter("D");
		String answer = request.getParameter("answer");
		
		mcqbean n = new mcqbean();
		n.setquestion(question);
		n.sethint(hint);
		n.setA(A);
		n.setB(B);
		n.setC(C);
		n.setD(D);
		n.setanswer(answer);
		

		
		mcqdao m = new mcqdao();
		String values = m.storevalues(n);
		
		if(values.equals("SUCCESS")) {
			request.getRequestDispatcher("/Home.jsp").forward(request,response);

		}
		else {
			request.setAttribute("errMessage", values);
			request.getRequestDispatcher("/mcq.jsp").forward(request,response);
		
		}
	}


	

}
