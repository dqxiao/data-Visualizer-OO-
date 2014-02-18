package model;

import java.awt.Graphics;

import javax.swing.JPanel;

public interface IGraph {
	/*register data set with the drawer*/
	
	void setDataset(IDataSet ds);
	
	/*
	 * Actually draws the graph into given JPanel object
	 * Note the Graphics object g is the one associated with the panel 
	 * 
	 * It is assumed the graphing objects already has dataSet because setDataSet(ds)
	 * was invoked before drawing 
	 *   */
	
	void draw(Graphics g,JPanel panel);
	
	//void setProperties()
	

}
