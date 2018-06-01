package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ansquebean;
import bean.loginbean;
import dao.ansquedao;
import dao.logindao;

/**
 * Servlet implementation class ansquesservlet
 */
@WebServlet("/ansquesservlet")
public class ansquesservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ansquesservlet() {
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
		PrintWriter p = response.getWriter();
		
		String ansque = request.getParameter("ansque");
		String queno = request.getParameter("queno");

		ansquebean a = new ansquebean();
		a.setansque(ansque);
		a.setqueno(queno);

		ansquedao b = new ansquedao();
		String uservalidate = b.authenticateUser(a);

		if(uservalidate.equals("SUCCESS"))
		{
			if(ansque.equals("numerical")) {
				request.setAttribute("queno", a.getqueno());
				request.setAttribute("quedb", a.getquedb());
				request.getRequestDispatcher("/ansnum.jsp").forward(request,response);

			}
			else {
				request.setAttribute("queno", a.getqueno());

				request.setAttribute("quedb", a.getquedb());
				request.setAttribute("Adb", a.getAdb());
				request.setAttribute("Bdb", a.getBdb());
				request.setAttribute("Cdb", a.getCdb());
				request.setAttribute("Ddb", a.getDdb());
				request.getRequestDispatcher("/ansmcq.jsp").forward(request,response);

			}
		}
		else {
			p.println("<script type=\"text/javascript\">");
			p.println("alert('question number not available');");
			p.println("location='./view.jsp';");
			p.println("</script>");
		}
	}

}
