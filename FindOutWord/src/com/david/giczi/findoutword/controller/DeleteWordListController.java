package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.findoutword.model.WordAdmin;
import com.david.giczi.findoutword.view.ControlPanel;

public class DeleteWordListController implements ActionListener {

	
	private ControlPanel control;

	public DeleteWordListController(ControlPanel control) {
		
		this.control = control;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(control.approvingPanel("Are you sure you would like to delete all words in the list?")) {
			
			WordAdmin admin=new WordAdmin();
			admin.clearWordList();
			admin.saveWords();
			control.infoPanel("All words of the list has been deleted.");
		}
	
		
	}
	
	
	
	
}
