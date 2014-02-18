package controller;

import static org.junit.Assert.*;
import model.Model;
import org.junit.Test;

import view.DataSetViewForm;

public class TestLoadFileController {
	
	@Test
	public void testControllerOperation(){
		
		/*prepared the GUI*/
		Model model=new Model();
		
		DataSetViewForm df=new DataSetViewForm(model);
		
		/*prepare the controller*/
		
		LoadFileController lfc=new LoadFileController(model);
		
		//boolean loadflag=lfc.loadfile(df, "/Users/dongqingxiao/Documents/workspace/DataSetPlot/Data/testload");
		boolean loadflag=lfc.loadfile(df, "test/Data/testload");
		
		// 
		assertTrue(loadflag);
		
		
		assertEquals(4, model.getDataSet().getSize());
		
	}

}
