package yong.emp.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.action.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpUpdateAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idx=Integer.parseInt(req.getParameter("idx")); 
		String name=(String)req.getParameter("name");
		//EmpDTO dto = new EmpDTO();
		EmpDAO dao = new EmpDAO();
		EmpDTO arr = dao.updateInfo(idx);
		req.setAttribute("dtoss", arr);
		
		return "/emp/empUpdate.jsp";
	}
}
