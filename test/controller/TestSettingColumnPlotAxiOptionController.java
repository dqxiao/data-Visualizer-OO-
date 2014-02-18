package controller;

import static org.junit.Assert.*;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import model.Model;

import org.junit.Test;

import view.SettingColumnPlotAxisOptionsForm;

public class TestSettingColumnPlotAxiOptionController {
	
	@Test
	public void testControllerOperationNormal(){
		/*prepare the GUI*/
		Model model=new Model();
		
		SettingColumnPlotAxisOptionsForm columnPlotForm=new SettingColumnPlotAxisOptionsForm(model);
		
		JTextField maxInField=columnPlotForm.getMaxInput();
		maxInField.setText("10");
		
		/**/
		JTextField minField=columnPlotForm.getMinInput();
		minField.setText("0");
		
		/**/
		
		JTextField stepField=columnPlotForm.getStepInput();
		stepField.setText("1");
		
		/**/
		
		JCheckBox showAxisCheckBox=columnPlotForm.getShowAxis();
		showAxisCheckBox.setSelected(true);
		
		/**/
		JCheckBox showGroupLabelBox=columnPlotForm.getShowGroupLabel();
		showGroupLabelBox.setSelected(true);
		
		/**/
		JCheckBox showLabelCheckBox=columnPlotForm.getShowLabel();
		showLabelCheckBox.setSelected(true);
		
		
		/*prepare the controller and invoke the controller*/
		
		SettingColumnPlotAxisOptionsController setColumnPC=new SettingColumnPlotAxisOptionsController(columnPlotForm.getModel());
		
		
		assertTrue(setColumnPC.act(columnPlotForm));
			
	}
	
	@Test
	public void testControllerOperationInvalid(){
		
		Model model=new Model();
		
		SettingColumnPlotAxisOptionsForm columnPlotForm=new SettingColumnPlotAxisOptionsForm(model);
		
		SettingColumnPlotAxisOptionsController setColumnPC=new SettingColumnPlotAxisOptionsController(columnPlotForm.getModel());
		
		
		assertTrue(setColumnPC.act(columnPlotForm));
	}

}
