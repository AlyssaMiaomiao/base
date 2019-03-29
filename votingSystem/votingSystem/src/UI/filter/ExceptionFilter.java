package UI.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;


@WebFilter("/MyException")
public class ExceptionFilter implements Filter {
	
    public ExceptionFilter() {
        
    }

	
	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			Logger logger=Logger.getLogger(ExceptionFilter.class.getName());
			logger.info(e.getMessage());
			//日志
			//错误页面
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
