package yong.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.action.CommandHandler;
import yong.bbs.BbsDAO;
import yong.bbs.BbsDTO;

public class BbsWriteAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String writer=req.getParameter("writer");
		String pwd=req.getParameter("pwd");
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		BbsDTO bdto=new BbsDTO(writer, pwd, subject, content);
		BbsDAO bdao = null;
		try {
			bdao = new BbsDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result=bdao.Bbswrite(bdto);
		String msg=result>0?"게시글 작성 성공":"게시글 작성 실패";
		req.setAttribute("msg", msg);
		return "/jsp_bbs/bbsMsg.jsp";
	}

}
