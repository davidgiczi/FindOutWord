package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.david.giczi.findoutword.view.ControlPanel;

public class NewWordController implements ActionListener {

	
	private ControlPanel control;
	
	
	public NewWordController(ControlPanel control) {
		
		this.control=control;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			
			startingState();
			
	
	}

	
	private void startingState() {
		
		control.getDisplayer().destroyWordPanel();
		control.getTimer().start();
		control.getStart().setEnabled(true);
		control.getStop().setEnabled(false);
		control.getLogic().setTheWord(null);
		control.getLetter().setText("");
		control.getLetters().setText("");
		control.getFrame().setTitle("Find Out the Word");
		control.getLogic().getTipps().clear();
		
	}
	
}
