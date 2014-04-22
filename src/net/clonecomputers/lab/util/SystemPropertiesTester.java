package net.clonecomputers.lab.util;

import java.util.*;
import java.util.List;
import java.util.Map.Entry;

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
		List<Map.Entry<Object, Object>> propsList = new ArrayList<Map.Entry<Object, Object>>(props.entrySet());
		Collections.sort(propsList, new Comparator<Map.Entry<Object,Object>>() {
			@Override
			public int compare(Map.Entry<Object, Object> arg0,
					Map.Entry<Object, Object> arg1) {
				return arg0.getKey().toString().compareTo(arg1.getKey().toString());
			}
		});
		for(Map.Entry<Object, Object> p: propsList) {
			text.append(p.getKey().toString());
			text.append(": \u201C");
			text.append(p.getValue().toString());
			text.append("\u201D\n");
		}
		//text.setText(str.toString());
		text.setEditable(false);
		text.setLineWrap(false);
		text.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(text),BorderLayout.CENTER);
	}

}
