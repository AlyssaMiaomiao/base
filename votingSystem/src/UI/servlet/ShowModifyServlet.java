package UI.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.User;
import service.SubjectService;
import service.impl.SubjectServiceImpl;


public class ShowModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShowModifyServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute(User.SESSION_NAME);
		try {
			SubjectService service=new SubjectServiceImpl();
			List<Subject> list=service.getSubjectByUserId(user.getId());
			request.setAttribute("subjects",list);
			request.getRequestDispatcher("jsp/modify.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
