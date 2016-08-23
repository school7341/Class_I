package yong.emp.model;
import java.sql.*;
import java.util.*;
public class EmpDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public EmpDAO() {
	
	}
	/*Insert Employee Method**/
	public int empAdd(EmpDTO dto){
		try{
			conn=yong.db.YongDB.getConn();
			String sql="insert into employee values(employee_idx.nextval,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getDept());
			int count=ps.executeUpdate();
			return count;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally{
			try{
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception e2){
				
			}
		}
	}
	/*Delete Employee Method**/
	public int empDel(String name){
		try{
			conn = yong.db.YongDB.getConn();
			String sql="delete from employee where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
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
	
	/*Search All**/
	public ArrayList<EmpDTO> empList(){
		
		try{
			conn = yong.db.YongDB.getConn();
			String sql="select * from employee order by idx desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			ArrayList<EmpDTO> arr=new ArrayList<EmpDTO>();
			while(rs.next()){
				int idx=rs.getInt("idx");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String dept=rs.getString("dept");
				
				EmpDTO dto=new EmpDTO(idx,name,email,dept);
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
	/*Search Name**/
	public ArrayList<EmpDTO> empSearch(String name){
		try{
			conn = yong.db.YongDB.getConn();
			String sql="select * from employee where name=? order by idx desc";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			ArrayList<EmpDTO> arr=new ArrayList<EmpDTO>();
			while(rs.next()){
				int idx=rs.getInt("idx");
				String name_1=rs.getString("name");
				String email=rs.getString("email");
				String dept=rs.getString("dept");
				
				EmpDTO dto=new EmpDTO(idx,name_1,email,dept);
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
/*Search by idx**/
	public EmpDTO updateInfo(int idx){
		try{
			conn = yong.db.YongDB.getConn();
			String sql="select * from employee where idx=?";
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, idx);
			rs=ps.executeQuery();
			EmpDTO dto=null;
			
			if(rs.next()){
				String name=rs.getString("name");
				String email=rs.getString("email");
				String dept=rs.getString("dept");
				 dto=new EmpDTO(idx,name,email,dept);
				
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
		
	}	/*Revise Method**/
	public int empRevise(EmpDTO dto){
		try{
			conn = yong.db.YongDB.getConn();
			String sql="update employee set name=?,email=?,dept=? where idx=?";
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getDept());
			ps.setInt(4, dto.getIdx());
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
	
}
