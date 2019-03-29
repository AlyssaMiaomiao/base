package UI.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Option;
import bean.Subject;
import bean.User;
import service.SubjectService;
import service.exception.RuleException;
import service.impl.SubjectServiceImpl;
import util.DateFormatToView;


public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddSubjectServlet() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String subjectId=request.getParameter("id");
		if (subjectId==null||"".equals(subjectId)) {
			addSubject(request, response);
		}else {
			modifyVote(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void addSubject(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String title=request.getParameter("title");
		String number=request.getParameter("voteType");
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
				response.sendRedirect("subjectList");
			}catch (RuleException e) {
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("jsp/add.jsp").forward(request, response);;
			} 
			catch (Exception e){
				e.printStackTrace();
			}
			
	}
	private void modifyVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectId=request.getParameter("id");
		String title=request.getParameter("title");
		String number=request.getParameter("voteType");
		String[] options=request.getParameterValues("options");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		Subject subject=new Subject();
		subject.setId(Long.parseLong(subjectId));
		subject.setTitle(title);
		subject.setNumber(Integer.parseInt(number));
		
			for (String data : options) {
				Option option=new Option();
				option.setContent(data);
				
				subject.getOptions().add(option);
			}
		SubjectService suService;
			try {
				subject.setStartTime(DateFormatToView.toDbDate(startTime));
				subject.setEndTime(DateFormatToView.toDbDate(endTime));
				suService = new SubjectServiceImpl();
				suService.updateVote(subject,(User)request.getSession().getAttribute(User.SESSION_NAME));
				request.getRequestDispatcher("subjectList").forward(request, response);
			}catch (RuleException e) {
				request.setAttribute("msg", e.getMessage());
				request.getRequestDispatcher("jsp/add.jsp?id="+subjectId).forward(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}
