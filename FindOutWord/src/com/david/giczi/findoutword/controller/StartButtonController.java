package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.david.giczi.findoutword.model.WordAdmin;
import com.david.giczi.findoutword.view.ControlPanel;


public class StartButtonController implements ActionListener {

	private ControlPanel control;
	
	
	
	public StartButtonController(ControlPanel control) {
		
		this.control=control;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(control.getLogic().getTheWord()==null) {
			
			control.getLogic().init();
			
			String theWord=new WordAdmin().choosenWord();
			
			if(!"EmptyList".equals(theWord)) {
				
			control.getLogic().setTheWord(theWord);
			control.getLogic().setChars(theWord);
			control.getDisplayer().displayWord(theWord);
			control.getTimer().start();
	
			buttonsEnabled();
			
			}
			else {
				
				control.infoPanel("The list of the words is empty. You should add words to the list.");
				control.getTimer().stop();
			}
						
			return;
			}
	
			
		if(control.getTimer().isRunning()) {
			
			control.displaySeconds(control.getLogic().getSecondCounter());
			int secondCounter=control.getLogic().getSecondCounter()+1;
			control.getLogic().setSecondCounter(secondCounter);
			
		}
		
		else {
			
			control.getTimer().start();
			
			buttonsEnabled();
			
			
		}
		
	}
		
		
	private void buttonsEnabled() {
		
		control.getStart().setEnabled(false);
		control.getStop().setEnabled(true);
		control.getSendLetter().setEnabled(true);
		control.getSendWord().setEnabled(true);
		control.getNewWord().setEnabled(true);
	}
	
		
	}

	
	
	
	

