package dmi.ris.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		request.getSession().setAttribute("password", "Moj veoma tajni password");
		if (request.getParameter("username")!=null) {
			username = request.getParameter("username");
			Cookie cookie = new Cookie("mojprvicookie", username);
			cookie.setMaxAge(60); //60s je validan cookie
			response.addCookie(cookie);		
		}else {
	       Cookie [] cookies = request.getCookies();
	       if (cookies != null) {
	        for (Cookie c : cookies) {
	    	      if (c.getName().equalsIgnoreCase("mojprvicookie")) {
	    		   username = c.getValue();
	    		   break;
	    	       }
	         }
	       }
		}
	
		PrintWriter out = response.getWriter();
		out.append("<html>");
		out.append("<body>");
		out.append("<h3>Ovo je primer stranice koju je generisao Servlet </h3>");
		out.append("Hello ");
		out.append(username);
		out.append("Moj password");
		out.append(request.getSession().getAttribute("password").toString());
		out.append("<br>");
		out.append("</body>");
		out.append("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Hello "+request.getParameter("name"));
	}

}
