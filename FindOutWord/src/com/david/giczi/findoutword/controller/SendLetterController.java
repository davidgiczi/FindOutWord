package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.findoutword.view.ControlPanel;

public class SendLetterController implements ActionListener {

	
	private ControlPanel control;
	
	public SendLetterController(ControlPanel control) {
		
		this.control=control;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		control.getLogic().setClickCounter(control.getLogic().getClickCounter()+1);
		control.getLogic().collectTipps(control.getLetter().getText());
		control.getLetter().setText("");
		control.getLogic().isTippLetterInTheWord();
		control.getDisplayer().showLetter(control.getLogic().getTheWord(), control.getLogic().getChars());
		

		if(control.getCheck().isSelected()) {
			
			String tippsList=control.getLogic().showtipps();
			control.getLetters().setText(tippsList);
			
		}
		
		
		if(control.getLogic().isGuessedTheWord()) {
			
			control.getTimer().stop();
			
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
	
}
