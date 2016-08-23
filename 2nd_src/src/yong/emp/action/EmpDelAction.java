package yong.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.action.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpDelAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDAO dao=new EmpDAO();
		String name=req.getParameter("name");
		int result=dao.empDel(name);
		String msg=result>0?"OK(MVC)":"Fail(MVC)";
		req.setAttribute("msg", msg);
		return "/emp/empMsg.jsp";
	}

}
