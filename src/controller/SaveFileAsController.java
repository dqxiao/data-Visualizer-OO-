package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JFileChooser;

import view.DataSetViewForm;
import model.DataSet;
import model.Model;
import model.Point;

public class SaveFileAsController {

	Model model;
	
	public SaveFileAsController(Model model){
		this.model=model;
		
	}
	
	public boolean act (DataSetViewForm dataView){
		
		//get the JList 
		
		
		// JFileChooser
		JFileChooser jChooser=new JFileChooser();
		
		// set the title for save Dialogtile
		jChooser.setDialogTitle("save the dataSet as");
		
		//show saveDialog 
		int returnVal=jChooser.showSaveDialog(null);
		jChooser.setVisible(true);
		
		//
		if(returnVal==JFileChooser.CANCEL_OPTION){
			return false;
		}
		
		String filePath=jChooser.getSelectedFile().getAbsolutePath();
		return savefile(filePath, dataView);
		//return true;
	}
	
	boolean savefile(String filepath,DataSetViewForm dataView){
		FileWriter fWriter=null;
		BufferedWriter bwBufferedReader=null;
		
		try{
			fWriter=new FileWriter(filepath);
			bwBufferedReader=new BufferedWriter(fWriter);
			
			
			DataSet dataSet=this.model.getDataSet();
			
			int size=dataSet.getSize();
			
			for(int idx=0;idx<size;idx++){
				Point point=dataSet.getNth(idx);
				
				String str=point.getString(",");
				bwBufferedReader.write(str+'\n');
				
			}
			
			bwBufferedReader.close();
			return true;
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		return false;
	}
}
