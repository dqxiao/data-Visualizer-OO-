package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDataSet {

	@Test
	public void testCreateDataSet(){
		
		DataSet dataSet=new DataSet();
		
		int idx=dataSet.addRow("1.2,2.4");
		
		assertEquals(idx, 0);
	}
	
	@Test
	public void testGetSize(){
		
		DataSet dataSet=new DataSet();
		dataSet.addRow("1.2,2.4");
		
		int size=dataSet.getSize();
		
		assertEquals(1, size);
	}
	
	@Test
	public void testRemoveRowInvalid(){
		DataSet dataSet=new DataSet();
		dataSet.addRow("1.2,2.4");
		
		boolean over=dataSet.removeRow(1);
		boolean neg=dataSet.removeRow(-1);
		
		assertFalse(over);
		assertFalse(neg);
		
	}
	
	@Test
	public void testRemoveRow(){
		DataSet dataSet=new DataSet();
		
		int idx=dataSet.addRow("1.2,2.4");
		
		boolean flag=dataSet.removeRow(idx);
		
		assertTrue(flag);
		
	}
	
	@Test
	public void testRemoveRowString(){
		DataSet dataSet=new DataSet();
		
		int idx=dataSet.addRow("1.2,2.4");
		
		int removeIdx=dataSet.removeRow("1.2,2.4");
		
		assertEquals(idx, removeIdx);
		
		int invalidRemoveIdx=dataSet.removeRow("1.2,2.3");
		
		assertEquals(-1, invalidRemoveIdx);
		
	}
	
	@Test
	public void testGetMaxX(){
		DataSet dataSet=new DataSet();
		
		dataSet.addRow("1.2,2.4");
		dataSet.addRow("2.4,3.6");
		
		double maxX=dataSet.getMaxX();
		double minX=dataSet.getMinX();
		
		
		assertEquals(maxX, 2.4,0);
		assertEquals(minX, 1.2,0);
		
		double minY=dataSet.getMinY();
		double maxY=dataSet.getMaxY();
		
		assertEquals(2.4, minY,0);
		assertEquals(3.6, maxY,0);
		
		
		
		

	}
	
	
	@Test
	public void testUpdateRow(){
		
		DataSet dataSet=new DataSet();
		
		int idx=dataSet.addRow("1.2,2.4");
		
		boolean flag=dataSet.updateRow(idx, "1.2,2.3");
		
		assertTrue(flag);
		
		boolean over=dataSet.updateRow(-1, "1.2,2.3");
		assertFalse(over);
		
		boolean neg=dataSet.updateRow(1, "1.2,2.3");
		
		assertFalse(neg);
		
		
		
		
		
		
	}

}
