package controller;

import view.DataSetViewForm;
import model.Model;


public class CartesianPlotController {
	Model model;
	
	public CartesianPlotController(Model model){
		this.model=model;
	}

	public boolean act (DataSetViewForm dataView){
		dataView.getModel().setCartesianPlot();
		if(dataView.getModel().getGraphtype()==1){
			dataView.getModel().clearAxisOptions();
		}
		
		dataView.getGraphicPanel().setVisible(true);
		
		dataView.getGraphicPanel().repaint();
		
		
		return true;
	}
}
