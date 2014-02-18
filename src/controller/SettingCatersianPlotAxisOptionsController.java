package controller;

import view.SettingCatersianPlotAxisOptionsForm;
import model.Model;

public class SettingCatersianPlotAxisOptionsController {
	
	/*private variable reference the model*/
	Model model; 
	
	
	public SettingCatersianPlotAxisOptionsController(Model model){
		this.model=model;
		
	}
	
	public boolean act(SettingCatersianPlotAxisOptionsForm setForm){
		
		/**/
		String xMaxInputString=setForm.getXMaxInput().getText();
		
		if(xMaxInputString.length()!=0){
			try{
				double xMax=Double.parseDouble(xMaxInputString);
				setForm.getModel().getXAxisOptions().setMax(xMax);
				
			}catch(Exception e){
				
				/*here*/
				return false;
			}
			
		}
		
		String xMinInputString=setForm.getXMinInput().getText();
		if(xMinInputString.length()!=0){
			try{
				Double xMin=Double.parseDouble(xMinInputString);
				setForm.getModel().getXAxisOptions().setMin(xMin);
				
			}catch(Exception e){
				/**/
				return false;
			}
			
		}
		
		
		String xStepInputString=setForm.getXStepInput().getText();
		
		if(xStepInputString.length()!=0){
			try{
				Double xStep=Double.parseDouble(xStepInputString);
				setForm.getModel().getXAxisOptions().setMax(xStep);
				
			}catch(Exception e){
				return false;
			}
		}
		
		/*y label*/
		
		String yMaxInputString=setForm.getYMaxInput().getText();
		
		if(yMaxInputString.length()!=0){
			try{
				double yMax=Double.parseDouble(yMaxInputString);
				setForm.getModel().getYAxisOptions().setMax(yMax);
				
			}catch(Exception e){
				
				/*here*/
				return false;
			}
			
		}
		
		String yMinInputString=setForm.getYMinInput().getText();
		if(yMinInputString.length()!=0){
			try{
				Double yMin=Double.parseDouble(yMinInputString);
				setForm.getModel().getYAxisOptions().setMin(yMin);
				
			}catch(Exception e){
				/**/
				return false;
			}
			
		}
		
		
		String yStepInputString=setForm.getYStepInput().getText();
		
		if(yStepInputString.length()!=0){
			try{
				Double yStep=Double.parseDouble(yStepInputString);
				setForm.getModel().getYAxisOptions().setStep(yStep);
				
			}catch(Exception e){
				return false;
			}
		}
		
		
		/**/
		boolean showTrendency=setForm.getShowTrendency().isSelected();
		
		setForm.getModel().setShowTrendency(showTrendency);
		
		
		boolean showEquation=setForm.getShowEquation().isSelected();
		setForm.getModel().setShowEquation(showEquation);
		
		/**/
		boolean showXLabel=setForm.getShowXLabel().isSelected();
		setForm.getModel().getXAxisOptions().setShowLabel(showXLabel);
		/**/
		
		boolean showYLabel=setForm.getShowYLabel().isSelected();
		
		setForm.getModel().getYAxisOptions().setShowLabel(showYLabel);
		
		/**/
		boolean showYAxis=setForm.getShowYaxis().isSelected();
		
		setForm.getModel().getYAxisOptions().setShowAxis(showYAxis);
		
		/*finish all*/
		
		
		return true;
	}
	
	
	

}
