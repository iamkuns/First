package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DBConnection;
import com.dao.UserDao;

@WebServlet("/SearchSlotcontroller")
public class SearchSlotcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SearchSlotcontroller() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter out=response.getWriter();	
HttpSession ss=request.getSession();
String name=(String) ss.getAttribute("name");
String vehicleno=(String) ss.getAttribute("vehicleno");
String slotname=request.getParameter("slotname");
String address=request.getParameter("address");
String area=request.getParameter("area");
String city=request.getParameter("city");
String state=request.getParameter("state");
String date=request.getParameter("date");
String time=request.getParameter("time");

UserDao dao=new UserDao();

try {
	if(dao.alreadyBooked(date, time))
	{
		out.println("<script type=\"text/javascript\">");
		out.println("alert('this slot already booked')");
		out.println("location='Search.jsp';");
		out.println("</script>");
		
	}
	else {
		
		String sql = "insert into tbl_booking values(null,?,?,?,?,?,?,?,?,?)";

		Connection con = DBConnection.getConnection();
		PreparedStatement ps=null;
		
			ps = con.prepareStatement(sql);

			
			ps.setString(1, slotname);
			ps.setString(2, address);
			ps.setString(3, area);
			ps.setString(4, city);
			ps.setString(5, state);
			ps.setString(6, name);
			ps.setString(7, vehicleno);
			ps.setString(8, date);
			ps.setString(9, time);
			
			int index = ps.executeUpdate();

			if (index > 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Booking Confirmed')");
				out.println("location='UserHome.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Booking not confirmed')");
				out.println("location='UserHome.jsp';");
				out.println("</script>");
			}
		
		
	}
} catch (SQLException e1) {
	
	e1.printStackTrace();
}


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
