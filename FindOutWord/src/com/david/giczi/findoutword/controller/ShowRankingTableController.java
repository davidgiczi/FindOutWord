package com.david.giczi.findoutword.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.david.giczi.findoutword.model.DataBaseOperations;
import com.david.giczi.findoutword.view.ControlPanel;
import com.david.giczi.findoutword.view.RankingTable;

public class ShowRankingTableController implements ActionListener {

	
	private ControlPanel control;
	
	
	public ShowRankingTableController(ControlPanel control) {
		
		this.control = control;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
	DataBaseOperations db=DataBaseOperations.getInstance();
	
	Object[][] results=control.getLogic().convertingRankingData(db.getAllResults());
	
	new RankingTable(results);
		
	}

	
	
	
}
