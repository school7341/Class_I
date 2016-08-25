package yong.bbs;
import java.sql.*;
import java.util.*;

public class BbsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public BbsDAO() {
		
	}
	
	/**글쓰기 관련 메서드*/
	public int bbsWrite(BbsDTO dto){
		try{
			conn=yong.db.YongDB.getConn();
			String sql="insert into jsp_bbs values(jsp_bbs_idx.nextval,?,?,?,?,sysdate,0,0,0,0)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getContent());
			int count=ps.executeUpdate();
			return count;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally {
			try{
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2){}
		}
	}
	
	/**목록 관련 메서드*/
	public ArrayList<BbsDTO> bbsList(int cp,int ls){
		try{
			conn=yong.db.YongDB.getConn();
			//String sql="select * from jsp_bbs order by idx desc";
			String sql="select * from (select rownum as rnum,a.* from(select * from jsp_bbs order by idx desc)a)b where rnum>=("+cp+"-1)*"+ls+"+1 and rnum<="+cp+"*"+ls+"";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			ArrayList<BbsDTO> arr=new ArrayList<BbsDTO>();
			while(rs.next()){
				int idx=rs.getInt("idx");
				String subject=rs.getString("subject");
				String writer=rs.getString("writer");
				int readnum=rs.getInt("readnum");
				BbsDTO dto=new BbsDTO(idx,writer,subject,readnum);
				arr.add(dto);
			}
			return arr;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2){}
		}
	}
	/**총게시물수 관련 메서드*/
	public int getTotalCnt(){
		try{
			conn=yong.db.YongDB.getConn();
			String sql="select count(*) from jsp_bbs";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			int rows=rs.getInt(1);
			
			return rows==0?1:rows;
		}catch(Exception e){
			e.printStackTrace();
			return 1;
		}finally {
			try{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2){}
		}
	}
	
}

