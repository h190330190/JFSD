import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcClass {
	Connection con1;
	public JdbcClass() {
		try {
    		Class.forName("com.mysql.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd1","root","Login@123");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean Insert() {
		
	}
}
