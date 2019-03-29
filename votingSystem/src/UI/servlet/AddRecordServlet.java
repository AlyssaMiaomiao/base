package UI.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.RecordService;
import service.SubjectService;
import service.exception.RuleException;
import service.impl.RecordServiceImpl;
import service.impl.SubjectServiceImpl;
import sun.print.resources.serviceui;


public class AddRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String subjectId=request.getParameter("subjectId");
	String[] options=request.getParameterValues("options");
	System.out.println(options[0]);
	HttpSession session=request.getSession();
	User user=(User)session.getAttribute(User.SESSION_NAME);
		try {
			RecordService rservice=new RecordServiceImpl();
			rservice.addRecord(Long.parseLong(subjectId),user.getId(), options);
			request.getRequestDispatcher("subjectList").forward(request, response);
		} catch (RuleException re) {
			SubjectService sservice;
			try {
				sservice = new SubjectServiceImpl();
				request.setAttribute("msg", re.getMessage());
				request.setAttribute("subject",sservice.getSubjectById(Long.parseLong(subjectId)));
				request.getRequestDispatcher("showVote").forward(request, response);;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
