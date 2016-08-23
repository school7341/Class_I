package yong.emp.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.action.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpSearchAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name"); 
		
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpDTO> arr = dao.empSearch(name);
		req.setAttribute("dtos", arr);
		//req.setAttribute("name", name);
		return "/emp/empSearch.jsp";
	}

}
