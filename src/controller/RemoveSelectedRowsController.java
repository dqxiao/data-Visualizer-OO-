package controller;

import javax.swing.DefaultListModel;

import view.DataSetViewForm;
import model.Model;

public class RemoveSelectedRowsController {
	
	Model model;
	
	public RemoveSelectedRowsController(Model m){
		this.model=m;
	}
	
	public boolean act(DataSetViewForm dataviewform){
		
		int[] row =dataviewform.getJList().getSelectedIndices();
		
		if(row.length==0){
			return false;
		}
		
		DefaultListModel listModel=(DefaultListModel)dataviewform.getJList().getModel();
		
		for(int idx=row.length-1;idx>=0;idx--){
			/**/
			listModel.remove(row[idx]);
			model.getDataSet().removeRow(row[idx]);
			
			
		}
		/*update our graph as soon as possible*/
		
		dataviewform.getGraphicPanel().repaint();
		
		
		return true;
		
		
	}

}
