package model;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import org.junit.Test;

import view.GraphicPanel;
import view.Main;



public class TestColumnGraph {
	
	/**/
	@Test
	public void createColumnGraph(){
		
	  /*just test*/
	  Main main = new Main();
	  Model model= main.getModel();
	  main.setVisible(true);
	  
	  model.getDataSet().addRow("1.2,2.3");
	  model.getDataSet().addRow("1,2");
	  model.getDataSet().addRow("4,10");
	  model.getDataSet().addRow("-1,-2");
	  
	  model.getXAxisOptions().setMax(10);
	  model.getXAxisOptions().setMin(0);
	  model.getXAxisOptions().setShowLabel(true);
	  
	  model.getYAxisOptions().setMax(10);
	  model.getYAxisOptions().setMin(0);
	  model.getYAxisOptions().setStep(2);
	  model.getYAxisOptions().setShowLabel(true);
	  model.getYAxisOptions().setShowAxis(true);
	  
	 
	  model.setColumnGraph();
		
	   main.getDataSetViewForm().repaint();
	 
	  
	
		
	}
}
