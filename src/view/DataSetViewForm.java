package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import controller.AddRowController;
import controller.CartesianPlotController;
import controller.ChangeOptionsController;
import controller.ColumnPlotController;
import controller.LoadFileController;
import controller.RemoveSelectedRowsController;
import controller.SaveFileAsController;
import controller.UpdateRowController;
//import model.CatersianGraph;
//import model.ColumnGraph;
import model.Model;
//import model.TDGraph;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DataSetViewForm extends JPanel {
	
	Model model;
	JTextField textField;
	JList rowList;
	GraphicPanel panel;
	//JPanel panel;
	
	
	/**
	 * Create the panel.
	 */
	public DataSetViewForm(Model model) {
		
		//
		this.model=model;
		
		
		
		JLabel lblDatasetview = new JLabel("DataSetView");
		
		JLabel lblInputRow = new JLabel("Input Row:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddRowController(DataSetViewForm.this.model).act(DataSetViewForm.this);
			}
		});
		
		
		
		JButton btnRemoveSelected = new JButton("Remove Selected");
		btnRemoveSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveSelectedRowsController(DataSetViewForm.this.model).act(DataSetViewForm.this);
			}
		});
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateRowController(DataSetViewForm.this.model).act(DataSetViewForm.this);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		rowList = new JList();
		rowList.setModel(new DefaultListModel());
		scrollPane.setViewportView(rowList);
		
		JButton btnSaveFileAs = new JButton("Save file As");
		btnSaveFileAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// waiting for me 
				new SaveFileAsController(DataSetViewForm.this.model).act(DataSetViewForm.this);
			}
		});
		
		JButton btnLoadFile = new JButton("Load file");
		btnLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoadFileController(DataSetViewForm.this.model).act(DataSetViewForm.this);
			}
		});
		
		/**/
		
		panel=new GraphicPanel(DataSetViewForm.this.model);
		panel.setVisible(true);
		//panel=new JPanel();
		
		/*Lay out don't */
		
		JButton btnColumnplot = new JButton("ColumnPlot");
		btnColumnplot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//**/
				
				new ColumnPlotController(DataSetViewForm.this.model).act(DataSetViewForm.this);
				/**/
			}
		});
		
		JButton btnCartersianplot = new JButton("CartersianPlot");
		btnCartersianplot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CartesianPlotController(DataSetViewForm.this.model).act(DataSetViewForm.this);
			}
		});
		
		JButton btnChangeAxisoptions = new JButton("Change AxisOptions");
		btnChangeAxisoptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(DataSetViewForm.this.model.getGraphtype()==1){
					SettingColumnPlotAxisOptionsForm setForm=new SettingColumnPlotAxisOptionsForm(DataSetViewForm.this.model);
					setForm.setModal(true);
					setForm.setVisible(true);
				}
				
				if(DataSetViewForm.this.model.getGraphtype()==2){
					SettingCatersianPlotAxisOptionsForm setForm=new SettingCatersianPlotAxisOptionsForm(DataSetViewForm.this.model);
					setForm.setModal(true);
					setForm.setVisible(true);
				}
				
				
				ChangeOptionsController coc=new ChangeOptionsController(DataSetViewForm.this.model);
				coc.act(DataSetViewForm.this);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblDatasetview, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
										.addComponent(scrollPane, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
									.addGap(26)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnRemoveSelected)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnLoadFile)
												.addComponent(btnSaveFileAs)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(btnCartersianplot)
													.addComponent(btnColumnplot)))))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnChangeAxisoptions)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(74)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblInputRow)
							.addGap(12)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdate)))
					.addGap(110))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblDatasetview, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(42)
									.addComponent(btnRemoveSelected)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSaveFileAs)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLoadFile)
									.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
									.addComponent(btnColumnplot)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCartersianplot)
									.addGap(18)
									.addComponent(btnChangeAxisoptions)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAdd)
								.addComponent(btnUpdate)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInputRow))))
					.addGap(29))
		);
		
		
		setLayout(groupLayout);

	}
	
	public JTextField getTextField(){
		return textField;
	}
	
	public JList getJList(){
		return rowList;
		
	}
	
	public GraphicPanel getGraphicPanel(){
		return panel;
	}
	
	public Model getModel(){
		return model;
	}
	
	
	
}
