package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
//import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class ColumnGraph extends TDGraph {
	
	public ColumnGraph(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	//DataSet dataSet;
	
	public void draw(Graphics g){
		
		
		/*prepare dataSet for testing */
		
		DataSet dataSet=this.getModel().getDataSet();
		
		/**/
		if(dataSet.getSize()==0){
			return; // no data quit without drawing 
		}
		
		double minValue;
		double maxValue;
		double setMinValue=this.getModel().getYAxisOptions().getMin();
		double setMaxValue=this.getModel().getYAxisOptions().getMax();
		double step=this.getModel().getYAxisOptions().getStep();
		boolean yShowAxis=this.getModel().getYAxisOptions().getShowAxis();
		boolean showYlabel=this.getModel().getYAxisOptions().getShowLabel();
		boolean showGroupLabel=this.getModel().getXAxisOptions().getShowLabel();
		
		
		//double setMinValue=this.getYAxisOptions();
		
		boolean autoSize=this.getModel().getXAxisOptions().getautoSize();
		
		if(autoSize){
			minValue=Math.min(dataSet.getMinX(), dataSet.getMinY());
			maxValue=Math.max(dataSet.getMaxX(), dataSet.getMaxY());
			setMaxValue=maxValue;
			setMinValue=minValue;
		}
		
		//double range=
		
		
		int clinetWidth=200;
		int clientHeigth=200;
		int xClientSet=20;
		
		double groupsep=1;
		double barsep=0.25;
		int barWidth= (int ) (clinetWidth/((2+groupsep+barsep)*dataSet.getSize()));
		
		
		if(setMaxValue<=setMinValue){
			return; /*it is difficult to check the start point..*/
		}
		
		int top=20;
		int bottom=20;
		
		double scale=(clientHeigth-top-bottom)/(setMaxValue-setMinValue);
		
		//System.out.println("scale:"+scale);
		
		double start=barWidth+xClientSet;
		
		for(int idx=0;idx<dataSet.getSize();idx++){
			
			
			Double curX=dataSet.getNth(idx).getX();
			int xValueP=(int)(3.5*idx*barWidth);
			int xValueQ=top;
			int xheight=(int)(curX*scale);
			
			xValueP+=start;
			if(curX>0){
				xValueQ+=(int)((setMaxValue-curX)*scale);
			}else{
				xValueQ+=(int)(setMaxValue*scale);
				xheight=-xheight;
			}
			
		
			
			g.setColor(Color.blue); // x series color 
			g.fillRect(xValueP,xValueQ, barWidth, xheight);
			
			/*almost the same job */
			
			Double curY=dataSet.getNth(idx).getY();
			int yValueP=xValueP;
			yValueP+=(1+barsep)*barWidth;
			
			/**/
			int yValueQ=top;
			
			
			int yHeight=(int)(curY*scale);
			
			if(curY>0){
				yValueQ+=(int)((setMaxValue-curY)*scale);
			}else{
				yValueQ+=(int)((setMaxValue*scale));
				yHeight=-yHeight;
			}
			
			g.setColor(Color.darkGray); // y series color 
			g.fillRect(yValueP,yValueQ, barWidth, yHeight);
			
			// 
			
			if(showGroupLabel){
				
				g.setColor(Color.GRAY);
				
				String tikString=String.format("%d", (int)(idx+1));
				int fontsize=10;
				Font tikFont = new Font("SansSerif", Font.BOLD, fontsize);
				FontMetrics tikFontMetrics=g.getFontMetrics(tikFont);
				int tikFontMove=tikFontMetrics.getAscent();
				g.setFont(tikFont);
				
				int yposition=(int)((setMaxValue)*scale);
				yposition+=top;
				
				
				double xposition=3.5*idx*barWidth;
				xposition+=start;
				xposition+=barWidth;
				
				g.drawString(tikString,(int)xposition,yposition+10);
				
			}
			
			
			
			
			
		}
		
		
		
		g.drawLine(xClientSet,(int)(top+setMaxValue*scale),clinetWidth+20,(int) (top+setMaxValue*scale));
		
	
		
		/*this part almost finished!*/
		
		
		if(yShowAxis){
			int idx=0;
			
			while(setMinValue+idx*step<=setMaxValue){
				/**/
				
				g.setColor(Color.LIGHT_GRAY);
				Stroke thindashed = new BasicStroke(1.0f, // line width
					      /* cap style */BasicStroke.CAP_BUTT,
					      /* join style, miter limit */BasicStroke.JOIN_BEVEL, 0.8f,
					      /* the dash pattern */new float[] { 8.0f, 3.0f, 2.0f, 3.0f },
					      /* the dash phase */0.0f); /* on 8, off 3, on 2, off 3 */
				((Graphics2D) g).setStroke(thindashed);
				g.drawLine(xClientSet, (int )(clientHeigth-bottom-idx*step*scale),clinetWidth+20, (int )(clientHeigth-bottom-idx*step*scale));
				
				if(showYlabel){
					String tikString=String.format("%d", (int)(setMinValue+idx*step));
					/**/
					Font tikFont = new Font("SansSerif", Font.BOLD, 10);
					FontMetrics tikFontMetrics=g.getFontMetrics(tikFont);
					int tikFontMove=tikFontMetrics.getAscent();
					g.setFont(tikFont);
					
					g.drawString(tikString,0,(int )(clientHeigth-bottom-idx*step*scale));
				}
				
				idx+=1;
			}
		
		}
		
		
		
	}

	

}

