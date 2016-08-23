package yong.bbs;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class BbsDAO{
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public BbsDAO() throws Exception{
      System.out.println("BbsDAO생성자 호출됨!");
      dbConnect();
    }
    /**DB연결부분*/
	public void dbConnect(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:orcl2";
			String user="scott";
			String pwd="1234";
			conn=DriverManager.getConnection(url,user,pwd);	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    /*ref값 구하기 */
    public int getMaxref(){
      try{
    	  
          String sql="select max(ref) from jsp_bbs";
          ps=conn.prepareStatement(sql);
          rs=ps.executeQuery();
          int count=0;
          if(rs.next()){
        	  count=rs.getInt(1);
          }
          
          return count;
      }catch(Exception e){
        e.printStackTrace();
        return -1;
      }finally{
        try{
          if(ps!=null)ps.close();
          
        }catch(Exception e2){}
      }
    }

	
	    /*글쓰기 관련 메서드 */
    public int Bbswrite(BbsDTO bdto){
		try {
			conn=yong.db.YongDB.getConn();
			String sql="insert into jsp_bbs values(jsp_bbs_idx.nextval, ?, ?, ?, ?, sysdate, 0, 0, 0, 0)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, bdto.getWriter());
			ps.setString(2, bdto.getPwd());
			ps.setString(3, bdto.getSubject());
			ps.setString(4, bdto.getContent());
			int count=ps.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	    /*순번업데이트 관련 메서드 */
	    public void updateSun(int ref,int sunbun){
	      try{
	    	  
	    	  String sql="update jsp_bbs set sunbun=sunbun+1 where ref=? and sunbun>=?";
	          ps=conn.prepareStatement(sql);
	          ps.setInt(1, ref);
	          ps.setInt(2, sunbun);
	          ps.executeUpdate();
	          
	      }catch(Exception e){
	        e.printStackTrace();
	      }finally{
	        try{
	          if(ps!=null)ps.close();
	        }catch(Exception e2){}
	      }
	    }

	    /*답변글쓰기 관련 메서드 */
	    public int bbsReWrite(BbsDTO dto){
	      try{
	    	  conn=yong.db.YongDB.getConn();
	    	  updateSun(dto.getRef(),dto.getSunbun()+1);
	    	  String sql="insert into jsp_bbs values (jsp_bbs_idx.nextval,?,?,?,?,sysdate,0,?,?,?)";
	          ps=conn.prepareStatement(sql);
	          ps.setString(1, dto.getWriter());
	          ps.setString(2, dto.getPwd());
	          ps.setString(3, dto.getSubject());
	          ps.setString(4, dto.getContent());
	          ps.setInt(5, dto.getRef());
	          ps.setInt(6, dto.getLev()+1);
	          ps.setInt(7, dto.getSunbun()+1);
	          int count=ps.executeUpdate();
	          return count;
	      }catch(Exception e){
	        e.printStackTrace();
	        return -1;
	      }finally{
	        try{
	          if(ps!=null)ps.close();
	          if(conn!=null)conn.close();
	        }catch(Exception e2){}
	      }
	    }
	    /*목록관련 메서드*/
	    public ArrayList<BbsDTO> bbsList(int cp, int ls){
	        try{
	        	conn=yong.db.YongDB.getConn();
	          //String sql="select * from jsp_bbs order by idx desc";
	          ////////////////////////////////////////////
	          String sql="select * from (select rownum as rnum,a.* from (select * from jsp_bbs order by ref desc,sunbun asc)a)b where rnum>=("+cp+"-1)*"+ls+"+1 and rnum<="+cp+"*"+ls;
	          ////////////////////////////////////////////
	          ps=conn.prepareStatement(sql);
	          rs=ps.executeQuery();

	          ArrayList<BbsDTO> arr=new ArrayList<BbsDTO>();
	          while(rs.next()){
	            int idx=rs.getInt("idx");
	            String writer=rs.getString("writer");
	            String pwd=rs.getString("pwd");
	            String subject=rs.getString("subject");
	            String content=rs.getString("Content");
	            java.sql.Date writedate=rs.getDate("writedate");
	            int readnum=rs.getInt("readnum");
	            int ref=rs.getInt("ref");
	            int lev=rs.getInt("lev");
	            int sunbun=rs.getInt("sunbun");
	            BbsDTO dto=new  BbsDTO(idx, writer, pwd, subject, content, writedate, readnum, ref, lev, sunbun);
	            arr.add(dto);
	          }
	          return arr;
	        }catch(Exception e){
	          e.printStackTrace();
	          return null;
	        }finally{
	          try{
	            if(rs!=null)rs.close();
	            if(ps!=null)ps.close();
	            if(conn!=null)conn.close();
	          }catch(Exception e2){}
	        }
	    }
	    /*본문관련 메서드*/
	    public BbsDTO bbsContent(int idx){
	      try{
	    	  conn=yong.db.YongDB.getConn();
	          String sql="select * from jsp_bbs where idx=?";
	          ps=conn.prepareStatement(sql);
	          ps.setInt(1, idx);
	          rs=ps.executeQuery();
	          
	          BbsDTO dto=null;
	          if(rs.next()){
	            String writer=rs.getString("writer");
	            String pwd=rs.getString("pwd");
	            String subject=rs.getString("subject");
	            String content=rs.getString("content");
	            java.sql.Date writedate=rs.getDate("writedate");
	            int readnum=rs.getInt("readnum")+1;
	            int ref=rs.getInt("ref");
	            int lev=rs.getInt("lev");
	            int sunbun=rs.getInt("sunbun");
	            String sql2="update jsp_bbs set readnum=? where idx=?";
		          ps=conn.prepareStatement(sql2);
		          ps.setInt(1, readnum);
		          ps.setInt(2, idx);
		          rs=ps.executeQuery();
	            dto= new BbsDTO(idx, writer, pwd, subject, content, writedate, readnum, ref, lev, sunbun);
	          }
	          return dto;
	      }catch(Exception e){
	          e.printStackTrace();
	          return null;
	      }finally{
	        try{
	          if(rs!=null)rs.close();
	          if(ps!=null)ps.close();
	          if(conn!=null)conn.close();
	        }catch(Exception e2){}
	      }
	    }
	    /**총게시물 수 */
	    public int totalCnt(){
	      try{
	    	  conn=yong.db.YongDB.getConn();
	    String sql="select count(*) from jsp_bbs";
	    ps=conn.prepareStatement(sql);
	    rs=ps.executeQuery();
	    rs.next();
	    int count=rs.getInt(1);
	    count=count==0?1:count;
	    return count;
	  }catch(Exception e){
	    e.printStackTrace();
	    return 1;
	  }finally {
	    try {
	      if(rs!=null)rs.close();
	      if(ps!=null)ps.close();
	      if(conn!=null)conn.close();
	    } catch (Exception e2) {

	    }
	  }
	}
	}



