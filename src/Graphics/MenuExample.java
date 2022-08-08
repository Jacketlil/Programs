package Graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class MenuExample implements ActionListener{    
	
	public static void main(String[] args) {    
		new MenuExample();    
	}    
	
	JFrame window;    
	JMenuBar menuBar;    
	JMenu edit, color;    
	JMenuItem cut, copy, paste, selectAll, red, blue, orange, pink, black;    
	JTextArea textArea;    

	MenuExample(){    
		window = new JFrame();    
		cut = new JMenuItem("cut");    
		copy = new JMenuItem("copy");    
		paste = new JMenuItem("paste");    
		selectAll = new JMenuItem("selectAll"); 
		red = new JMenuItem("red");
		blue = new JMenuItem("blue");
		orange = new JMenuItem("orange");
		pink = new JMenuItem("pink");
		black = new JMenuItem("black");
		
		cut.addActionListener(this);    
		copy.addActionListener(this);    
		paste.addActionListener(this);    
		selectAll.addActionListener(this);  
		red.addActionListener(this);
		blue.addActionListener(this);
		orange.addActionListener(this);
		pink.addActionListener(this);
		black.addActionListener(this);
		
		menuBar = new JMenuBar();
		
		edit = new JMenu("Edit");  
		color = new JMenu("Color");
		
		color.add(black);
		color.add(red);
		color.add(blue);
		color.add(orange);
		color.add(pink);
		
		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectAll);    
		edit.add(color);
		
		menuBar.add(edit);
		
		textArea = new JTextArea(); 
		
		window.add(menuBar);
		window.add(textArea);    
		window.setJMenuBar(menuBar);  
		window.setSize(400,400);    
		window.setVisible(true);    
	}     
	public void actionPerformed(ActionEvent e) {    
		if(e.getSource() == cut) {   
			textArea.cut();    
		}
		if(e.getSource() == paste)   { 
			textArea.paste();   
		}
		if(e.getSource() == copy)  {  
			textArea.copy();    
		}
		if(e.getSource() == selectAll) {   
			textArea.selectAll();   
		}
		if (e.getSource() == red) {
			textArea.setForeground(Color.RED);
		}
		if (e.getSource() == orange) {
			textArea.setForeground(Color.ORANGE);
		}
		if (e.getSource() == blue) {
			textArea.setForeground(Color.BLUE);
		}
		if (e.getSource() == pink) {
			textArea.setForeground(Color.PINK);
		}
		if (e.getSource() == black) {
			textArea.setForeground(Color.BLACK);
		}
	}     
	
}    