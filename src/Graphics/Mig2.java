package Graphics;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Mig2 {
	
	public static void main(String[] args){
		new Mig2();
	}
	
	JPanel panel = new JPanel();
	public Mig2() {
		
			JFrame frame = new JFrame("Mig layout");
			frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//			Container content = frame.getContentPane();
			// content.setLayout(new BorderLayout(2,2));
//			content.add(panelTop, BorderLayout.NORTH);
			makeGUI();
			frame.add(panel);
			frame.setSize(600, 500); //may not be needed since my JPanel has a preferred size
			frame.setResizable(true);
			frame.setLocationRelativeTo( null );
			//frame.pack();
			frame.setVisible(true);
		
	}

	void makeGUI() {
		panel.setLayout(new MigLayout("wrap 5, insets 10"));
		
		panel.add(new JButton("col 1"));
		panel.add(new JButton("col 2"));
		panel.add(new JButton("col 3"));
		panel.add(new JLabel("col 4"));
		panel.add(new JButton("col 5")); //wraps after the 5th item
		
		panel.add(new JButton("next1"));
		panel.add(new JButton("next2"));
		panel.add(new JButton("first"), "cell 0 1");
		panel.add(new JButton("next3"));
		panel.add(new JButton("sized 4"),"height :50:80");
		panel.add(new JButton("next5"));
		
		panel.add(new JButton("done"), "wrap");
		panel.add(new JButton("sized 2"), "growx, growy");
		panel.add(new JButton("fifteen"), "sizegroup aaa");
		panel.add(new JButton("one14"), "sizegroup aaa, wrap 1"); //1 pixel below
		panel.add(new JButton("one"));
		panel.add(new JButton("one"));
		panel.add(new JButton("one"));		
		panel.add(new JButton("right"),"align right");
		panel.add(new JButton("one"));
		
		panel.add(new JButton("one"));
		panel.add(new JButton("done"), "span 2");
		panel.add(new JButton("one"));
		
		panel.add(new JButton("xne"), "span 1 2");
		panel.add(new JButton("one"));
		panel.add(new JButton("wrap here"), "wrap");
		panel.add(new JTextField("span"),"span"); //span fills up the rest of the line and then wraps
		panel.add(new JButton("one"));
		panel.add(new JButton("one"), "growx");
	}
	
	class MLabel extends JLabel{
		MLabel(String s) {
			super(s);
			this.setBackground(new Color(250,250,180));
			this.setOpaque(true);
		}
	}
}
