package dmi.ris.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dim.ris.model.User;

/**
 * Servlet Filter implementation class EmployeeAccessRestrictionFilter
 */
@WebFilter({"/UserServlet", "/pages/registerUser.jsp"})
public class EmployeeAccessRestrictionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EmployeeAccessRestrictionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		boolean failed = false;
		
		try {
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			User user = (User)httpRequest.getSession().getAttribute("logedUser");
			if(httpRequest.getMethod().equalsIgnoreCase("post") && user.getRole().getName().equalsIgnoreCase("employee")) {
				throw new Exception();
			}
		}
		catch(Exception e) {
			failed = true;
			request.getRequestDispatcher("/pages/access-error.jsp").forward(request, response);
		}
		
		if(!failed) {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
