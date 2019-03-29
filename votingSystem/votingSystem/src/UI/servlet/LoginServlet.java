package UI.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import service.UserService;
import service.exception.RuleException;
import service.impl.UserServiceImpl;
import util.Md5Class;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String remember=request.getParameter("remember");
		UserService userService=new UserServiceImpl();
		User user=new User();
		user.setName(name);
		user.setPwd(pwd);
		try {
			userService.login(user);
			HttpSession session=request.getSession();
			session.setAttribute(User.SESSION_NAME, user);
			if (remember!=null) {
				Cookie cookie=new Cookie(User.SESSION_NAME, user.getId().toString());
				cookie.setMaxAge(10*24*60*60);
				response.addCookie(cookie);
			}
			response.sendRedirect("jsp/list.jsp");
		}catch (RuleException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", user);
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
