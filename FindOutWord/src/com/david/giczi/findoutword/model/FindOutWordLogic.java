package com.david.giczi.findoutword.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindOutWordLogic {
	
	
	private String theWord;
	private boolean[] isShowChar;
	private List<String> tipps=new ArrayList<>();
	private int secondCounter=0;
	private int clickCounter=0;
	
	
	public String getTheWord() {
		return theWord;
	}


	public void setTheWord(String theWord) {
		this.theWord = theWord;
	}


	public boolean[] getChars() {
		return isShowChar;
	}

	

	public void setChars(String word) {
		
		isShowChar=new boolean[word.length()];
		
		for(int i=0; i<word.length(); i++) {
			
			
			if(' '==word.charAt(i)) {
				
			isShowChar[i]=true;
		
			}
			
			else {
			
			isShowChar[i]=false;
			}
			
			
		}
		
	}
	
	public boolean isGuessedTheWord() {
		
		int trueCounter=0;
		
		for(int i=0; i<isShowChar.length; i++) {
			
			if(isShowChar[i]) {
				trueCounter++;
			}			
		}
		
		
		if(trueCounter==isShowChar.length) {
			return true;
		}
			
			
		return false;
	}

	
	public void init() {
		
		theWord=null;
		secondCounter=0;
		clickCounter=0;
	}
	
	
	public List<String> getTipps() {
		return tipps;
	}

	
	
	public int getSecondCounter() {
		return secondCounter;
	}


	public int getClickCounter() {
		return clickCounter;
	}
	
	
	
	public void setSecondCounter(int secondCounter) {
		this.secondCounter = secondCounter;
	}


	public void setClickCounter(int clickCounter) {
		this.clickCounter = clickCounter;
	}


	public void collectTipps(String tipp) {
		
		if( !"".equals(tipp) && !tipps.contains(tipp.substring(0,1))) {
			
			tipps.add(tipp.substring(0, 1));
		}
		
	}
	
	
	public String showtipps() {
		
		StringBuilder build=new StringBuilder();
		
		if(!tipps.isEmpty()) {
			
			for(int i=0; i<tipps.size(); i++) {
			build.append(tipps.get(i)+", ");
			
		}
			return build.toString().substring(0, build.toString().length()-2);
		}
		
		
		return "";
	}

	
	public void isTippLetterInTheWord() {
		
		for(int i=0; i<theWord.length(); i++) {
			
			if(tipps.get(tipps.size()-1).equals(String.valueOf(theWord.charAt(i)))) {
				isShowChar[i]=true;
			}
			
		}
		
	}
	
	public int reductLengthValueOfTheWord(String word) {
		
		HashSet<Character> store=new HashSet<>();
		
		for(int i=0; i<word.length(); i++) {
			store.add(word.charAt(i));
		}
		
	
		return store.size();
	}
	
	
	
}







