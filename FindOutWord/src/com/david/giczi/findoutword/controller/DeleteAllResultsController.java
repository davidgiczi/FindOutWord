package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.findoutword.model.DataBaseOperations;
import com.david.giczi.findoutword.view.ControlPanel;

public class DeleteAllResultsController implements ActionListener {

	
	private ControlPanel control;
	
	
	public DeleteAllResultsController(ControlPanel control) {
		
		this.control = control;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	if(control.approvingPanel("Are you sure you would like to delete all records from the list?")) {
			
			DataBaseOperations.getInstance().deleteAllResults();
			
			control.infoPanel("All results of the list have been deleted.");
		}
		
		
	}

}
