package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Pragma", "0");//proxies
		
//		String email = (String) request.getParameter("email");
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("id");
		if(email!=null) {
		PrintWriter out = response.getWriter();
		out.println("<h1>Profile</h1>");
		out.println("<p>Welcome "+email+" </p>");
		out.println("<p><a href='dashboard'>Dashboard</a></p>");
		out.println("<p><a href='bills'>Bills</a></p>");
		out.println("<p><a href='logout'>Logout</a></p>");
		}
		else
			 response.sendRedirect("login.html");
	}

}
