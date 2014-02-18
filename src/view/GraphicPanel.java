package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.*;

public class GraphicPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	Model model;
	

	
	public GraphicPanel(Model model){
		this.model=model;
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		TDGraph drawer=(TDGraph)null;
		
		if(model.getGraphtype()==1){
			drawer=new ColumnGraph(this.model);
		}else{
			if(model.getGraphtype()==2)
				drawer=new CatersianGraph(this.model);
		}
	
		
		if(drawer==null) return;
		
		drawer.draw(g);
	}

}
