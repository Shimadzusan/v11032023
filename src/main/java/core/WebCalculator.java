package core;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


/**
 * Servlet implementation class WebCalculator
 */
@WebServlet("/WebCalculator")
public class WebCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int counter = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.counter++;
		System.out.println("..simple counter: " + counter);
		System.out.println("I am servlet_one ...method GET");

		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");

		response.setContentType("text/plain");
		String data = request.getParameter("group");				//income data from js
		
		response.getWriter().write(data + " myy note from web..");	//send data to js	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.counter++;
		System.out.println("..simple counter: " + counter);
		System.out.println("I am servlet_two calculator ...method POST");
		
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");

		response.setContentType("text/plain");
		//String data = request.getParameter("name");
		
		String clientData = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		System.out.println("you request: " + clientData);
		try {
			Class.forName("org.json.JSONObject");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write(Data.getData(clientData));
	}

}
