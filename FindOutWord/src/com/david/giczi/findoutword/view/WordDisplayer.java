package com.david.giczi.findoutword.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WordDisplayer {

	
	private JFrame frame;
	private JButton[] word;
	


	public void displayWord(String word) {
		
		Font font=new Font("Books Antiqua", Font.BOLD, 40);
		
		int n=word.length();
		
		frame=new JFrame("Find Out the Word");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.setSize(n*100, 100);
		
		int x=(Toolkit.getDefaultToolkit().getScreenSize().width-frame.getWidth())/2;
		int y=(Toolkit.getDefaultToolkit().getScreenSize().height-700)/2;
		
		frame.setLocation(x,y);
		frame.setLayout(new GridLayout(1, n));
		
		this.word=new JButton[n];
		
		for (int i=0; i<this.word.length; i++) {
			
			this.word[i]=new JButton();
			
			this.word[i].setFont(font);
			
			this.word[i].setBackground(Color.WHITE);
			
			frame.add(this.word[i]);
		}
		
		frame.setVisible(true);
	}
	
	
	public void showLetter(String theWord, boolean[] isShowChar) {
		
		for(int i=0; i<isShowChar.length; i++) {
			
			if(isShowChar[i]) {
				
			this.word[i].setText(String.valueOf(theWord.charAt(i)));
				
			}
			
		}
		
	}
	
	
	public void destroyWordPanel() {
		frame.setVisible(false);
		frame=null;
	}

	
	
}
