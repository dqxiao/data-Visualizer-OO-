package controller;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import model.Model;

import org.junit.Test;

import view.DataSetViewForm;
//import view.Main;

public class TestAddRowController {

	@Test
	public void testControllerOperation(){
		
		/**/
		Model model=new Model();
		
		DataSetViewForm df=new DataSetViewForm(model);
		
		
	
		
		// prepared the GUI 
		
		JTextField inputField=df.getTextField();
		inputField.setText("1.2,2.4");
		
		// invoke the controller
		
		AddRowController arc=new AddRowController(model);
		
		assertTrue(arc.act(df));
		
		assertEquals(1, model.getDataSet().getSize());
		
		assertEquals(1,df.getJList().getModel().getSize());
		
		
		
	}

}
