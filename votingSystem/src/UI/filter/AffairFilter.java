package UI.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Dbhelp;


@WebFilter("/AffairFilter")
public class AffairFilter implements Filter {

    public AffairFilter() {
        
    }

	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse)response;
		try {
			Dbhelp.beginTransaction();
			chain.doFilter(req, res);
			Dbhelp.commitTransaction();
		} catch (Exception e) {
			try {
				Dbhelp.rollbackTransaction();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				Dbhelp.closeAll(Dbhelp.getConnection(), null, null);
				Dbhelp.removeTransaction();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
