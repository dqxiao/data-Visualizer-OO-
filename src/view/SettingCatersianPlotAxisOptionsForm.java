package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import controller.SettingCatersianPlotAxisOptionsController;
import model.Model;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingCatersianPlotAxisOptionsForm extends JDialog {

	Model model;
	private final JPanel contentPanel = new JPanel();
	JPanel buttonPane;
	JTextField xMaxInput;
	JTextField xMinInput;
	JTextField xStepInput;
	JTextField yMaxInput;
	JTextField yMinInput;
	JTextField yStepInput;
	JCheckBox chckbxShowYaxis;
	JCheckBox chckbxShowTendency;
	JCheckBox chckbxShowEquation;
	JCheckBox chckbxShowXLabel;
	JCheckBox chckbxShowYLabel;

	/**
	 * Create the dialog.
	 */
	public SettingCatersianPlotAxisOptionsForm(Model model) {
		
		/*get the reference of Model information*/
		this.model=model;
		
		
		setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/**/
						new SettingCatersianPlotAxisOptionsController(SettingCatersianPlotAxisOptionsForm.this.model).act(SettingCatersianPlotAxisOptionsForm.this);
						SettingCatersianPlotAxisOptionsForm.this.dispose(); /*disappear*/
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
						
						/*do nothing*/
						SettingCatersianPlotAxisOptionsForm.this.dispose(); /*disapperar*/
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		JLabel lblXAxis = new JLabel("X axis");
		
		JLabel lblMax = new JLabel("max");
		
		xMaxInput = new JTextField();
		xMaxInput.setColumns(10);
		
		JLabel lblMin = new JLabel("min");
		
		xMinInput = new JTextField();
		xMinInput.setColumns(10);
		
		JLabel lblStep = new JLabel("step");
		
		xStepInput = new JTextField();
		xStepInput.setColumns(10);
		
		JLabel lblYAxis = new JLabel("Y axis");
		
		JLabel label = new JLabel("max");
		
		yMaxInput = new JTextField();
		yMaxInput.setColumns(10);
		
		JLabel label_1 = new JLabel("min");
		
		yMinInput = new JTextField();
		yMinInput.setColumns(10);
		
		JLabel label_2 = new JLabel("step");
		
		yStepInput = new JTextField();
		yStepInput.setColumns(10);
		
		chckbxShowYaxis = new JCheckBox("Show Yaxis");
		
		chckbxShowTendency = new JCheckBox("show Tendency");
		
		chckbxShowEquation = new JCheckBox("Show Equation");

		chckbxShowXLabel = new JCheckBox("Show X Label");
		
		
		/*don't make change of layout */
		
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
		
		chckbxShowYLabel = new JCheckBox("Show Y Label");
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblXAxis)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblMax)
							.addGap(12)
							.addComponent(xMaxInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblMin)
							.addGap(18)
							.addComponent(xMinInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblStep)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(xStepInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(46)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(yMinInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(yMaxInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblYAxis)
								.addGap(147)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(yStepInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxShowTendency)
						.addComponent(chckbxShowYaxis))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(chckbxShowXLabel)
							.addGap(12)
							.addComponent(chckbxShowYLabel))
						.addComponent(chckbxShowEquation))
					.addGap(45))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXAxis)
						.addComponent(lblYAxis))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMax)
						.addComponent(xMaxInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(yMaxInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMin)
								.addComponent(xMinInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStep)
								.addComponent(xStepInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxShowYaxis)
								.addComponent(chckbxShowXLabel)
								.addComponent(chckbxShowYLabel)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(yMinInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(yStepInput, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
								.addComponent(label_2))
							.addGap(43)))
					.addGap(9)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxShowTendency)
						.addComponent(chckbxShowEquation)))
		);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}

	
	public JTextField getXMaxInput(){
		return this.xMaxInput;
	}
	
	public JTextField getXMinInput(){
		return this.xMinInput;
	}
	
	public JTextField getXStepInput(){
		
		return this.xStepInput;
	}
	
	public JTextField getYMaxInput(){
		return this.yMaxInput;
	}
	public JTextField getYMinInput(){
		return this.yMinInput;
	}
	
	
	public JTextField getYStepInput(){
		
		return this.yStepInput;
	}
	
	
	public JCheckBox getShowYaxis(){
		return this.chckbxShowYaxis;
	}
	
	public JCheckBox getShowTrendency(){
		return this.chckbxShowTendency;
	}
	
	public JCheckBox getShowXLabel(){
		return this.chckbxShowXLabel;
	}
	public JCheckBox getShowYLabel(){
		return this.chckbxShowYLabel;
	}
	
	public JCheckBox getShowEquation(){
		return this.chckbxShowEquation;
	}
	
	public Model getModel(){
		return this.model;
	}
	
	
	/*don't forget testing this methods*/
}
