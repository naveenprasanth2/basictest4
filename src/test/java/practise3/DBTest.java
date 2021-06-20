package practise3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBTest {
	@Test
	public void test() throws SQLException {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root","root");
		Statement s = connect.createStatement();
		ResultSet rs = s.executeQuery("select * from testing where name = 'naveen'");

		while(rs.next()){
		System.out.println(rs.getString("name"));
		}
		
	}

}
