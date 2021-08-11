import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Ops {
    Connection con1;
    public Ops() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd1","root","Login@123");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public boolean InsertStu(String name,int ID,String Specialization) {
		PreparedStatement ps1;
		try {
			ps1 = con1.prepareStatement(    
			        "Insert into StudentData values(?,?,?)");
			ps1.setInt(1,ID);   
			ps1.setString(2,name);
			ps1.setString(3,Specialization);
			int status;
			status=ps1.executeUpdate();
			if(status>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}    
	}
	
	public void DisplaySpecializations() {
		Statement selectStmt;
		try {
			selectStmt = con1.createStatement();
			ResultSet rs = selectStmt
		            .executeQuery("SELECT * from specialization; ");
		        while(rs.next())
		        {
		            System.out.println(rs.getString(1)+" "+rs.getInt(2));    
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int checkValid(String name) {
		Statement selectStmt;
		try {
			selectStmt = con1.createStatement();
			ResultSet rs = selectStmt
		            .executeQuery("Select SlotsAvailable from specialization where SpecializationName='"+ name +"';");
		        rs.next();
		        int ab=rs.getInt(1);
		        return ab;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public boolean updateSpecialization(String name) {
		int n=checkValid(name);
		PreparedStatement ps1;
		try {
			ps1 = con1.prepareStatement(    
			        "update specialization set SlotsAvailable=? where SpecializationName='"+ name +"';");
			ps1.setInt(1,n-1);   
			   int status;
			   status=ps1.executeUpdate();
			   if(status>0)
				   return true;
			   else
				   return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}    
	}
}
