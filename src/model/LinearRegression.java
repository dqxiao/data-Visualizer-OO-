package model;

public class LinearRegression {
	
	DataSet dataSet;
	
	Double slope;
	Double intercept;
	
	
	public LinearRegression(DataSet dataSet){
		this.dataSet=dataSet;
		
		// 
		int n=0;
		
		double sumX=0.0,sumY=0.0;
		double sumX2=0.0;
		
		n=dataSet.getSize();
		
		//
		for(int idx=0;idx<n;idx++){
			
			Point curPoint=dataSet.getNth(idx);
			sumX+=curPoint.getX();
			sumY+=curPoint.getY();
			sumX2+=curPoint.getX()*curPoint.getX();
			
		}
		
		double xBar=sumX/n;
		double yBar=sumY/n;
		
		double xxBar=0.0,yyBar=0.0,xyBar=0.0;
		

		for(int idx=0;idx<n;idx++){
			Point curPoint=dataSet.getNth(idx);
			
			double curX=curPoint.getX();
			double curY=curPoint.getY();
			
			xxBar+=(curX-xBar)*(curX-xBar);
			yyBar+=(curY-yBar)*(curY-yBar);
			xyBar+=(curX-xBar)*(curY-yBar);
		}
		
		this.slope=xyBar/xxBar;
		this.intercept=yBar-this.slope*xBar;
		
		
		int df=n-2;
		double rss=0.0,ssr=0.0;
		
		for(int idx=0;idx<n;idx++){
			
			Point curPoint=dataSet.getNth(idx);
			
			double curX=curPoint.getX();
			double curY=curPoint.getY();
			
			double fit=this.slope*curX+this.intercept;
			
			
			rss+=(fit-curX)*(fit-curY);
			ssr+=(fit-yBar)*(fit-yBar);
			
			
		}
		
		//double R2=ssr/yyBar;
		//double sVar=rss/df;
		
		
		//double sVar1=sVar/xxBar;
		//double sVar0=sVar/n+xBar*xBar*sVar1;
		
		//
		
		
		
		
	}

	
	public double getSlope(){
		return this.slope;
	}
	public double getIntercept(){
		return this.intercept;
	}
	
	public String getStringEquation(){
		String resultString;
		
		resultString=String.format("y=%.2g X+%.2g", this.slope,this.intercept);
		return resultString;
		
	}
}
