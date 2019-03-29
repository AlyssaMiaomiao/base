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

import util.MyRequest;

@WebFilter("/EncodeFilter")
public class EncodeFilter implements Filter {
	private String encode=null;
    public EncodeFilter() {
        
    }

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest)request;
		request.setCharacterEncoding(this.encode);
		response.setCharacterEncoding(this.encode);
		if("GET".equals(req.getMethod().toUpperCase())) {
			MyRequest mr=new MyRequest(req);
			mr.setEncode(encode);
			request=mr;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.encode=fConfig.getInitParameter("encode");
	}

}
