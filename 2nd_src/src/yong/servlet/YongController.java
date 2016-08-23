
package yong.servlet;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.action.CommandHandler;
import yong.action.ContentAction;
import yong.action.ListAction;
import yong.action.WriteAction;

public class YongController extends HttpServlet{

	private Map<String, CommandHandler> commandMap;
	
	public YongController() {
		commandMap=new HashMap<String, CommandHandler>();
	}
	@Override
	public void init() throws ServletException {
		Properties pr=new Properties();
		String fullPath=this.getServletContext().getRealPath("/WEB-INF/yongConfig.properties");
		try {
			FileInputStream fis = new FileInputStream(fullPath);
			pr.load(fis);
			fis.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		Iterator keys = pr.keySet().iterator();
		while(keys.hasNext()){
			String key=(String)keys.next();
			String value=pr.getProperty(key);
			try{
			Class valueClass=Class.forName(value);
			Object obj = valueClass.newInstance();
			commandMap.put(key, (CommandHandler)obj);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		userProcess(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		userProcess(req,resp);
	}
	
	
	protected void userProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//http 요청 받음
		//String type=req.getParameter("type");
		String type=req.getRequestURI();//주소 받음
		if (type.indexOf(req.getContextPath())==0){
			type=type.substring(req.getContextPath().length());
		}
		//요청 분석
		String goPage=null;
		String result=null;
		//CommandHandler ch=null;
		CommandHandler ch=commandMap.get(type);
		//if(type.equals("list")){
			//요청에 따른 기능수행
			//result="Execute List Result MVC Pattern";
			//goPage="/list.jsp";
			//ch=new ListAction();
		//}else if(type.equals("write")){
			//요청에 따른 기능수행
			//result="Execute Write Result MVC Pattern";
			//goPage="/write.jsp";
			//ch=new WriteAction();
		//}else if(type.equals("content")){
			//요청에 따른 기능수행
			//result="Execute Content Result MVC Pattern";
			//goPage="/content.jsp";
			//ch=new ContentAction();
		//}
		
		//데이터 저장
		//req.setAttribute("result", result);
		//페이지 이동
		//RequestDispatcher dis = req.getRequestDispatcher(goPage);
		RequestDispatcher dis = req.getRequestDispatcher(ch.process(req, resp));
		dis.forward(req, resp);//전가방식
	}
}
