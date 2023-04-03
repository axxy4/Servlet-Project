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

@WebServlet("/saveRegs")
public class SaveRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveRegistrationController() {
        super();
           }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_create_registration.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		
		try {
			if(session.getAttribute("email")!=null){
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOService service = new DAOServiceImpl();
		service.connectDB();
		service.saveregistration(name, city, email, mobile);
		
		request.setAttribute("msg", "Record is saved");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_create_registration.jsp");
		rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Login_app.jsp");
			rd.forward(request, response);
		}
	}
		catch(Exception e) {
			e.printStackTrace();
			
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);
		}
		
	}
		

}
