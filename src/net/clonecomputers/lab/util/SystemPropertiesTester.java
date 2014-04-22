package net.clonecomputers.lab.util;

import java.util.*;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.text.*;

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
		List<Map.Entry<Object, Object>> propsList = new ArrayList<Map.Entry<Object, Object>>(props.entrySet());
		Collections.sort(propsList, new Comparator<Map.Entry<Object,Object>>() {
			@Override
			public int compare(Map.Entry<Object, Object> arg0,
					Map.Entry<Object, Object> arg1) {
				return arg0.getKey().toString().compareTo(arg1.getKey().toString());
			}
		});
		JTextPane textArea = new JTextPane();
		StyledDocument document = textArea.getStyledDocument();
		Style keyStyle = document.addStyle("keyStyle", null);
		Style valueStyle = document.addStyle("valueStyle", null);
		Style textStyle = document.addStyle("textStyle", null);
		StyleConstants.setForeground(keyStyle, new Color(.3f,.5f,.1f));
		StyleConstants.setForeground(valueStyle, new Color(.0f,.0f,.8f));
		StyleConstants.setForeground(textStyle, Color.RED);
		StyleConstants.setLineSpacing(textStyle, 2f);
		try {
			for(Map.Entry<Object, Object> p: propsList) {
				document.insertString(document.getLength(), "[", textStyle);
				document.insertString(document.getLength(), p.getKey().toString(), keyStyle);
				document.insertString(document.getLength(), "] \u2192 [", textStyle);
				document.insertString(document.getLength(), p.getValue().toString(), valueStyle);
				document.insertString(document.getLength(), "]\n", textStyle);
			}
		} catch (BadLocationException e) {
			throw new RuntimeException(e);
		}
		textArea.setEditable(false);
		//textArea.setLineWrap(false);
		textArea.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(textArea),BorderLayout.CENTER);
	}

}
