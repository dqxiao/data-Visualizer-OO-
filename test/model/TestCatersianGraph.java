package model;

import org.junit.Test;

import view.Main;

public class TestCatersianGraph {
	@Test 
	public void testCatersianGraphDrawing(){
		/**/
		Main main = new Main();
		Model model= main.getModel();
		  main.setVisible(true);
		  
		  model.getDataSet().addRow("1.2,2.3");
		  model.getDataSet().addRow("1,2");
		  model.getDataSet().addRow("4,10");
		  model.getDataSet().addRow("-1,-2");
		  
		  model.getXAxisOptions().setMax(10);
		  model.getXAxisOptions().setMin(-10);
		  model.getXAxisOptions().setShowLabel(true);
		  
		  model.getYAxisOptions().setMax(10);
		  model.getYAxisOptions().setMin(-10);
		  model.getYAxisOptions().setStep(2);
		  model.getYAxisOptions().setShowLabel(true);
		  model.getYAxisOptions().setShowAxis(true);
		  
		  model.setShowEquation(true);
		  model.setShowEquation(true);
		  /*here all */
		  
		 
		  model.setCartesianPlot();
			
		  main.getDataSetViewForm().repaint();
		
	}
	

	

}
