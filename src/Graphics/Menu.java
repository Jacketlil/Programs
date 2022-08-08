package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Java program to construct
//Menu bar to add menu items

public class Menu extends JFrame implements ActionListener{
	// menubar
	static JMenuBar mb;

	// JMenu
	static JMenu x, x1;

	// Menu items
	static JMenuItem m1, m2, m3, s1, s2;

	// create a frame
	static JFrame f;
	
	static JLabel l;
	
	
	public static void main(String[] args)
	{
		new Menu();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		l.setText(s + " is selected");
	}
	Menu(){
		// create a frame
				f = new JFrame("Menu demo");
	


				// create a menubar
				mb = new JMenuBar();

				// create a menu
				x = new JMenu("Menu");
				x1 = new JMenu("SubMenu");

				// create menuitems
				m1 = new JMenuItem("Menu Item1");
				m2 = new JMenuItem("Menu Item2");
				m3 = new JMenuItem("Menu Item3");
				s1 = new JMenuItem("SubMenu Item1");
				s2 = new JMenuItem("SubMenu Item2");

				// add menu items to menu
				x.add(m1);
				x.add(m2);
				x.add(m3);
				
				x1.add(s1);
				x1.add(s2);
				m1.addActionListener(this);
				m2.addActionListener(this);
				m3.addActionListener(this);
				s1.addActionListener(this);
				s2.addActionListener(this);
				
				l = new JLabel ("Nothing is selected");
				
				x.add(x1);

				// add menu to menu bar
				mb.add(x);

				// add menubar to frame
				f.setJMenuBar(mb);
				f.add(l);

				// set the size of the frame
				f.setSize(500, 500);
				f.setVisible(true);
	}
}