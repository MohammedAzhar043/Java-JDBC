import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class StudentDemo {

	public Student getStudent(int rollno) {
		Student s = new Student();
		
		s.rollno =rollno;
		try {
			String sql = "select sname from student where rollno="+s.rollno;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			String s1 = rs.getString(1);
			s.sname =s1;
			st.close();
			con.close();
			return s;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return s;
	}

	public int insertStudent(int rollno,String name) {
		
		int s=0 ;
		
		try {
			String sql  = "insert into student values(?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, rollno);
			st.setString(2, name);
			s = st.executeUpdate();
			
			st.close();
			con.close();
		return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}

	public int updateStudent(int rollno,String name) {
		int a =0;
		try {
			String sql = "update student set sname=? where rollno =?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","root");
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1,name);
			pr.setInt(2, rollno);
			
			 a  = pr.executeUpdate();
			pr.close();
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return a;
	}


	public int deleteStudent(int rollno) {
		int a =0;
		try {
			String sql = "delete from student  where rollno =?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","root");
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setInt(1, rollno);
			
			 a  = pr.executeUpdate();
			pr.close();
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return a;
	}
}


