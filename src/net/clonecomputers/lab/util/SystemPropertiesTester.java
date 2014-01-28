package net.clonecomputers.lab.util;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class SystemPropertiesTester extends JPanel {

	public static void main(String[] args) {
		SystemPropertiesTester props = new SystemPropertiesTester();
		JFrame window = new JFrame("System Properties");
		window.setContentPane(props);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}
	
	public SystemPropertiesTester() {
		Properties props = System.getProperties();
		JTextArea text = new JTextArea(100,100);
		for(Map.Entry<Object, Object> p: props.entrySet()) {
			text.append(p.getKey().toString());
			text.append(": ");
			text.append(p.getValue().toString());
			text.append("\n");
		}
		//text.setText(str.toString());
		text.setEditable(false);
		text.setLineWrap(false);
		text.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(text),BorderLayout.CENTER);
	}

}
