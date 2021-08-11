import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
	Connection con1;
    public Student() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd1","root","Login@123");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public boolean insert(int ID,String name,String gender,int year,String dept,String mail,String cgpa,int backlogs ) {
		PreparedStatement ps1;
		try {
			ps1 = con1.prepareStatement(    
			        "Insert into Student values(?,?,?,?,?,?,?,?)");
			ps1.setInt(1,ID);   
			ps1.setString(2,name);
			ps1.setString(3,gender);
			ps1.setInt(4,year);
			ps1.setString(5,dept);
			ps1.setString(6,mail);
			ps1.setString(7,cgpa);
			ps1.setInt(8,backlogs);
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
	public void DisplayStudentsInfo() {
		Statement selectStmt;
		try {
			selectStmt = con1.createStatement();
			ResultSet rs = selectStmt
		            .executeQuery("SELECT * from Student; ");
			System.out.println("Serial no.\tID\tName\tGender\tYear\tDepartment\tMail\tCGPA\tNumberOfBacklogs\n");
			int i=1;
		        while(rs.next())
		        {
		            System.out.println(i+"."+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getInt(8));
		            i++;
		        }
		       System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(int n,String cgpa,int back) {
		try {
			Statement UpdatableSmt = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs2= UpdatableSmt.executeQuery("SELECT * FROM Student");
			rs2.absolute(n);
     	   rs2.updateString(7,cgpa);
     	   rs2.updateInt(8,back);
     	   rs2.updateRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean checkEligibility(int n) {
		try {
			Statement ScrollableSmt = con1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs1= ScrollableSmt.executeQuery("SELECT * FROM Student");
			rs1.absolute(n);
			String cg=rs1.getString(7);
			int bg=rs1.getInt(8);
			float cgpa=Float.parseFloat(cg);
			if(cgpa>=6.5 && bg==0) {
				System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" is eligible for CRT");
				System.out.println();
				return true;
			}
			else {
				System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" is not eligible for CRT");
				if(cgpa<6.5 && bg>0) {
					System.out.println("Student needs to increase cgpa more than 6.5 and clear backlogs");
					System.out.println("Current CGPA:"+cgpa);
					System.out.println("Current Backlogs:"+bg);
				}
				else if(bg>0) {
					System.out.println("Student needs to clear backlogs");
					System.out.println("Current Backlogs:"+bg);
				}
				else {
					System.out.println("Student needs to increase cgpa more than 6.5");
					System.out.println("Current CGPA:"+cgpa);
				}
				System.out.println();
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
}
