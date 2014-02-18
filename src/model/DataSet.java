package model;

import java.util.ArrayList;

public class DataSet implements IDataSet{
	
	ArrayList<Point> data=new ArrayList<Point>();
	
	public int addRow(String s){
		
		int idx=data.size();
		try{
			Point point=new Point(s);
		
			data.add(point);
		}catch(Exception e){
			throw new IllegalArgumentException("invalid input");
		}
		return idx;
		
	}
	
	public boolean removeRow(int idx){
		if(idx<0||
				idx>data.size()-1){
			return false;
		}
		
		data.remove(idx);
		
		return true;
		
		
	}
	
	
	public int removeRow(String s){
		Point point=new Point(s);
		
		int idx=data.indexOf(point);
		
		if(idx!=-1){
			data.remove(idx);
		}
		
		return idx;
		
	}
	
	
	public boolean updateRow(int idx,String s){
		if(idx<0||
				idx>data.size()-1){
			return false;
		}
		
		Point point=new Point(s);
		
		data.set(idx,point);
		return true;
		
	}
	
	public int getSize(){
		return data.size();
	}
	
	
	public double getMinX(){
		double min=Double.MAX_VALUE;
		
		
		for(Point p:data)
		{
			double curX=p.getX();
			if(curX<min){
				min=curX;
			}
		}
		
		return min;
		
	}
	
	public double getMinY(){
		double min=Double.MAX_VALUE;
		
		
		for(Point p:data)
		{
			double curY=p.getY();
			if(curY<min){
				min=curY;
			}
		}
		
		return min;
		
	}
	
	public double getMaxX(){
		double max=Double.MIN_VALUE;
		
		
		for(Point p:data)
		{
			double curX=p.getX();
			if(curX>max)
			{
				max=curX;
			}
		}
		
		return max;
		
	}
	
	public double getMaxY(){
		double max=Double.MIN_VALUE;
		
		
		for(Point p:data)
		{
			double curY=p.getY();
			if(curY>max){
				max=curY;
			}
		}
		
		return max;
		
	}
	
	
	public Point getNth(int i){
		return data.get(i);
	}
	
	
	public int size(){
		return this.getSize();
	}
	
	
	public double getCoordinate(int index,int dimension){
		if(index<0 ||index>this.getSize()){
			throw new ArrayIndexOutOfBoundsException("index is invalid");
		}
		
		if(dimension!=0 && dimension!=1){
			throw new IllegalArgumentException("dimension is invalid");
		}
		
		/**/
		if(dimension==0){
			return this.getNth(index).getX();
		}else{
			return this.getNth(index).getY();
		}
		
		
		
	}
	

}
