package model;

public class Model {
	DataSet dataSet;
	AxisOptions xAxisOptions;
	AxisOptions yAxisOptions;
	int graphtype;
	boolean showTrendency;
	boolean showEquation;
	
	public Model(DataSet dataSet){
		
		this.dataSet=dataSet;
	}
	
	public Model(){
		DataSet d=new DataSet();
		this.dataSet=d;
		this.xAxisOptions=new AxisOptions();
		this.yAxisOptions=new AxisOptions();
		this.graphtype=-1;
		this.showTrendency=false;
		this.showEquation=false;
		/*-1 none type */
		
	}
	
	public void clearAxisOptions(){
		this.xAxisOptions=new AxisOptions();
		this.yAxisOptions=new AxisOptions();
		this.showTrendency=false;
		this.showEquation=false;
		
	}
	
	public DataSet getDataSet(){
		return this.dataSet;
	}
	
	public AxisOptions getXAxisOptions(){
		return this.xAxisOptions;
	}
	
	public AxisOptions getYAxisOptions(){
		return this.yAxisOptions;
	}
	
	public boolean getShowTrendency(){
		return this.showTrendency;
	}
	
	public boolean getShowEquation() {
		return this.showEquation;
		
	}
	public int getGraphtype(){
		return graphtype;
	}
	
	public void setColumnGraph(){
		this.graphtype=1;
	}
	public void setCartesianPlot(){
		this.graphtype=2;
	}
	
	
	public void setShowTrendency(boolean showTrendency){
		/**/
		this.showTrendency=showTrendency;
		
	}
	public void setShowEquation(boolean showEquation){
		
		this.showEquation=showEquation;
	}
	

}
