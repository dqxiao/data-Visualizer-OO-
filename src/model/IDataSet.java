package model;

public interface IDataSet {
	
	
	int size();
	double getMinX();
	double getMaxX();
	double getMinY();
	double getMaxY();
	
	/*
	 * as shown in the published interface
	 * */
	
	double getCoordinate(int index,int dimension);
	
	

}
