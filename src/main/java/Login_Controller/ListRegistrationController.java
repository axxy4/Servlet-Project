package Login_Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login_Model.DAOService;
import Login_Model.DAOServiceImpl;

@WebServlet("/listallll")
public class ListRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ListRegistrationController() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		
		if(session.getAttribute("email")!=null) {
		DAOService service = new DAOServiceImpl();
		service.connectDB();
		ResultSet result = service.listAllRegistrations();
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
		rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);
		}
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
