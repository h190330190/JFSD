import java.util.Scanner;
public class mainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ops o=new Ops();
		boolean t=true;
		while(t){
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Student Name:");
			String name=sc.nextLine();
			System.out.println("Enter Student ID:");
			int id=sc.nextInt();
			System.out.println("Choose Specialization:");
			o.DisplaySpecializations();
			System.out.println("Enter number(1,2,3,4):");
			int s=sc.nextInt();
			String spname="";
			switch(s) {
			case 1:
				spname="DS";
				break;
			case 2:
				spname="AI";
				break;
			case 3:
				spname="Rocket";
				break;
			case 4:
				spname="CLD";
				break;
			default:
				System.out.println("You entered a invalid number, get lost");
				t=false;
				break;
			}
			if(o.checkValid(spname)==0) {
				System.out.println("You entered a specialization which is full, get lost");
				t=false;
			}
			boolean b=o.InsertStu(name, id, spname);
			if(b)
				System.out.println("Student inserted succesfully");
			else
				System.out.println("Couldnt enter student data");
			boolean u=o.updateSpecialization(spname);
			if(u)
				System.out.println("Slots updated");
			else
				System.out.println("Couldnt update slot data");
			t=false;
		}
	}

}
