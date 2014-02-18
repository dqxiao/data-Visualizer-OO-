package model;

public class AxisOptions {
	
	boolean showAxis;
	boolean showLabel;
	double max;
	double min;
	double step;
	boolean autoSize;
	
	
	/*default AxisOptions setting*/
	public AxisOptions(){
		this.showAxis=false;
		this.showLabel=false;
		this.max=10;
		this.min=0;
		this.step=1;
		this.autoSize=true;
		
	}
	
	/*default Set Methods*/
	public void setMax(double max){
		this.max=max;
	}
	public void setMin(double min){
		this.min=min;
	}
	public void setStep(double step){
		this.step=step;
	}
	
	public void setShowAxis(boolean showAxis){
		this.showAxis=showAxis;
	}
	public void setShowLabel(boolean showLabel){
		this.showLabel=showLabel;
	}
	
	
	
	/*default Get methods*/
	public boolean getShowLabel(){
		return this.showLabel;
	}
	
	public boolean getShowAxis(){
		return this.showAxis;
	}
	
	public double getMax(){
		return this.max;
	}
	
	public double getMin(){
		return this.min;
		
	}
	
	public double getStep(){
		return this.step;
		
	}
	
	public boolean getautoSize()
	{
		return this.autoSize;
	}
	

}
