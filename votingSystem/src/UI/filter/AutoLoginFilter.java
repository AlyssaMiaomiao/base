package UI.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import bean.User;
import dao.daoFactory;
import service.UserService;
import service.impl.UserServiceImpl;

@WebFilter("/AutoLoginFilter")
public class AutoLoginFilter implements Filter {

   
    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest	hrequest=((HttpServletRequest) request);
		HttpServletResponse hresponse=(HttpServletResponse) response;	
		HttpSession session=hrequest.getSession();
		Cookie[] cookies=hrequest.getCookies();
		if (session.getAttribute(User.SESSION_NAME)==null) {
			if (cookies!=null) {
				for (Cookie cookie : cookies) {
					if (User.SESSION_NAME.equals(cookie.getName())) {
						Long id=Long.parseLong(cookie.getValue());
						UserService userService=new UserServiceImpl();
						try {
							User user=userService.getUserById(id);
							session.setAttribute(User.SESSION_NAME, user);
						} catch (Exception e) {
							e.printStackTrace();
						}
			
					}
				}
				chain.doFilter(hrequest, hresponse);
			}
		
		}else {
			chain.doFilter(hrequest, hresponse);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
