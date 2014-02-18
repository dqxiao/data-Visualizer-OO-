package model;

public class Point {
	double x;
	double y;
	
	public Point(){
		this.x=0;
		this.y=0;
		
	}
	
	public Point(String s){
		
		/*String s is legal one*/
		String[] strArray=s.split(",");
		
		
		if(strArray.length!=2){
			throw new IllegalArgumentException("invalid argument");
		}
		try{
			this.x=Double.parseDouble(strArray[0]);
			this.y=Double.parseDouble(strArray[1]);
			}catch(Exception e){
				throw new IllegalArgumentException("invalid argument");
			}
	
		
	}
	
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public String getString(String comma){
		String xString=Double.toString(this.x);
		String yString=Double.toString(this.y);
		
		String result=xString+comma+yString;
				
		return result;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Point){
			Point newP=(Point)o;
			
			if(newP.getX()==this.getX() && this.getY()==newP.getY()){
				return true;
			}else{
				return false;
			}
		}
		return super.equals(o);
		
	}

}
