package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestModel {

	@Test
	public void testCreateModel(){
		
		DataSet dataSet=new DataSet();
		
		Model model=new Model(dataSet);
		
		
		DataSet dataSet2=model.getDataSet();
		
		assertEquals(dataSet, dataSet2);
		
		
		
	}
	
	@Test
	public void testCreateEmptyModel(){
		
		Model model=new Model();
		
		assertEquals(0,model.getDataSet().getSize());
		
		assertEquals(-1, model.getGraphtype());
		
		assertFalse(model.getShowEquation());
		assertFalse(model.getShowTrendency());
		
		/**/
		assertEquals(10, model.getXAxisOptions().getMax(),0);
		assertEquals(0, model.getXAxisOptions().getMin(),0);
		
		assertEquals(10, model.getYAxisOptions().getMax(),0);
		assertEquals(0, model.getYAxisOptions().getMin(),0);
		
	}
	/*don't need worry about clear*/
	
	@Test
	public void testSetAxisOptions(){
		Model model=new Model();
		
		model.setCartesianPlot();
		assertEquals(2, model.getGraphtype());
		
		model.setColumnGraph();
		assertEquals(1, model.getGraphtype());
		
		
		/**/
		
		model.setShowEquation(true);
		assertTrue(model.getShowEquation());
		
		/**/
		
		model.setShowTrendency(true);
		assertTrue(model.getShowTrendency());
		
		/*Great doing*/
		
	}
	
	@Test
	public void testClearAxisOptions(){
		Model model=new Model();
		
		model.setCartesianPlot();
		assertEquals(2, model.getGraphtype());
		
		model.getXAxisOptions().setMax(5);
		
		assertEquals(5, model.getXAxisOptions().getMax(),0);
		
		/*clear*/
		
		model.clearAxisOptions();
		
		assertEquals(10, model.getXAxisOptions().getMax(),0);
		
	}
	
	

}
