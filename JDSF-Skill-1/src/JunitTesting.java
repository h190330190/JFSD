import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JunitTesting {
	public static void main(String[] args) {
		Result rs=JUnitCore.runClasses(JunitClass.class);
		for(Failure failure:rs.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(rs.wasSuccessful());
	}
}
