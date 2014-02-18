package controller;

import view.SettingColumnPlotAxisOptionsForm;
import model.Model;

public class SettingColumnPlotAxisOptionsController {
	
	Model model;
	
	public SettingColumnPlotAxisOptionsController(Model model){
		this.model=model;
	}
	
	public boolean act(SettingColumnPlotAxisOptionsForm settingForm){
		
		
		/*setting if true*/
		String maxInputString=settingForm.getMaxInput().getText();
		
		if(maxInputString.length()!=0 && !maxInputString.equals("auto")){
			try{
				double maxInput=Double.parseDouble(maxInputString);
				this.model.getYAxisOptions().setMax(maxInput);
				
			}catch(Exception e){
				e.printStackTrace(); /*the same problem*/
				return false;
			}
		}
		
		/*setting if exists*/
		String minInputString=settingForm.getMinInput().getText();
		
		if(minInputString.length()!=0 && !minInputString.equals("auto")){
			try{
				double minInput=Double.parseDouble(minInputString);
				this.model.getYAxisOptions().setMin(minInput);
				
			}catch(Exception e){
				return false;
			}
		}
		
		/*setting if exists*/
		String stepInputString=settingForm.getStepInput().getText();
		
		if(stepInputString.length()!=0){
			try{
				double stepInput=Double.parseDouble(stepInputString);
				this.model.getYAxisOptions().setStep(stepInput);;
				
			}catch(Exception e){
				return false;
			}
		}
		
		
	
		
		
		boolean showAxisInput=settingForm.getShowAxis().isSelected();
		boolean showLabelInput=settingForm.getShowLabel().isSelected();
		boolean showGroupLabelInput=settingForm.getShowGroupLabel().isSelected();
		
		/*change the model information*/
		
		
		this.model.getYAxisOptions().setShowAxis(showAxisInput);
		this.model.getYAxisOptions().setShowLabel(showLabelInput);
		this.model.getXAxisOptions().setShowLabel(showGroupLabelInput);
		
		
		return true;
	}
	

}
