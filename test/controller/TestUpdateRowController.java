package controller;

import static org.junit.Assert.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import model.Model;

import org.junit.Test;

import view.DataSetViewForm;

public class TestUpdateRowController {

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
		
		arc.act(df);
		
		// invoke twice to add another one 
		
		
		
		// prepared the GUI 
		
		JList jList=df.getJList();
		jList.setSelectedIndex(0);
		inputField.setText("1.2,2.3");
		
		// invoke the controller 
		
		UpdateRowController urc=new UpdateRowController(model);
		
		//validation
		assertTrue(urc.act(df));
		
		/*more detailed check!*/
		
		DefaultListModel dListModel=(DefaultListModel)jList.getModel();
		
		assertEquals(1, dListModel.getSize());
		
		//System.out.println(dListModel.get(0));
		
		assertEquals("1.2,2.3", (String)dListModel.get(0));
		
		
		/*try to fail the Update selected */
		
		
		
		
		
		
	
		
		
		
		
		
	}

}
