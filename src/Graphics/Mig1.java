package Graphics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Mig1 {

	public static void main(String[] args) {
		new Mig1();
	}
	
	JLabel settingsLabel = new JLabel("Dashboard Settings");
    JLabel nameLabel = new JLabel("Name:");
    JLabel zipLabel = new JLabel("Zip Code:");
    JLabel emailLabel = new JLabel("Email:");
    JLabel avatarLabel = new JLabel("Avatar Image:");
    
    JTextField fNameField = new JTextField("10",10);
    JTextField mNameField = new JTextField("1",1);
    JTextField lNameField = new JTextField("15",15);
    JTextField zipField = new JTextField("5", 5);
    JTextField emailField = new JTextField("20", 20);
    JTextField avatarField = new JTextField("30", 30);
    
    JButton okBttn = new JButton("Ok");
    JButton cancelBttn = new JButton("Cancel");
    JButton helpBttn = new JButton("Help");
    
	Mig1() {
		JFrame frame = new JFrame("Mig layout");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		frame.add(buildMigDashboard());		
		frame.setSize(600, 500); //may not be needed since my JPanel has a preferred size
		frame.setResizable(true);
		frame.setLocationRelativeTo( null );
		frame.pack();
		frame.setVisible(true);
	}

	private JPanel buildMigDashboard() {
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout());
        buildMiGForm(panel);
        return panel;
    }
	
	private void buildMiGForm(JPanel panel) {
        panel.add(settingsLabel, "span, center, gapbottom 15");
        panel.add(nameLabel, "align label");
        panel.add(fNameField);
        panel.add(mNameField);

        //wrap keyword starts a new row (after this element)
        panel.add(lNameField, "wrap");

        //align label triggers platform-specific label alignment
        panel.add(zipLabel, "align label");
        panel.add(zipField, "wrap");
                
        panel.add(emailLabel,"align label");
        panel.add(emailField, "span"); //span keyword lets emailField use the rest of the row
        
        panel.add(avatarLabel, "align label");
        panel.add(avatarField, "span");

        //tag identifies the type of button
        panel.add(okBttn, "span, split 3, sizegroup bttn");

        //sizegroups set all members to the size of the biggest member
        panel.add(cancelBttn, "sizegroup bttn");
        panel.add(helpBttn, "sizegroup bttn");
    }
}
