package SpellChecking;

import java.util.HashMap;
import java.util.Map;

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
}