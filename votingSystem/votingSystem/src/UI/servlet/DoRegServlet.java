package UI.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;
import service.exception.RuleException;
import service.impl.UserServiceImpl;

@WebServlet("/DoRegServlet")
public class DoRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DoRegServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String confirmPwd=request.getParameter("confirmPwd");
		UserService userService=new UserServiceImpl();
		User user =new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setConfirmPwd(confirmPwd);
		try {
			userService.register(user);
			response.sendRedirect("jsp/login.jsp");
		} catch (RuleException e) {
			// TODO: handle exception
			request.setAttribute("user", user);
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
