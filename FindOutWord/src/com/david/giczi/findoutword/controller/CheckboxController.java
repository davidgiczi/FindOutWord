package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.findoutword.view.ControlPanel;

public class CheckboxController implements ActionListener {

	
	private ControlPanel control;
	
	public CheckboxController(ControlPanel control) {
		
		this.control=control;
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(control.getCheck().isSelected()) {
			
			
			String tippsList=control.getLogic().showtipps();
			control.getLetters().setText(tippsList);
			
			
		}
		else {
			
			control.getLetters().setText("");
			
		}
		
		
	}
	
	
	
	
	
}