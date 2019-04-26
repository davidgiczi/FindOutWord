package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.findoutword.model.WordAdmin;
import com.david.giczi.findoutword.view.ControlPanel;
import com.david.giczi.findoutword.view.ListOfWordsDisplayer;

public class ShowWordListController implements ActionListener {

		
	private ControlPanel control;
	
	
	public ShowWordListController(ControlPanel control) {
		
		this.control = control;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		new WordAdmin();
		
		if(!WordAdmin.getWords().isEmpty()) {
			
			new ListOfWordsDisplayer();
		}
		else {
			control.infoPanel("The list of the words is empty.");
			
		}
		
		
	}

	
	
	
	
}
