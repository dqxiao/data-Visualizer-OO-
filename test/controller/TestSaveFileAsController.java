package controller;

import static org.junit.Assert.*;
import model.Model;

import org.junit.Test;

import view.DataSetViewForm;

public class TestSaveFileAsController {
	
	@Test
	public void testControllerOperation(){
		/*prepared the GUI*/
		Model model=new Model();
		model.getDataSet().addRow("1,2");
		model.getDataSet().addRow("2,3");
		
		DataSetViewForm df=new DataSetViewForm(model);
		
		/*prepare the controller*/
		
		SaveFileAsController sfc=new SaveFileAsController(model);
		
		//boolean saveflag=sfc.savefile("/Users/dongqingxiao/Documents/workspace/DataSetPlot/Data/testsave.txt", df);
		boolean saveflag=sfc.savefile("test/Data/testsave.txt", df);
		
		assertTrue(saveflag);
		
	}
}
