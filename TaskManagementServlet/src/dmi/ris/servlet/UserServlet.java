package dmi.ris.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dim.ris.controller.JPAUtil;
import dim.ris.controller.UserController;
import dim.ris.model.Role;
import dim.ris.model.User;
import dmi.ris.utility.BcryptUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   User u = UserController.getLastUser();
		response.getWriter().append("Poslednji korisnik je ").append(u.getName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  User u = new User();
	  u.setName(request.getParameter("name"));
	  u.setUsername(request.getParameter("username"));
	  u.setPassword(BcryptUtil.hash(request.getParameter("password")));
	  int idRole = Integer.parseInt(request.getParameter("role"));
	  Role r = UserController.getRole(idRole);
	  u.setRole(r);
	  boolean ok = UserController.register(u);
	  if (ok) {
		  response.getWriter().append("Uspesno je registrovan korisnik");
	  }else {
		  response.getWriter().append("Doslo je do greske");
	  }
	  
	}

}
