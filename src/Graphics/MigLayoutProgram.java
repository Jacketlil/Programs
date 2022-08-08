/*
 * Jacky Li
 * 2021/10/08
 * This program is creating an ordering page in which users can order bubble tea 
 * with different combo.
 */
package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import net.miginfocom.swing.MigLayout;

public class MigLayoutProgram{

	public static void main(String[] args) {
		new MigLayoutProgram();

	}

	//declare variables
	JFrame window = new JFrame();

	JLabel settingLabel = new JLabel ("Bubble Tea Delivery");
	JLabel nameLabel = new JLabel ("Name: ");
	JLabel phoneLabel = new JLabel ("Phone: ");
	JLabel addressLabel = new JLabel ("Address: ");
	JLabel output = new JLabel ("Price: ");

	Font titleFont = new Font ("TimesRoman", Font.BOLD, 24);
	Font textFont = new Font ("TimesRoman", Font.BOLD, 18);

	JTextField nameField = new JTextField("", 20);
	JTextField phoneField = new JTextField("", 10);
	JTextField addressField = new JTextField("", 20);

	JRadioButton small = new JRadioButton ("Small");
	JRadioButton medium = new JRadioButton ("Medium");
	JRadioButton large = new JRadioButton ("Large");

	JRadioButton regular = new JRadioButton ("Regular Bubble Tea");
	JRadioButton matcha = new JRadioButton ("Matcha Bubble Tea");
	JRadioButton brownsugar = new JRadioButton ("Brown Sugar Bubble Tea");

	JRadioButton level100 = new JRadioButton ("100%");
	JRadioButton level75 = new JRadioButton ("75%");
	JRadioButton level50 = new JRadioButton ("50%");
	JRadioButton level25 = new JRadioButton ("25%");

	JCheckBox cream = new JCheckBox ("Cream");
	JCheckBox boba = new JCheckBox ("Extra Boba");
	JCheckBox jelly = new JCheckBox ("Jelly");

	JPanel sizePanel = new JPanel();
	JPanel stylePanel = new JPanel();
	JPanel toppingPanel = new JPanel();
	JPanel sugarPanel = new JPanel();

	JButton okBttn = new JButton ("OK");
	JButton closeBttn = new JButton ("Close");


	MigLayoutProgram(){
		window.setTitle("Bubble Tea Delivery");
		window.setSize(800,700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(true);
		window.add(MigLayoutBoard());
		window.pack();
		window.setVisible(true);
	}

	private JPanel MigLayoutBoard() {
		JPanel panel = new JPanel ();
		panel.setLayout(new MigLayout("insets 10"));
		MigForm(panel);
		return panel;
	}

	private void MigForm(JPanel panel) {
		
		//set the font of the title and the text
		settingLabel.setFont(titleFont);
		nameLabel.setFont(textFont);
		phoneLabel.setFont(textFont);
		addressLabel.setFont(textFont);
		
		//set the color of the text
		nameLabel.setForeground(Color.red);
		phoneLabel.setForeground(Color.red);
		addressLabel.setForeground(Color.red);
		
		//adding title
		panel.add(settingLabel, "span, align center");
		
		//adding name label and name textfield
		panel.add (nameLabel, "align label");
		panel.add (nameField, "wrap");
		
		//adding phone label and phone textfield
		panel.add (phoneLabel, "align label");
		panel.add (phoneField, "wrap");

		//adding name label and textfield
		panel.add (addressLabel, "align label");
		panel.add (addressField, "wrap");
		
		//add all size variables into a group
		ButtonGroup size = new ButtonGroup();
		size.add (small);
		size.add (medium);
		size.add (large);

		//add all style variables into a group
		ButtonGroup style = new ButtonGroup();
		style.add (regular);
		style.add (matcha);
		style.add (brownsugar);

		//add all sugar level variables into a group
		ButtonGroup sugarlevel = new ButtonGroup();
		sugarlevel.add(level100);
		sugarlevel.add(level75);
		sugarlevel.add(level50);
		sugarlevel.add(level25);
		
		/* setting new gridLayout for the size panel
		 * adding all size variables
		 * setting a border for the size panel
		 */
		sizePanel.setLayout(new GridLayout(3,1));
		sizePanel.add (small);
		sizePanel.add (medium);
		sizePanel.add (large);
		sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));

		/* setting new gridLayout for the style panel
		 * adding all style variables
		 * setting a border for the style panel
		 */
		stylePanel.setLayout(new GridLayout(3,1));
		stylePanel.add (regular);
		stylePanel.add (matcha);
		stylePanel.add(brownsugar);
		stylePanel.setBorder(BorderFactory.createTitledBorder("Style"));

		/* setting new gridLayout for the topping panel
		 * adding all topping variables
		 * setting a border for the topping panel
		 */
		toppingPanel.setLayout(new GridLayout(3,1));
		toppingPanel.add (cream);
		toppingPanel.add (boba);
		toppingPanel.add (jelly);
		toppingPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));

		/* setting new gridLayout for the sugar level panel
		 * adding all sugar level variables
		 * setting a border for the sugar level panel
		 */
		sugarPanel.setLayout(new GridLayout(2,2));
		sugarPanel.add(level100);
		sugarPanel.add(level75);
		sugarPanel.add(level50);
		sugarPanel.add(level25);
		sugarPanel.setBorder(BorderFactory.createTitledBorder("Sugar Level"));
		
		//adding all variables into the panel with MigLayout
		panel.add (sizePanel, "align center");
		panel.add (stylePanel, "align center, wrap");
		panel.add (toppingPanel, "align center");
		panel.add (sugarPanel, "align center, wrap");

		panel.add (output);
		panel.add (okBttn, " split 2, align right, sizegroup bttns");
		panel.add (closeBttn, "sizegroup bttns");
	}
}