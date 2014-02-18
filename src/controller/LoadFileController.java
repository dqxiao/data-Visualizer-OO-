package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import view.DataSetViewForm;
import model.Model;

public class LoadFileController {
	
	/**/
	Model model;
	
	public LoadFileController(Model model){
		this.model=model;
	}
	
	/**/
	public boolean act (DataSetViewForm dataView){
		
		// create the JFileChoose for this purpose 
		JFileChooser chooser=new JFileChooser();
		int status=chooser.showOpenDialog(null);
		
		// selection Mode 
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		//setting the title for this dialog 
		chooser.setDialogTitle("please select the file you want to load as dataSet");
		
		// prepared for this JList 
		
		if(status!=JFileChooser.APPROVE_OPTION){
			return false;
		}else{
			String filepath=chooser.getSelectedFile().getAbsolutePath();
			/*next thing is call the load*/
			return loadfile(dataView, filepath);
			
		}
		
	}

	
	boolean loadfile(DataSetViewForm dataView,String filepath){
		
		DefaultListModel listModel=(DefaultListModel)dataView.getJList().getModel();
		
		
		/*next thing is call the load*/
		File file=new File(filepath); 
		String s=null;
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((s=br.readLine())!=null){
				this.model.getDataSet().addRow(s);
				listModel.addElement(s);
			}
			br.close();
			
			dataView.getGraphicPanel().repaint(); // repaint 
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return false;
	}
}
