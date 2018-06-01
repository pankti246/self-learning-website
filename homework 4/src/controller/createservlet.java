package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.clearbean;
import dao.cleardao;

/**
 * Servlet implementation class createservlet
 */
@WebServlet("/createservlet")
public class createservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		clearbean n = new clearbean();
		n.setusername(username);
		
		cleardao d = new cleardao();
		String uservalidate = d.storevalues(n);
		if(uservalidate.equals("SUCCESS"))
		{

			request.setAttribute("errMessage", "cleared");
			request.getRequestDispatcher("/view.jsp").forward(request,response);
		
		}
		
		else {
			request.setAttribute("errMessage", "not cleared");
			request.getRequestDispatcher("/view.jsp").forward(request,response);

					}
		



	
		
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


}
}