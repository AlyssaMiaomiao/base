package UI.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Option;
import bean.Subject;
import bean.User;
import service.SubjectService;
import service.exception.RuleException;
import service.impl.SubjectServiceImpl;


public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddSubjectServlet() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String title=request.getParameter("title");
	String number=request.getParameter("number");
	String[] options=request.getParameterValues("options");
	Subject subject=new Subject();
	subject.setTitle(title);
	subject.setNumber(Integer.parseInt(number));
		for (String data : options) {
			Option option=new Option();
			option.setContent(data);
			subject.getOptions().add(option);
		}
		
		SubjectService suService;
		try {
			suService = new SubjectServiceImpl();
			suService.addSubject(subject, (User)request.getSession().getAttribute(User.SESSION_NAME));
			response.sendRedirect(request.getContextPath()+"/jsp/list.jsp");
		}catch (RuleException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(request.getContextPath()+"/jsp/register.jsp");
		} 
		catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
