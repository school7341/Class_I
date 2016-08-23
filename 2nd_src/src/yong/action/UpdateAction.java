package yong.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String result="the result is Update that applied by command pattern. after setting config file.";
		req.setAttribute("result", result);
		return "/update.jsp";
	}

}
