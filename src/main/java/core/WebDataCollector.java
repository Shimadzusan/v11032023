package core;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WebDataCollector")
public class WebDataCollector extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int counter = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.counter++;
		System.out.println("..simple counter: " + counter);
		System.out.println("I am servlet_one ...method GET");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		String data = request.getParameter("group");				//income data from js
		
		response.getWriter().write(data + " myy note from web..");	//send data to js	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.counter++;
		System.out.println("..simple counter: " + counter);
		System.out.println("I am servlet_one ...method POST");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		String data = request.getParameter("name");
		response.getWriter().write(data + " my note from web ...");
		String data2 = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		System.out.println("you request: " + data2);
	}

}
