/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud
 */
public class ChatServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Vector<ChatMsg> messages;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        messages = new Vector<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        Data myData= new Data(messages, RegServlet.getUsers());
        String data = gson.toJson(myData);
        //System.out.println(data);
        out.print(data);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("recieve");
        String name = request.getParameter("name");
        String msg = request.getParameter("msg");
        String time = request.getParameter("time");
        Date  date = new Date(new Long(time));
        
        if (name != null && msg != null && time != null) {
            ChatMsg chat = new ChatMsg(name, msg, date.toString());
            messages.add(chat);
            System.out.println("done");
        }
    }

}
