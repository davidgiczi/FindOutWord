package com.david.giczi.findoutword.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Result implements Serializable, Comparable<Result> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String playerName;
	private String theWord;
	private int secCounter;
	private int clickCounter;
	private String date;
	
	
	public Result() {
		
	}
	
	public Result(String playerName, String theWord, int secCounter, int clickCounter, String date) {
	
		this.playerName = playerName;
		this.theWord = theWord;
		this.secCounter = secCounter;
		this.clickCounter = clickCounter;
		this.date=date;
	}


	public int getId() {
		return id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getTheWord() {
		return theWord;
	}

	public int getSecCounter() {
		return secCounter;
	}

	public int getClickCounter() {
		return clickCounter;
	}

	public String getDate() {
		return date;
	}

	@Override
	public int compareTo(Result o) {
		
		FindOutWordLogic logic=new FindOutWordLogic();
		
		double one=this.getClickCounter()*this.getSecCounter()/logic.reductLengthValueOfTheWord(this.getTheWord());
		double two=o.getClickCounter()*o.getSecCounter()/logic.reductLengthValueOfTheWord(o.getTheWord());
		
		return one<two ? -1 : one==two ? 0 : 1;
	}
	

	@Override
	public String toString() {
		return "Result [id=" + id + ", playerName=" + playerName + ", theWord=" + theWord + ", secCounter=" + secCounter
				+ ", clickCounter=" + clickCounter + ", date=" + date + "]";
	}


	
}
