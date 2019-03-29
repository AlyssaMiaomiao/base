package UI.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;


public class LoginOutListener implements HttpSessionListener {

  
    public LoginOutListener() {
        // TODO Auto-generated constructor stub
    }

	
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	HttpSession session = arg0.getSession();
		User user = (User)session.getAttribute(User.SESSION_NAME);
       System.out.println("你的session销毁啦");
		UserService userService = new UserServiceImpl();
		userService.outline(user);
    }
	
}
