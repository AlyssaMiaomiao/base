package UI.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;


public class IsLoginFilter implements Filter {

 
    public IsLoginFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(((HttpServletRequest)request).getSession().getAttribute(User.SESSION_NAME)!=null);
		if (((HttpServletRequest)request).getSession().getAttribute(User.SESSION_NAME)!=null) {
			
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/jsp/login.jsp");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
