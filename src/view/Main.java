package view;

import javax.swing.JApplet;

//import model.CatersianGraph;
//import model.ColumnGraph;
import model.Model;
//import model.TDGraph;

//import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame {

	/**
	 * Create the applet.
	 */
	Model model=new Model();
	DataSetViewForm panel;
	
	public static void main (String[] args){
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
	
	public Main() {
		setBounds(0,0, 800,500);
		panel = new DataSetViewForm(model);
		
		
		/*Don't change it! please*/
		//TDGraph graph=(TDGraph) new CatersianGraph(model);
		
		/**/
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 691, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 361, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		

	}

	public DataSetViewForm getDataSetViewForm() {
		return panel;
	}
	
	public Model getModel() {
		return this.model;
		
	}
}
