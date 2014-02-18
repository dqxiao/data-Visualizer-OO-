package view;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;

import controller.SettingColumnPlotAxisOptionsController;
import model.Model;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/*each application applet should have a reference to the model, otherwise how can them change the options */

public class SettingColumnPlotAxisOptionsForm extends JDialog {

	Model model;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	JTextField maxInput;
	JTextField minInput;
	JTextField stepInput;
	JCheckBox chckbxShowaxis;
	JCheckBox chckbxShowlabel;
	JCheckBox chckbxShowgrouplabel;
	
	
	
	/*
	 * Launch the application.
	 */
	

	/*
	 * Create the dialog.
	 */
	
	
	public SettingColumnPlotAxisOptionsForm(Model model) {
		
		/*keep an reference of the model information*/
		this.model=model;
		
		JLabel lblScale = new JLabel("Scale");
		
		JLabel lblMax = new JLabel("MAX");
		
		maxInput = new JTextField();
		maxInput.setColumns(10);
		
		JLabel lblMin = new JLabel("MIN");
		
		minInput = new JTextField();
		minInput.setColumns(10);
		
		JLabel lblStep = new JLabel("Step");
		
		stepInput = new JTextField();
		stepInput.setColumns(10);
		
		
		
		
		chckbxShowaxis = new JCheckBox("ShowAxis");
		
		chckbxShowlabel = new JCheckBox("ShowYLabel");
		
		chckbxShowgrouplabel = new JCheckBox("ShowGroupLabel");
		
		/*init_check status*/
		
		chckbxShowaxis.setSelected(model.getYAxisOptions().getShowAxis());
		chckbxShowlabel.setSelected(model.getYAxisOptions().getShowLabel());
		chckbxShowgrouplabel.setSelected(model.getXAxisOptions().getShowLabel());
		
		
		/**/
		if(model.getXAxisOptions().getautoSize()){
			
			maxInput.setText("auto");
			minInput.setText("auto");
			
			stepInput.setText("1");
			
		}
		
		
		
		
		
		/*don't change the lay out */
		setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblScale, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(198)
							.addComponent(lblStep))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblMax)
							.addGap(18)
							.addComponent(maxInput, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(108)
							.addComponent(stepInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblMin)
							.addGap(21)
							.addComponent(minInput, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(14)
							.addComponent(chckbxShowaxis)
							.addGap(37)
							.addComponent(chckbxShowlabel)
							.addGap(18)
							.addComponent(chckbxShowgrouplabel)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblScale)
						.addComponent(lblStep))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblMax))
						.addComponent(maxInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(stepInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMin)
						.addComponent(minInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxShowaxis)
						.addComponent(chckbxShowlabel)
						.addComponent(chckbxShowgrouplabel))
					.addGap(29))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//change the model show Axis options 
						//
						new SettingColumnPlotAxisOptionsController(SettingColumnPlotAxisOptionsForm.this.model).act(SettingColumnPlotAxisOptionsForm.this);
						
						
						//setModal(false);
						SettingColumnPlotAxisOptionsForm.this.dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//setModal(false);
						SettingColumnPlotAxisOptionsForm.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		/*don't change the lay out*/
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public Model getModel(){
		return this.model;
	}
	
	public JTextField getMaxInput(){
		return this.maxInput;
	}
	
	public JTextField getMinInput(){
		return this.minInput;
	}
	
	public JTextField getStepInput(){
		return this.stepInput;
	}
	
	public JCheckBox getShowLabel(){
		return this.chckbxShowlabel;
	}
	
	public JCheckBox getShowAxis(){
		return this.chckbxShowaxis;
	}
	
	public JCheckBox getShowGroupLabel(){
		return this.chckbxShowgrouplabel;
	}
}
