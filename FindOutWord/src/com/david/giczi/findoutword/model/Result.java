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
	
	
	public Result() {
		
	}
	
	public Result(String playerName, String theWord, int secCounter, int clickCounter) {
	
		this.playerName = playerName;
		this.theWord = theWord;
		this.secCounter = secCounter;
		this.clickCounter = clickCounter;
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

	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clickCounter;
		result = prime * result + id;
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result + secCounter;
		result = prime * result + ((theWord == null) ? 0 : theWord.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (clickCounter != other.clickCounter)
			return false;
		if (id != other.id)
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (secCounter != other.secCounter)
			return false;
		if (theWord == null) {
			if (other.theWord != null)
				return false;
		} else if (!theWord.equals(other.theWord))
			return false;
		return true;
	}




	@Override
	public int compareTo(Result o) {
		
		FindOutWordLogic logic=new FindOutWordLogic();
		
		double one=this.getClickCounter()*this.getSecCounter()/logic.reductLengthValueOfTheWord(this.getTheWord());
		double two=o.getClickCounter()*o.getSecCounter()/logic.reductLengthValueOfTheWord(o.getTheWord());
		
		return one<two ? 1 : one==two ? 0 : -1;
	}





	@Override
	public String toString() {
		return "Result [id=" + id + ", playerName=" + playerName + ", theWord=" + theWord + ", secCounter=" + secCounter
				+ ", clickCounter=" + clickCounter + "]";
	}
	
	
	
	
}
