package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.numquebean;
import dao.numquedao;

/**
 * Servlet implementation class numqueservlet
 */
@WebServlet("/numqueservlet")
public class numqueservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public numqueservlet() {
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
		String answer = request.getParameter("answer");
		
		numquebean n = new numquebean();
		n.setquestion(question);
		n.sethint(hint);
		n.setanswer(answer);
		
		numquedao m = new numquedao();
		String values = m.storevalues(n);
		
		if(values.equals("SUCCESS")) {
			request.getRequestDispatcher("/Home.jsp").forward(request,response);

		}
		else {
			request.setAttribute("errMessage", values);
			request.getRequestDispatcher("/numque.jsp").forward(request,response);
		
		}
	}

}
