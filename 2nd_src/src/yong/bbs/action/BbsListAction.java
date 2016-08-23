package yong.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.action.CommandHandler;
import java.util.*;
import yong.bbs.*;

public class BbsListAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BbsDAO dao=new BbsDAO();
		
		int total_cnt=dao.getTotalCnt();
		int list_size=10;
		int page_size=5;
		
		String cp_s=req.getParameter("cp");
		if(cp_s==null||cp_s.equals("")){
			cp_s="1";
		}
		int cp=Integer.parseInt(cp_s);
		
		String pageStr=yong.page.YongPageModuel.makePage(total_cnt, list_size, page_size, cp, "bbsList.yong");
		req.setAttribute("pageStr",pageStr);
		
		ArrayList<BbsDTO> arr=dao.bbsList(cp,list_size);
		req.setAttribute("lists", arr);
		return "/jsp_bbs/jspList.jsp";
	}

}
