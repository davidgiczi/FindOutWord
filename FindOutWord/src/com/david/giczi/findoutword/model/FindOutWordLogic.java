package com.david.giczi.findoutword.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;


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
			
			if(word.charAt(i)!=' ') {
				
				store.add(word.charAt(i));
			}
			
		}
		
		
	
		return store.size();
	}
	
	public String createTimeStamp() {
		
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat format=new SimpleDateFormat("dd.MM.YYYY (EEEE) HH:mm:ss", Locale.ENGLISH);
		
		return format.format(date);
	}
	
	
	public Object[][] convertingRankingData(List<Result> data){
		
		Collections.sort(data);
		
		Object[][] store=new Object[data.size()][6];
		
		for(int i=0; i<data.size(); i++) {
			
			
		store[i][0] = i+1;
		store[i][1] = data.get(i).getPlayerName();
		store[i][2] = data.get(i).getTheWord();
		store[i][3] = data.get(i).getSecCounter();
		store[i][4] = data.get(i).getClickCounter();
		store[i][5] = data.get(i).getDate();
		
		}
		
		
		return store;
	}
	
	
	public boolean isValidInputValue(String input) {
		
		int counter=0;
		
		for(int i=0; i<input.length(); i++) {
			
			if(input.charAt(i)==' ') {
				
				counter++;
			}
		}
		
		if(counter==input.length() || input.startsWith(" ")) {
			
			return true;
		}
		
		return false;
	}
	

}







