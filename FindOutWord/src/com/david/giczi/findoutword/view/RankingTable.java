package com.david.giczi.findoutword.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class RankingTable {

	private JFrame frame;
	private String[] column= {"PLACE", "PLAYER'S NAME", "THE WORD", "GAME PERIOD [SEC]", "CLICKING NUMBER", "DATE"};
	
	public RankingTable(Object[][] data) {
		
		frame=new JFrame("Ranking List");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTable table=new JTable(data, column);
		table.setBackground(Color.WHITE);      
		table.setForeground(Color.RED); 
		
		JScrollPane pane=new JScrollPane(table);
		
		frame.add(pane);
		frame.setVisible(true);
		
	}
	
	
	
}
