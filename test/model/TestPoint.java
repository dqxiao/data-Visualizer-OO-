package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPoint {

	@Test
	public void testCreatePoint()
	{
		
		Point point=new Point("1.2,2.4");
		
		assertEquals(point.getX(),1.2,0);
		assertEquals(point.getY(), 2.4,0);
		
	}
	
	@Test
	public void testToStringPoint(){
		Point point=new Point("1.2,2.4");
		
		//assertEquals(point.getX(),1.2,0);
		String s=point.getString(",");
		
		assertEquals(s, "1.2,2.4");
		
		
	}
	
	@Test
	public void testCreateNULLPoint(){
		Point point=new Point();
		
		assertEquals(0, point.getX(),0);

	}
	
	

}
