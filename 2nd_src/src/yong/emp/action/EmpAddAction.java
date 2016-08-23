package yong.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.action.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpAddAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name"); 
		String email=req.getParameter("email");
		String dept=req.getParameter("dept");
		EmpDTO dto=new EmpDTO(0, name, email, dept);
		EmpDAO dao=new EmpDAO();
		int result=dao.empAdd(dto);
		String msg=result>0?"OK(MVC)":"Fail(MVC)";
		req.setAttribute("msg", msg);
		return "/emp/empMsg.jsp";
	}

}
