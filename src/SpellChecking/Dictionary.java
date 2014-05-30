package SpellChecking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * This class keeps track of the count of each English words that it has seen so far.
 */
public class Dictionary{
	
	HashMap<String, Integer> f;
	ArrayList<String> wordList;
	boolean sorted;
	
	public Dictionary(){
		f = new HashMap<String, Integer>();
		wordList = new ArrayList<String>();
		sorted = false;
	}
	
	/*
	 * This function increments a word count inside our HashMap.
	 * If the word doesn't exist, it will add it to the HashMap with count 1 and wordList.
	 */
	public void increment(String word){
		if (f.containsKey(word)){
			f.put(word, f.get(word)+1);
		}else{
			f.put(word, 1);
			wordList.add(word);
			sorted = false;
		}
	}
	
	public HashMap<String, Integer> getFrequency(){
		return f;
	}
	
	public int getFrequencyOfWord(String word){
		return f.get(word);
	}
	
	public void print(){
		for (Map.Entry<String, Integer> entry : f.entrySet())
		{
		    System.out.print(entry.getKey() + ": " + entry.getValue()+", ");
		}
		 System.out.println("\n "+f.size());
	}
	
	public boolean contains(String w){
		boolean result = false;
		if (f.containsKey(w)){
			result = true;
			System.out.println(w +": " + f.get(w));
		}
		return result;
	}
	
	/*
	 * This function checks if there are any words in the dictionary which starts with substring.
	 * It would return the closets match.
	 */
	public String startsWith(String substring){
		if (!sorted){
			Collections.sort(wordList);
			sorted = true;
		}
		int index = Collections.binarySearch(wordList, substring);
		int insertionPoint = index;
		if (index < 0){
			insertionPoint = -(index+1);
		}
		if(insertionPoint < 0){
			return wordList.get(0);
		}else if (insertionPoint >= wordList.size()){
			return wordList.get(wordList.size()-1);
		}else{
			return wordList.get(insertionPoint);
		}
	}
	
	public boolean isStartsWith(String substring){
		String match = startsWith(substring);
		if (match.startsWith(substring)){
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<String> getWordList(){
		return wordList;
	}
}