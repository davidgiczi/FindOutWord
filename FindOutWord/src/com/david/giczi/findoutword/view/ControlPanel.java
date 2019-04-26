package com.david.giczi.findoutword.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.david.giczi.findoutword.controller.AddWordController;
import com.david.giczi.findoutword.controller.CheckboxController;
import com.david.giczi.findoutword.controller.DeleteWordController;
import com.david.giczi.findoutword.controller.DeleteWordListController;
import com.david.giczi.findoutword.controller.ExitButtonController;
import com.david.giczi.findoutword.controller.NewWordController;
import com.david.giczi.findoutword.controller.SendLetterController;
import com.david.giczi.findoutword.controller.SendResultWordController;
import com.david.giczi.findoutword.controller.ShowWordListController;
import com.david.giczi.findoutword.controller.StartButtonController;
import com.david.giczi.findoutword.controller.StopButtonController;
import com.david.giczi.findoutword.model.FindOutWordLogic;

public class ControlPanel {

	
	private JFrame frame=new JFrame("Find Out the Word - Control Panel");
	private JButton start=new JButton("Start");
	private JButton stop=new JButton("Stop");
	private JButton newWord=new JButton("New Word");
	private JButton exit=new JButton("Exit");
	private JButton sendLetter=new JButton("Send");
	private JButton sendResult=new JButton("Send");
	private JTextField tipp=new JTextField(40);
	private JTextField letter=new JTextField(5);
	private JTextField letters=new JTextField(50);
	private JCheckBox check=new JCheckBox("Show tipps", true);
	private FindOutWordLogic logic=new FindOutWordLogic();
	private WordDisplayer displayer=new WordDisplayer();
	private JMenuBar menuBar=new JMenuBar();
	private JMenu menu=new JMenu("Options");
	private JMenu rankList=new JMenu("Rank List");
	private JMenuItem showResultList=new JMenuItem("Show the List");
	private JMenuItem delResultList=new JMenuItem("Delete the List");
	private JMenu wordOperation=new JMenu("Word Operations");
	private JMenuItem addWord=new JMenuItem("Add a Word");
	private JMenuItem delWord=new JMenuItem("Delete a Word");
	private JMenuItem showWordList=new JMenuItem("Show the List");
	private JMenuItem delWordList=new JMenuItem("Delete the List");
	private Timer timer=new Timer(1000, new StartButtonController(this));
	private String inputWord;
	
	
	public ControlPanel() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		rankList.add(showResultList);
		rankList.add(delResultList);
		menu.add(rankList);
		wordOperation.add(addWord);
		wordOperation.add(delWord);
		wordOperation.add(showWordList);
		wordOperation.add(delWordList);
		menu.add(wordOperation);
		menuBar.add(menu);
	
		menuBar.setBackground(new Color(255, 255, 255));
		
		frame.setJMenuBar(menuBar);
		
		frame.setSize(900, 300);
		
		int x=(Toolkit.getDefaultToolkit().getScreenSize().width-frame.getWidth())/2;
		int y=(Toolkit.getDefaultToolkit().getScreenSize().height-500)/2;
		
		frame.setLocation(x,y);
		
		frame.setLayout(new GridLayout(4, 1));
		
		JPanel[] panels=new JPanel[4];
		
		JLabel tippLabel=new JLabel("Tipp of a Letter");
		JLabel resultLabel=new JLabel("Result of the Word");
		
		tippLabel.setForeground(new Color(255, 255, 255));
		resultLabel.setForeground(new Color(255, 255, 255));
		sendLetter.setBackground(new Color(255, 255, 255));
		sendResult.setBackground(new Color(255, 255, 255));
		check.setBackground(new Color(255, 255, 255));
		start.setBackground(new Color(255, 255, 255));
		stop.setBackground(new Color(255, 255, 255));
		newWord.setBackground(new Color(255, 255, 255));
		exit.setBackground(new Color(255, 255, 255));
		letters.setBackground(new Color(255, 255, 255));
		letters.setFont(new Font("Times new Roman", Font.BOLD, 20));
		letters.setEditable(false);
		sendLetter.setEnabled(false);
		sendResult.setEnabled(false);
		stop.setEnabled(false);
		newWord.setEnabled(false);
		
		for (int i=0; i<panels.length; i++) {
			panels[i]=new JPanel();
			panels[i].setBackground(new Color(115, 123, 50));
		}
		
		panels[0].add(tippLabel);
		panels[0].add(letter);
		panels[0].add(sendLetter);
		
		panels[1].add(resultLabel);
		panels[1].add(tipp);
		panels[1].add(sendResult);
		
		panels[2].add(letters);
		panels[2].add(check);
		
		panels[3].add(start);
		panels[3].add(stop);
		panels[3].add(newWord);
		panels[3].add(exit);
		
		
		sendLetter.addActionListener(new SendLetterController(this));
		sendResult.addActionListener(new SendResultWordController(this));
		check.addActionListener(new CheckboxController(this));
		start.addActionListener(new StartButtonController(this));
		stop.addActionListener(new StopButtonController(this));
		newWord.addActionListener(new NewWordController(this));
		exit.addActionListener(new ExitButtonController(this));
		addWord.addActionListener(new AddWordController(this));
		delWord.addActionListener(new DeleteWordController(this));
		delWordList.addActionListener(new DeleteWordListController(this));
		showWordList.addActionListener(new ShowWordListController(this));
		
		frame.add(panels[0]);
		frame.add(panels[1]);
		frame.add(panels[2]);
		frame.add(panels[3]);
		
		frame.setVisible(true);
	}

	
	public boolean approvingPanel(String text) {
		
		
		if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(frame, text, "Find Out the Word", JOptionPane.YES_OPTION)) {
			
			return true;
		}
			
				
		return false;
		
	}

	public void inputWordPanel(String text) {
		
		inputWord=JOptionPane.showInputDialog(text).trim();
		
	}
	
	public void infoPanel(String text) {
		
		JOptionPane.showMessageDialog(frame, text , "Find out a Word", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void displaySeconds(int secCounter) {
		
		
		int min=secCounter/60;
		int sec=secCounter%60;
		String timeText=sec<10  ? min+":0"+sec : +min+":"+sec;

		frame.setTitle("Find Out the Word - "+timeText);
		
	}
	
	
	public JFrame getFrame() {
		return frame;
	}


	public JButton getStart() {
		return start;
	}


	public JButton getStop() {
		return stop;
	}


	public JButton getNewWord() {
		return newWord;
	}


	public JButton getExit() {
		return exit;
	}


	public JButton getSendLetter() {
		return sendLetter;
	}


	public JButton getSendWord() {
		return sendResult;
	}


	public JTextField getTipp() {
		return tipp;
	}


	public JTextField getLetter() {
		return letter;
	}


	public JTextField getLetters() {
		return letters;
	}


	public JCheckBox getCheck() {
		return check;
	}
	
	
	public FindOutWordLogic getLogic() {
		return logic;
	}

	
	public WordDisplayer getDisplayer() {
		return displayer;
	}


	public Timer getTimer() {
		return timer;
	}


	public String getInputWord() {
		return inputWord;
	}


	

	
	
	
}
