package UI.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Option;
import bean.Subject;
import service.RecordService;
import service.SubjectService;
import service.impl.RecordServiceImpl;
import service.impl.SubjectServiceImpl;


public class ShowVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ShowVoteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectId=request.getParameter("id");
		try {
			SubjectService sservice=new SubjectServiceImpl();
			Subject subject=sservice.getSubjectById(Long.parseLong(subjectId));
			request.setAttribute("subject", subject);
			request.getRequestDispatcher("jsp/vote.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
