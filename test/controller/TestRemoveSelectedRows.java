package controller;

import static org.junit.Assert.*;

//import java.awt.print.Printable;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
//import javax.swing.ListSelectionModel;

import model.Model;

import org.junit.Test;

import view.DataSetViewForm;

public class TestRemoveSelectedRows {

	@Test
	public void testControllerOperation(){
		
		/**/
		Model model=new Model();
		
		DataSetViewForm df=new DataSetViewForm(model);
		
		
	
		
		// prepared the GUI 
		
		JTextField inputField=df.getTextField();
		inputField.setText("1.2,2.4");
		
		
		
		AddRowController arc=new AddRowController(model);
		
		arc.act(df);
		
		
		// prepared the selection 
		
		JList jList=df.getJList();
		jList.setSelectedIndex(0);
		DefaultListModel jListModel=(DefaultListModel)jList.getModel();
		// invoke the controller
		RemoveSelectedRowsController rsc=new RemoveSelectedRowsController(model);
		
		assertTrue(rsc.act(df));
		
		//detail validation
		
		assertEquals(0,jListModel.getSize());
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
