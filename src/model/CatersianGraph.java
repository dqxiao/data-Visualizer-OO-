package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
//import java.util.Scanner;

public class CatersianGraph extends TDGraph {
	
	public CatersianGraph(Model model){
		super(model);
	}
	
	public void draw(Graphics g){
		
		
		/*get the plot Model Setting and dataSet*/
		DataSet dataSet=this.model.getDataSet();	
		boolean showTrendency=this.model.getShowTrendency();
		boolean showEquation=this.model.getShowEquation();
		//show label, show tendency, showEquation 
		
		boolean showXlabel=this.model.getXAxisOptions().getShowLabel();
		boolean showYlabel=this.model.getYAxisOptions().getShowLabel();
		boolean showYAxis=this.model.getYAxisOptions().getShowAxis();
		int ystep=(int)this.model.getYAxisOptions().getStep();
		
		
		double setXMaxValue=this.model.getXAxisOptions().getMax();
		double setXMinValue=this.model.getXAxisOptions().getMin();
		
		
		double setYMaxValue=this.model.getYAxisOptions().getMax();
		double setYMinValue=this.model.getYAxisOptions().getMin();
		
		
		
		/*prepare the draw plot's parmeters*/
		int top=30;
		int bottom=30;
		int left=20;
		int right=20;
		
		int clientWidth=200;
		int clientHeight=200;
		
		
		
		
		
		/*calculate the x scale  */
		
		int xScale=(int)(clientWidth/(setXMaxValue-setXMinValue));
		
		int yScale=(int)(clientHeight/(setYMaxValue-setYMinValue));
		
		/*prepare to draw the x axis*/
		
		int oY=(int) (setYMaxValue-0)*yScale;
		oY+=top;
		int oX=(int)(0-setXMinValue)*xScale;
		oX+=left;
		
		
		g.drawLine(left,oY,left+clientWidth,oY);
		g.drawLine(oX,top,oX,top+clientHeight);
		
		
		/*prepare to draw the points*/
		
		
		int size=dataSet.getSize();
		
		
		for(int idx=0;idx<size;idx++)
		{
			
			Point curPoint=dataSet.getNth(idx);
			
			double curX=curPoint.getX();
			double curY=curPoint.getY();
			
			/*cal the position of points*/
			
			double xValueP=curX*xScale;
			
			xValueP+=oX;
			
			double yValueP=-curY*yScale;
			
			yValueP+=oY;
			
			g.setColor(Color.blue);
			g.fillOval((int)xValueP-2,(int)yValueP-2, 4, 4);
			g.drawOval((int)xValueP-2,(int)yValueP-2, 4, 4);
			
			if(showXlabel){
				String tikString=String.format("%.2g", curX);
				Font tikFont = new Font("SansSerif", Font.BOLD, 6);
				FontMetrics tikFontMetrics=g.getFontMetrics(tikFont);
				int tikFontMove=tikFontMetrics.getAscent();
				g.setFont(tikFont);
				
				g.drawString(tikString,(int)xValueP-2,oY+tikFontMove);
				
			}
			
			
		}
		
		if(showTrendency && dataSet.getSize()>1){
			LinearRegression lRegression=new LinearRegression(dataSet);
			
			double slope=lRegression.getSlope();
			double intercept=lRegression.getIntercept();
			
			/**/
			double startXP=left;
			
			double startYP=-(slope*setXMinValue+intercept)*yScale;
			startYP+=oY;
			
			/**/
			double endXP=setXMaxValue*xScale;
			endXP+=oX;
			
			double endYP=-(slope*setXMaxValue+intercept)*yScale;
			endYP+=oY;
			
			g.setColor(Color.red);
			
			g.drawLine((int)startXP,(int)startYP,(int)endXP,(int)endYP);
			
			
			if(showEquation){
				g.drawString(lRegression.getStringEquation(),(int)oX,(int)(-intercept*yScale+oY));
			}
			
		}
		
		
		if(showYAxis){
			/**/
			int idx=0;
			while(setYMinValue+idx*ystep<=setYMaxValue){
				/**/
				g.setColor(Color.LIGHT_GRAY);
				Stroke thindashed = new BasicStroke(1.0f, // line width
					      /* cap style */BasicStroke.CAP_BUTT,
					      /* join style, miter limit */BasicStroke.JOIN_BEVEL, 0.8f,
					      /* the dash pattern */new float[] { 8.0f, 3.0f, 2.0f, 3.0f },
					      /* the dash phase */0.0f); /* on 8, off 3, on 2, off 3 */
				((Graphics2D) g).setStroke(thindashed);
				
				double yValueP=-(setYMinValue+idx*ystep)*yScale;
				yValueP+=oY;
				
				
				g.drawLine(left, (int)yValueP, left+clientWidth,(int) yValueP);
				
				/**/
				
				
				idx+=1;
				
			}
			
		}
		
		if(showYlabel){
			int idx=0;
			
			while(setYMinValue+idx*ystep<=setYMaxValue){
				
				g.setColor(Color.GRAY);
				String tikString=String.format("%d", (int)(idx*ystep));
				/**/
				Font tikFont = new Font("SansSerif", Font.BOLD, 6);
				FontMetrics tikFontMetrics=g.getFontMetrics(tikFont);
				int tikFontMove=tikFontMetrics.getAscent();
				g.setFont(tikFont);
				
				double yValueP=-(setYMinValue+idx*ystep)*yScale;
				yValueP+=oY;
				
				g.drawString(tikString,oX-tikFontMove, (int)yValueP);
				
				idx+=1;
				
			}
		}
		
		
		
		
	}

}

