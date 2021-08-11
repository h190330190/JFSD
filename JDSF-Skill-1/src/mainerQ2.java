import java.util.*;
public class mainerQ2 {

	public static void main(String[] args) {
		Student s=new Student();
		boolean t=true;
		Scanner sc=new Scanner(System.in);
		while(t) {
			System.out.println("Select option:");
			System.out.println("1.Insert Student details\n2.Display details\n3.Update details\n4.Check eligbility");
			int tst=sc.nextInt();
			System.out.println();
			switch(tst) {
			case 1:
				System.out.print("Enter Student ID:");
				int ID=sc.nextInt();
				String d=sc.nextLine();
				System.out.print("Enter Student Name:");
				String name=sc.nextLine();
				System.out.print("Enter Student Gender:");
				String gender=sc.nextLine();
				System.out.print("Enter Student current year:");
				int year=sc.nextInt();
				String d1=sc.nextLine();
				System.out.print("Enter Student department:");
				String dep=sc.nextLine();
				System.out.print("Enter Student mailID:");
				String mail=sc.nextLine();
				System.out.print("Enter Student CGPA:");
				String cgpa=sc.nextLine();
				System.out.print("Enter Student number of backlogs:");
				int backlogs=sc.nextInt();
				s.insert(ID, name, gender, year, dep, mail, cgpa, backlogs);
				System.out.println();
				break;
			case 2:
				s.DisplayStudentsInfo();
				break;
			case 3:
				System.out.print("Enter student serial number:");
				int n=sc.nextInt();
				System.out.print("Enter cgpa:");
				String cgpa1=sc.next();
				System.out.println("Enter number of backlogs:");
				int back=sc.nextInt();
				s.update(n, cgpa1, back);
				break;
			case 4:
				System.out.print("Enter student serial number:");
				int sr=sc.nextInt();
				s.checkEligibility(sr);
				break;
			default:
				System.out.println("Wrong option bye, bye");
				break;
				
			}
		}
	}

}
