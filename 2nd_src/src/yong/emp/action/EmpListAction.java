package yong.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.action.CommandHandler;

import java.util.*;
import yong.emp.model.*;
public class EmpListAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpDTO> arr = dao.empList();
		req.setAttribute("dtos", arr);
		
		return "/emp/empList.jsp";
	}

}
