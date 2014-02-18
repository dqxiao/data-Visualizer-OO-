package controller;

import view.DataSetViewForm;
//import view.GraphicPanel;
import model.*;


public class ColumnPlotController {
	Model model;
	
	/**/
	public ColumnPlotController(Model model){
		this.model=model;
	}
	
	public boolean act (DataSetViewForm dataView){
		
		dataView.getModel().setColumnGraph();
		dataView.getModel().clearAxisOptions();
		
		dataView.getGraphicPanel().setVisible(true);
		
		dataView.getGraphicPanel().repaint();
		
		
		return true;
	}

}
