package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.findoutword.view.ControlPanel;

public class SendResultWordController implements ActionListener {

	
	private ControlPanel control;
	
	public SendResultWordController(ControlPanel control) {
		this.control=control;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
				control.getLogic().setClickCounter(control.getLogic().getClickCounter()+1);
		
				String tipp=control.getTipp().getText();
				
				control.getTipp().setText("");
				
				if(tipp.trim().equals(control.getLogic().getTheWord())) {
					
					control.getTimer().stop();
					
					control.getDisplayer().showLetter(tipp, booleanArray(tipp));
						
					if(control.approvingPanel("Congratulations, you have guessed the word in "+control.getLogic().getClickCounter()+" steps.\n"
							+ "Would you like to play a new game?")) {
						
						startingState();
						control.getTimer().start();
					}
					else  {
						
						if(control.approvingPanel("Would you like to exit?")) {
							System.exit(0);
						}
						else {
							startingState();
							control.getNewWord().setEnabled(false);
							control.getSendLetter().setEnabled(false);
							control.getSendWord().setEnabled(false);
						}
							
						
					}
						
				}
		
		
		
	}

	private void startingState() {
		
		control.getDisplayer().destroyWordPanel();
		control.getStart().setEnabled(true);
		control.getStop().setEnabled(false);
		control.getLogic().setTheWord(null);
		control.getLetter().setText("");
		control.getLetters().setText("");
		control.getFrame().setTitle("Find Out a Word");
		control.getLogic().getTipps().clear();
		
	}
	
	private boolean[] booleanArray(String solution) {
		
		boolean[] array=new boolean[solution.length()];
		
		for (int i=0; i<array.length; i++) {
			array[i]=true;
		}
		
		return array;
	}
	
}
