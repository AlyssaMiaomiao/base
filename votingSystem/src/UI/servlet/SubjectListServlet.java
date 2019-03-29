package UI.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import service.SubjectService;
import service.impl.SubjectServiceImpl;

public class SubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SubjectListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SubjectService service=new SubjectServiceImpl();
			List<Subject> list=service.getSubjectList();
			request.setAttribute("subjects", list);
			request.getRequestDispatcher("jsp/list.jsp").forward(request, response);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
