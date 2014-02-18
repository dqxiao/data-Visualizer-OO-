package controller;

import static org.junit.Assert.*;
import model.Model;

import org.junit.Test;

import view.DataSetViewForm;

public class TestChangeOptionsController {
	
	@Test
	public void testControllerOperationOnColumnGraph(){
		
		/*prepare for the GUI*/
		Model model=new Model();
		
		model.setColumnGraph();
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
		
		/*create the controller*/
		
		ChangeOptionsController cOptionsController=new ChangeOptionsController(df.getModel());
		
		assertTrue(cOptionsController.act(df));
	}
	
	@Test
	public void testControllerOperationOnCartesianPlot(){
		
		/*prepare for the GUI*/
		Model model=new Model();
		
		model.setCartesianPlot();
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
		
		model.setShowEquation(true);
		model.setShowTrendency(true);
		
		
		DataSetViewForm df=new DataSetViewForm(model);
		
		/*create the controller*/
		
		ChangeOptionsController cOptionsController=new ChangeOptionsController(df.getModel());
		
		assertTrue(cOptionsController.act(df));
	}
	
	
	

}
