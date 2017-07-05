package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



public class RegServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Vector<User> users;

	public static Vector<User> getUsers() {
		return users;
	}

	@Override
	public void init() throws ServletException {
		super.init(); // To change body of generated methods, choose Tools |
						// Templates.
		users = new Vector<>();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String statusStr = request.getParameter("status");
		int status = new Integer(statusStr).intValue();
		String retval = "fail";
		User userData = null;
		if (users.size() > 0) {
			for (User user : users) {
				if (user.getMail().equals(mail) && user.getPass().equals(pass)) {
					user.setStatus(status);
					System.out.println("correct");
					retval = "success";
					userData = user;
					break;
				}
			}
		} else {
			System.out.println("not registered");
			retval = "not registered";
		}
		LoginData loginData = new LoginData(retval, userData);
		Gson gson = new Gson();
		String data = gson.toJson(loginData);
		System.out.println(data);
		out.print(data);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("regRecieve");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String retval = "fail";
		System.out.println(request.getParameterMap());
		System.out.println(mail);
		System.out.println(name);
		System.out.println(pass);

		if (users.size() > 0) {
			if (mail != null) {
				for (User user : users) {

					if (!user.getMail().equals(mail)) {
						User newUser = new User(name, mail, pass, 0);
						users.add(newUser);
						System.out.println("added");
						retval = "success";
						break;
					}
				}
			}
		} else {
			User newUser = new User(name, mail, pass, 0);
			users.add(newUser);
			System.out.println("added");
			retval = "success";
		}
		String x = "{\"status\" : \"" + retval + "\"}";
		System.out.println(x);
		out.print(x);
	}

}
