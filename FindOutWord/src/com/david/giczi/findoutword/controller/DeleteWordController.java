package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.findoutword.model.WordAdmin;
import com.david.giczi.findoutword.view.ControlPanel;

public class DeleteWordController implements ActionListener {

	
	private ControlPanel control;

	public DeleteWordController(ControlPanel control) {
	
		this.control = control;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		control.inputWordPanel("Please, add the word:");
		
		if(control.getInputWord()==null || !control.getLogic().isValidInputValue(control.getInputWord())) {
			
			return;
		}
		
		WordAdmin admin=new WordAdmin();
		
		
		if(WordAdmin.getWords().isEmpty()) {
			
			control.infoPanel("The list of the words is empty.");
			
			return;
		}
		
	
		boolean isSuccessful=admin.deleteWord(control.getInputWord());
		
		
		if(isSuccessful) {
			
			control.infoPanel("\'"+control.getInputWord()+"\' word deleting is successful!");
			admin.saveWords();
		}
		else  {
			
			control.infoPanel("\'"+control.getInputWord()+"\' word isn't in the list of the words.");
		}
		
	}
	
	
	
	
}

