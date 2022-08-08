/*
 * Jacky Li
 * 2021/ 10/ 03
 * This program is testing the bottons on a machine.
 * If the buttons are all green, it prints "All System Go!".
 * If there is one or more bottons are red, it prints "Danger Error!". 
 * If there is any buttons that are orange, which means they haven't been determined, then the system prints "Waiting...".
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/***********************************************************************************
 * This is a program that is pretending to be a bunch of control buttons on 
 * some sort of machine (e.g. a nuclear reactor).
 *
 * TODO:
 * (1) First read over all of the code here and write down anything that you don't
 *     understand, or that you do understand but that is new to you. 
 *     Add these things as comments at the bottom of this program.
 *  
 * (2) if ALL the buttons are GREEN, then when you press the TEST button, it
 *     should say "All Systems Go"
 * (3) if ANY of the buttons are RED, then when you press the TEST button, it
 *     should say "DANGER ERROR!"
 *     Any other situation will just display the current default message "Waiting..."
 *
 *     Write the code for (2) and (3) in the testButtons() method below.
 *     This is the only part that needs to be modified. 
 * (4) Do this using a for loop. Then you can change N to be 10 and your program will still work.
 * 	  Marks: no for loop = 70%,  works with any number of buttons = 100%
 * 
 *  
 * (Other) There is probably a better way to do this than make an array of buttons 
 *     AND an array of status ints. If you want to improve this and make it
 *     more elegant, go ahead but save everything you've done in (1), (2) and (3)
 *     first. Maybe modify the filename for your new experimental version. 
 *
 * Date: April 2014
 * @author Mr. Harwood
 * @version 1.1
 ************************************************************************************/
// Note: Javadoc must be run using -author and -version
public class SystemCheck extends JFrame {
	static final int N = 10; // number of buttons

	/**
The main class just calls the constructor
	 */
	public static void main(String[] args) {
		new SystemCheck();
	}

	/** label to indicate status */
	JLabel lblStatus;
	/** button to test status */
	JButton btnTest;
	/** array of buttons to display */
	JButton[] btns = new JButton[N];
	/** integer array to control status of each light.
0= green, 1 = orange, 2 = red */
	int[] status = new int[N];

	/** sets up JFrame and JButtons
calls inner class ButtonListener.<br>
The ButtonListener is added to btnTest as well as btns[] */
	SystemCheck() {
		this.setTitle("System Check ...");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel(new GridLayout(1,6,3,2));
		panel.setBackground(Color.BLUE);

		ButtonListener bl = new ButtonListener();
		for (int i=0; i < N; i++) {
			btns[i] = new JButton(""+i);
			btns[i].addActionListener(bl);
			setButtons("" + i);
			panel.add(btns[i]);
		}

		JPanel panel2 = new JPanel();
		btnTest = new JButton("TEST");
		btnTest.addActionListener(bl);
		lblStatus = new JLabel("nothing to report");
		lblStatus.setBackground(Color.WHITE);
		lblStatus.setOpaque(true);
		panel2.add(btnTest);
		panel2.add(lblStatus);
		this.add(panel,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/** inner class to implement ActionListener */
	private class ButtonListener implements ActionListener {

		/** method to handle button clicking.
Calls: testButtons(), setButtons()
@param e the actionEvent created when any button is clicked */
		public void actionPerformed (ActionEvent e) {
			if (e.getSource() == btnTest) {
				testButtons();
			} else {
				setButtons(e.getActionCommand());
			}		
		}
	}
	/**
Purpose: Changes the colours of the buttons based on the value of status[].
  Status[] is incremented each time that that button is clikced.
Called from: actionPerformed
@param  cmd The number on the button
	 */
	void setButtons(String cmd){
		int n = Integer.parseInt(cmd);
		status[n]++;
		if (status[n] > 2) status[n] = 0;
		switch (status[n]){
		case 0:
			btns[n].setBackground(Color.GREEN);
			break;
		case 1:
			btns[n].setBackground(Color.ORANGE);
			break;
		case 2:
			btns[n].setBackground(Color.RED);
			break;
			// default: 
			// 	status[n] = 0;
			// 	btns[n].setBackground(Color.GREEN);
		}		
		// testButtons();
	}

	/** TODO: 
	 * This is the method that needs to be written to test <br>
(a) if all the buttons are green (say "All systems go!")<br>
(b) if there are one or more reds (say "Danger error!")<br>
The code should be done by checking the value of status.
Do your best to use a FOR LOOP intead of having to check 6 individual buttons.
What if here were 200 buttons to check?

Called from: actionPerformed()	*/
	void testButtons(){
		boolean ok;
		lblStatus.setText("Waiting ...."); //this is the default message

		for (int i = 0 ; i < N ; i++){
			if (status[i] == 0){
				lblStatus.setText("All System Go!!");
			}
		}

		for (int i = 0; i < N; i++){
			if (status[i] == 1){
				lblStatus.setText("Waiting ....");
			}
		}

		for (int i = 0 ; i < N ; i++){
			if (status[i] == 2){
				lblStatus.setText("Danger Error!");
			}
		}

		//1. check if all are green
		//If all 6 buttons are green display "All Systems Go!"


		//2. check if there is one or more red
		//If any light is red, then display "Danger Error!"


	}
}
/* Parts that I don't understand:
extends JFrame;
new Main()
switch, case, break
boolean
this.
 */