package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tempForm extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public tempForm() {
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnRemoveSelected = new JButton("Remove Selected");
		
		JButton btnAdd = new JButton("ADD");
		
		JButton btnUpdate = new JButton("Update");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSaveFileAs = new JButton("Save file as");
		
		JButton btnUpload = new JButton("Upload");
		
		JPanel panel = new JPanel();
		
		JButton btnColumnplot = new JButton("ColumnPlot");
		
		JButton btnCartersianplot = new JButton("CartersianPlot");
		btnCartersianplot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnSettingproperties = new JButton("SettingProperties");
		
		JButton btnMuti = new JButton("MutipleLine");
		btnMuti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemoveSelected))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSaveFileAs))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnUpload))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAdd)
								.addComponent(btnUpdate))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(btnColumnplot)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCartersianplot)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnMuti))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(81)
							.addComponent(btnSettingproperties)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(btnRemoveSelected)
							.addGap(18)
							.addComponent(btnSaveFileAs)
							.addGap(18)
							.addComponent(btnUpload)))
					.addPreferredGap(ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnUpdate)
								.addComponent(btnSettingproperties))
							.addGap(14))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnColumnplot)
						.addComponent(btnCartersianplot)
						.addComponent(btnMuti))
					.addGap(35))
		);
		
		JList list = new JList();
		scrollPane.setRowHeaderView(list);
		setLayout(groupLayout);

	}
}
