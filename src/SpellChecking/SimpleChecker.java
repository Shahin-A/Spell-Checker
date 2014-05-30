package SpellChecking;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This is a very simple spell checker.
 * It ONLY looks at each word and determines the nearest edit distance word with higher probability of happening.
 * Then it replaces the misspelled word with its nearest neighbor. 
 * This doesn't have any knowledge of the context.
 */
public class SimpleChecker extends Checker{
	
	Dictionary dict;
	
	public SimpleChecker(Dictionary d){
		dict = d;
	}
	
	@Override
	public String check(String phrase) {
		String result = phrase;
		Pattern regex = Pattern.compile("[a-z]+\'?[a-z]*");
		Matcher regexMatcher = regex.matcher(phrase);
		while (regexMatcher.find()) {
			String word = regexMatcher.group();
		    String corrected = correct(word);
		    if (!corrected.equals("")){
		    	result = result.replaceAll(word, corrected);
		    }
		}
		return result;
	}
	
	public String correct(String word){
		String result = "";
		if(dict.contains(word)){
			return result;
		}else{
			Word w = new Word(word, dict);
			ArrayList<String> words = w.FindClosestWords();
			int level = Integer.MAX_VALUE;
			int prob = 0;
			for (String s: words){
				int editDistance = w.editDistance(s);
				if(editDistance < level){
					level = editDistance;
					result = s;
					prob = dict.getFrequencyOfWord(s);
				}else if(editDistance == level){
					int p = dict.getFrequencyOfWord(s);
					if (p > prob){
						result = s;
						prob = p;
					}
				}
			}
			return result;
		}
	}
	
}