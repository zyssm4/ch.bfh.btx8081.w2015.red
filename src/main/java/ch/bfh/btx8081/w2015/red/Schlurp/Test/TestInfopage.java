package ch.bfh.btx8081.w2015.red.Schlurp.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


import ch.bfh.btx8081.w2015.red.Schlurp.infopage.Infopage;
import ch.bfh.btx8081.w2015.red.Schlurp.person.Patient;


public class TestInfopage {
	Infopage Infopage = new Infopage(null);
	
	@Test
	public void test() {
		
		//no Patient yet
		"".compareTo(Infopage.toString());
		
		
		
	}

}
