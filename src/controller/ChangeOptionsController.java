package controller;

//import view.DataSetViewForm;
//import javax.swing.JTextField;

import view.DataSetViewForm;
import view.SettingCatersianPlotAxisOptionsForm;
import view.SettingColumnPlotAxisOptionsForm;
//import view.SettingColumnPlotAxisOptionsForm;
import model.Model;

public class ChangeOptionsController {
	
	Model model;
	
	public ChangeOptionsController(Model model){
		this.model=model;
	}
	
	
	public boolean act (DataSetViewForm dataSetViewForm){
		
		/*the only thing we need to do is repaint the plot*/
		/*
		if(dataSetViewForm.getModel().getGraphtype()==1){
			SettingColumnPlotAxisOptionsForm setForm=new SettingColumnPlotAxisOptionsForm(dataSetViewForm.getModel());
			setForm.setModal(true);
			setForm.setVisible(true);
		}
		
		if(dataSetViewForm.getModel().getGraphtype()==2){
			SettingCatersianPlotAxisOptionsForm setForm=new SettingCatersianPlotAxisOptionsForm(dataSetViewForm.getModel());
			setForm.setModal(true);
			setForm.setVisible(true);
		}
		*/
		dataSetViewForm.getGraphicPanel().repaint();
		
		return true;
		
	}

}
