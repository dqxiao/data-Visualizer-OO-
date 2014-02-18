package controller;

import static org.junit.Assert.*;
import model.Model;

import org.junit.Test;

import view.DataSetViewForm;

public class TestColumnPlotController {

	@Test
	public void testaction(){
		
		/*first prepare the GUI*/
		
		Model model=new Model();
		
		//model.setColumnGraph();
		model.getDataSet().addRow("1.2,2.3");
		model.getDataSet().addRow("1,2");
		model.getDataSet().addRow("4,10");
		  
		model.getXAxisOptions().setMax(10);
		model.getXAxisOptions().setMin(0);
		model.getXAxisOptions().setShowLabel(true);
		  
		model.getYAxisOptions().setMax(10);
		model.getYAxisOptions().setMin(0);
		model.getYAxisOptions().setStep(2);
		model.getYAxisOptions().setShowLabel(true);
		
		
		DataSetViewForm df=new DataSetViewForm(model);
		
		/*prepare the controller*/
		ColumnPlotController columnPC=new ColumnPlotController(df.getModel());
		
		//invoke the controller
		
		
		assertTrue(columnPC.act(df));
	}

}
