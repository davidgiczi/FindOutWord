package com.david.giczi.findoutword.model;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class WordAdmin {

	
	private static List<String> words;
	
	
	
	public WordAdmin() {
		
		if(words==null) {
			
			loadingWords();
			
		}
		
	}

	

	public static List<String> getWords() {
		return words;
	}



	public void saveWords() {
		
		try {
			
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("./words/store.txt"))));
			
			for (String word : words) {
				out.write(word);
				out.newLine();
			}
			
			out.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void clearWordList() {
		
		if(words!=null && !words.isEmpty()) {
			words.clear();
		}
		
	}
	
	public String choosenWord() {
		
		if(words.isEmpty()) {
			return "EmptyList";
		}
		
		return words.get((int)(Math.random()*words.size()));			
	}
	
	
	public boolean addWord(String word) {
	
		if(words==null) {
			words=new ArrayList<>();
		}
		
		if(!words.contains(word)) {
				
				words.add(word);
				return true;
		}
		
		return false;
	}
	
	public boolean deleteWord(String word) {
		
		if(words!=null && words.contains(word)) {
			
				words.remove(word);
				return true;
		}
		
		return false;
	}
	
	
	private void loadingWords() {
		
		words=new ArrayList<>();
		
		try {
			
			BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(new File("./words/store.txt"))));
			
			String word="";
			
			while((word=in.readLine())!=null) {
				
				words.add(word.trim());
				
			}
			
			in.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
