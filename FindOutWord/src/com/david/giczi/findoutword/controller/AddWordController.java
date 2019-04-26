package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.david.giczi.findoutword.model.WordAdmin;
import com.david.giczi.findoutword.view.ControlPanel;

public class AddWordController implements ActionListener {

	
	private ControlPanel control;
	
	public AddWordController(ControlPanel control) {
		
		this.control=control;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		control.inputWordPanel("Please, add a new word:");
		
		WordAdmin admin=new WordAdmin();
		
		boolean isSuccessful=admin.addWord(control.getInputWord());
		
		if(isSuccessful) {
			control.infoPanel("\'"+control.getInputWord()+"\' word has added successfully!");
			admin.saveWords();
		}
		else {
			control.infoPanel("\'"+control.getInputWord()+"\' word has already been added to the list of the words.");
		}
		
		
	}
	
	
	
}
