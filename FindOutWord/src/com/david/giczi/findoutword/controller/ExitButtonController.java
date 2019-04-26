package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.findoutword.view.ControlPanel;


public class ExitButtonController implements ActionListener {

	private ControlPanel control;
	
	
	
	public ExitButtonController(ControlPanel control) {
		
		this.control = control;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(control.approvingPanel("Would you like to exit?")) {
			
			System.exit(0);
		}
		
		
		
	}

}
