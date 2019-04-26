package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.findoutword.view.ControlPanel;

public class StopButtonController implements ActionListener {
	
	
	private ControlPanel control;
	
	
	public StopButtonController(ControlPanel control) {
		
		this.control=control;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		control.getTimer().stop();
		control.getStart().setEnabled(true);
		control.getStop().setEnabled(false);
		control.getSendLetter().setEnabled(false);
		control.getSendWord().setEnabled(false);
		
	}

	
	
	
}
