package controller;

import static org.junit.Assert.*;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import model.Model;

import org.junit.Test;

import view.SettingCatersianPlotAxisOptionsForm;

public class TestSettingCatersianPlotAxisOptionsController {
	
	@Test
	public void testControllerOperationNormal(){
		
		Model model=new Model();
		
		/*Prepare the GUI container*/
		
		SettingCatersianPlotAxisOptionsForm catersianForm=new SettingCatersianPlotAxisOptionsForm(model);
		
		/*prepare for the GUI input*/
		
		JTextField xMaxInpuTextField=catersianForm.getXMaxInput();
		xMaxInpuTextField.setText("10");
		
		JTextField xMinInputJTextField=catersianForm.getXMinInput();
		xMinInputJTextField.setText("-10");
		
		JTextField xStepInpuTextField=catersianForm.getXStepInput();
		xStepInpuTextField.setText("2");
		
		
		JTextField yMaxInpuTextField=catersianForm.getYMaxInput();
		yMaxInpuTextField.setText("10");
		
		JTextField yMinInputJTextField=catersianForm.getYMinInput();
		yMinInputJTextField.setText("-10");
		
		JTextField yStepInpuTextField=catersianForm.getYStepInput();
		yStepInpuTextField.setText("2");
		
		// label shows 
		
		JCheckBox showXlabelCheckBox=catersianForm.getShowXLabel();
		showXlabelCheckBox.setSelected(true);
		
		JCheckBox showYlabelCheckBox=catersianForm.getShowYLabel();
		showYlabelCheckBox.setSelected(true);
		
		JCheckBox showYAxisCheckBox=catersianForm.getShowYaxis();
		showYAxisCheckBox.setSelected(true);
		
		//tendency 
		
		JCheckBox showTendencyCheckBox=catersianForm.getShowTrendency();
		showTendencyCheckBox.setSelected(true);
		
		JCheckBox showEquationCheckBox=catersianForm.getShowEquation();
		showEquationCheckBox.setSelected(true);
		
		
		// prepare the controller and invoke it 
		
	
		SettingCatersianPlotAxisOptionsController catersianPC=new SettingCatersianPlotAxisOptionsController(catersianForm.getModel());
		
		assertTrue(catersianPC.act(catersianForm));
		
		
	}
	
	@Test
	public void testControllerOperationInvalid(){
		
		Model model=new Model();
		
		/*Prepare the GUI container*/
		
		SettingCatersianPlotAxisOptionsForm catersianForm=new SettingCatersianPlotAxisOptionsForm(model);
		
		SettingCatersianPlotAxisOptionsController catersianPC=new SettingCatersianPlotAxisOptionsController(catersianForm.getModel());
		
		assertTrue(catersianPC.act(catersianForm));
		
	}
	
	

}
