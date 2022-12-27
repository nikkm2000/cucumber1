package parallel;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
	
	SamplePage sp;
	
	public Sample() {
		sp= new SamplePage();
	}
	
	@Test
	public void m1() {
		System.out.println(sp.m2());
		Assert.assertTrue(sp.m2());
		
	}

}
