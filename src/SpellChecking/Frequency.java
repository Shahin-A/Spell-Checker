package SpellChecking;

import java.util.HashMap;

/*
 * This class keeps track of the count of each English words that it has seen so far.
 */
public class Frequency{
	
	HashMap<String, Integer> f;
	
	public Frequency(){
		f = new HashMap<String, Integer>();
	}
	
	/*
	 * This function increments a word count inside our HashMap.
	 * If the word doesn't exist, it will add it to the HashMap with count 1.
	 */
	public void increment(String word){
		if (f.containsKey(word)){
			f.put(word, f.get(word)+1);
		}else{
			f.put(word, 1);
		}
	}
	
	public HashMap<String, Integer> getFrequency(){
		return f;
	}
	
	public int getFrequencyOfWord(String word){
		return f.get(word);
	}
}