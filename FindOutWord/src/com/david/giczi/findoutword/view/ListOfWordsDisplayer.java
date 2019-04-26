package com.david.giczi.findoutword.view;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.david.giczi.findoutword.model.WordAdmin;

public class ListOfWordsDisplayer {

	
	public ListOfWordsDisplayer() {
		
		JFrame frame=new JFrame("List of Words");
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		new WordAdmin();
		
		List<String> words=WordAdmin.getWords();
		
		frame.setSize(600, 66+words.size()*14);
		
		String[][] wordsArray=new String[words.size()][2];
		
		for (int i=0; i<words.size(); i++) {
			
			wordsArray[i][0]=String.valueOf(i+1);
			wordsArray[i][1]=words.get(i);
			
		}
		
		String[] column= {"NUMBER", "WORD"};
		
		JTable table=new JTable(wordsArray, column);
		table.setBackground(Color.WHITE);      
		table.setForeground(Color.RED); 
		
		JScrollPane pane=new JScrollPane(table);
		
		frame.add(pane);
		
		frame.setVisible(true);
	}
	
	
}
