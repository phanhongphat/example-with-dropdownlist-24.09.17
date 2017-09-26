package DAO;
import java.util.*;

import BEAN.Province;
import BEAN.Student;

import java.sql.*;

public class HomeDAO 
{
	public static List<Province> DisplayProvince (Connection conn)
	{
		List<Province> list = new ArrayList<Province>();
		String sql = "select * from province" ;
		
		// Hiển thị dữ liệu từ sql
		try 
		{
			//truyền sql vào
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			// Thực thi truy vấn
			ResultSet rs = ptmt.executeQuery();
			
			//Đổ dữ liệu vào class province
			while (rs.next())
			{
				Province province = new Province();
				
				//Lấy 2 giá trị :
				int provinceid = rs.getInt("provinceid");
				String provincename = rs.getString("provincename");
				
				//gọi giá trị ra :
				province.setProvinceid(provinceid);
				province.setProvincename(provincename);
				
				list.add(province);
				
			}						
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	public static boolean InsertStudent(Connection conn,Student stu)
	{
		//create preparedstatement
		PreparedStatement ptmt = null;
		// truyền truy vấn sql cho đối tượng preqaredstatement
		String sql = "insert into student(studentname,provinceid) value(?,?)" ;
		try 
		{
			ptmt = conn.prepareStatement(sql);
			
			//truyền 2 biến uname và password vào 2 dấu ? line 14
			String studentname 	= stu.getStudentname();
			int provinceid = stu.getProvinceid();
			
			ptmt.setString(1,studentname);						// 1 2 :paremeterindex là vị trí, x là biến 
			ptmt.setInt(2,provinceid);
															//pttm.setString(parameterIndex, x);
			// thực thi truy vấn
			int kt = ptmt.executeUpdate(); 							// khai báo int vì biến trả về của excuteupdate là kiểu int
		
			if (kt != 0)    // điề kiện if đúng thì thực thi thêm dữ liệu thành công
			{
				return true;
			}
			ptmt.close();  // đóng pttm
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
}
