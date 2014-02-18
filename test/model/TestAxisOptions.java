package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAxisOptions {
	@Test
	public void testCreateAxisOptions(){
		AxisOptions axisOptions=new AxisOptions();
		
		/**/
		assertEquals(10,axisOptions.getMax(),0);
		
		assertEquals(0, axisOptions.getMin(),0);
		
		assertEquals(1, axisOptions.getStep(),0);
		/**/
		assertFalse(axisOptions.getShowAxis());
		assertFalse(axisOptions.getShowLabel());
		
	}
	
	@Test
	public void testSettingAxisOptions(){
		
		AxisOptions axisOptions=new AxisOptions();
		
		axisOptions.setMax(5);
		assertEquals(5, axisOptions.getMax(),0);
		
		/**/
		
		axisOptions.setMin(-1);
		assertEquals(-1, axisOptions.getMin(),0);
		
		/**/
		axisOptions.setStep(2);
		assertEquals(2, axisOptions.getStep(),0);
		/**/
		axisOptions.setShowAxis(true);
		assertTrue(axisOptions.getShowAxis());
		
		/**/
		axisOptions.setShowLabel(true);
		assertTrue(axisOptions.getShowLabel());
		
		/**/
		
		
	}
}
