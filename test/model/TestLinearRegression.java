package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinearRegression {

	@Test
	public void testLinearRegressionSimple(){
		DataSet dataSet=new DataSet();
		
		dataSet.addRow("1.2,2.4");
		dataSet.addRow("2.4,3.6");
		dataSet.addRow("3.6,4.8");
		
		LinearRegression lReg=new LinearRegression(dataSet);
		
		double slope=lReg.getSlope();
		double intercept=lReg.getIntercept();
		
		assertEquals(1.0, slope,0.05);
		assertEquals(1.2, intercept,0.05);
		
	
		assertEquals("y=1.0 X+1.2",lReg.getStringEquation());
		
	}
	


}
