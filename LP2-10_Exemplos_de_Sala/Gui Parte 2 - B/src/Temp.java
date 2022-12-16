

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Temp extends JFrame {
		
	public Temp() {
		Container pane = this.getContentPane();

		JButton button = new JButton("Button 1 (PAGE_START)");
		pane.add(button, BorderLayout.PAGE_START);
	
		button = new JButton("Button 2 (CENTER)");
		button.setPreferredSize(new Dimension(200, 100));
		pane.add(button, BorderLayout.CENTER);

		button = new JButton("Button 3 (LINE_START)");
		pane.add(button, BorderLayout.LINE_START);

		button = new JButton("Long-Named Button 4 (PAGE_END)");
		pane.add(button, BorderLayout.PAGE_END);

		button = new JButton("5 (LINE_END)");
		pane.add(button, BorderLayout.LINE_END);
		
		
		
		GridLayout experimentLayout = new GridLayout(0,2);

		//...

		        pane.setLayout(experimentLayout);

		        pane.add(new JButton("Button 1"));
		        pane.add(new JButton("Button 2"));
		        pane.add(new JButton("Button 3"));
		        pane.add(new JButton("Long-Named Button 4"));
		        pane.add(new JButton("5"));
		        
		        
		        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		        pane.add(new JButton("Button 1"));
		        //...
	}

}
