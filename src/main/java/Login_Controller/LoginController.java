package Login_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login_Model.DAOService;
import Login_Model.DAOServiceImpl;

@WebServlet("/verifylogins")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginController() {
        super();
            }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOService service = new DAOServiceImpl();
		service.connectDB();
		
		boolean status = service.verifyCredentials(email, password);
		if(status==true) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			
			session.setMaxInactiveInterval(10);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_create_registration.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("error", "Invalid username/password");
			
			RequestDispatcher rd = request.getRequestDispatcher("Login_app.jsp");
			rd.forward(request, response);
		}
	}

}
