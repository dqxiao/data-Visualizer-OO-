package controller;

import javax.swing.DefaultListModel;

import view.DataSetViewForm;
import model.Model;

public class UpdateRowController {
	
	Model model;
	
	public UpdateRowController(Model model){
		//this.dataSet=model.getDataSet();
		this.model=model;
	}
	
	public boolean act(DataSetViewForm dataSetViewForm){
		int row[]=dataSetViewForm.getJList().getSelectedIndices();
		
		String rowInput=dataSetViewForm.getTextField().getText();
		
		if(row.length!=1){
			return false;
		}
		
		int idx=row[0];
		
		DefaultListModel list=(DefaultListModel) dataSetViewForm.getJList().getModel();
		
		list.set(idx, rowInput);
		this.model.getDataSet().updateRow(idx, rowInput);
		
		dataSetViewForm.getTextField().setText("");
		
		/*update the graph*/
		
		dataSetViewForm.getGraphicPanel().repaint();
		
		return true; 
		
	}

}
