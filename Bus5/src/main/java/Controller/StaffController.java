package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;


import DAO.StaffDAO;
import Model.Staffs;

/**
 * Servlet implementation class BookingController
 */
@WebServlet ("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action="", forward="";
	private static String LIST ="ListStaff.jsp";
	private static String VIEW ="ViewBooking.jsp";
	private StaffDAO dao;
	private int staff_id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        dao = new StaffDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");

		
		//Complete action for list order
		// for all order have been inserted
		if(action.equalsIgnoreCase("list")) {
			forward = LIST;
			request.setAttribute("staffs", StaffDAO.getStaffs());
		}
		
		//Complete action for delete driver
		if(action.equalsIgnoreCase("delete")) {
			forward = LIST;
			int staff_id = Integer.parseInt(request.getParameter("staff_id"));
			dao.deleteStaff(staff_id);
			request.setAttribute("staffs", StaffDAO.getStaffs());
			RequestDispatcher view = request.getRequestDispatcher("ListStaff.jsp");
			view.forward(request, response);
		}

		//forward the request
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			Staffs staff = new Staffs();
		
			//retrieve from JSP and set values
			staff.setStaff_name(request.getParameter("staff_name"));
			staff.setStaff_email(request.getParameter("staff_email"));
			staff.setStaff_password(request.getParameter("staff_password"));
			staff.setStaff_address(request.getParameter("staff_address"));
			staff.setStaff_phoneno(request.getParameter("staff_phoneno"));
			staff.setStaff_icno(request.getParameter("staff_icno"));
			
			//invoke method addBooking() in BookingsDAO
			String staff_id = request.getParameter("staff_id");
			
			if(staff_id == null || staff_id.isEmpty()) {
				dao.addStaff(staff);
			}
			
			//set attribute to a servlet request and call getCustomerBookings() method
			request.setAttribute("staffs", StaffDAO.getStaffs());
			
			
			//forward the request to listOrder.jsp
			forward = LIST;
			RequestDispatcher LIST = request.getRequestDispatcher("ListStaff.jsp");
			LIST.forward(request, response);
		
			
	}

}
