import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JunitClass {
	@Test
	public void setup(){
		Student s=new Student();
		boolean t=true;
		assertTrue(s.checkEligibility(5));
		assertFalse(s.checkEligibility(1));
	}
}
