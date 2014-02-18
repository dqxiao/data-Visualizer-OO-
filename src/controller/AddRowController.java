package controller;

import javax.swing.DefaultListModel;

import view.DataSetViewForm;
//import model.CatersianGraph;
import model.Model;
//import model.TDGraph;

public class AddRowController {
	
	Model model;
	
	public AddRowController(Model m){
		this.model=m;
	}
	
	boolean ValidationInput(String s){
		
		try{
			String[] strArray=s.split(",");
			Double.parseDouble(strArray[0]);
			Double.parseDouble(strArray[1]);
			return true;
		}catch(Exception e){
			//throws IllegalArgumentException("invalid input");
			return false;
		}
		
		
	}
	
	public boolean act (DataSetViewForm dataView){
		String addword=dataView.getTextField().getText();
		
		dataView.getTextField().setText("");
		
		
		if(addword.length()==0){
			return false;
		}
		
		
		/**/
		DefaultListModel listModel=(DefaultListModel)dataView.getJList().getModel();
		
		
		int idx=this.model.getDataSet().addRow(addword);
		
		listModel.add(idx, addword);
		
		/*prepared to update the graph*/
		
		
		dataView.getGraphicPanel().repaint();
			
		return true;
	}
	
}
