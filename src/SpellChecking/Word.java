package SpellChecking;

import java.util.ArrayList;


public class Word{
	
	String word;
	Dictionary dict;
	
	public Word(String s, Dictionary d){
		word = s;
		dict = d;
	}
	
	/*
	 * This function basically checks if word is an English word or it is misspelled.
	 * In case it is English word, it would just return itself.
	 * Otherwise, it would return ""
	 */
	public String editDistance0(){
		if (dict.contains(word)){
			return word;
		}else{
			return "";
		}
	}
	
	public boolean isWord(){
		if (dict.contains(word)){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 * This function returns the edit distance between the word and w. 
	 * This is achieved by dynamic programming.
	 * This can be improved to use less space.
	 */
	public int editDistance(String w){
		int n = word.length(); // length of word
		int m = w.length(); // length of w
		int[][] previous = new int[n+1][m+1];
		for(int i=0; i<n+1; i++){
			previous[i][0] = i;
		}
		for(int j=0; j<m+1; j++){
			previous[0][j] = j;
		}
		for (int i = 1; i<n+1; i++){
			for(int j = 1; j<m+1; j++){
				int a = previous[i-1][j-1];
				if (!(word.charAt(i-1) == w.charAt(j-1))){
					a ++;
				}
				int b = previous[i][j-1]+1;
				int c = previous[i-1][j]+1;
				previous[i][j] = Math.min(Math.min(a, b), c);
			}
		}
		return previous[n][m];
	}
	
	/*
	 * This is a naive way to figure out all the close English words 2 or less edit distance away.
	 */
	public ArrayList<String> naiveFindClosestWords(){
		ArrayList<String> result = new ArrayList<String>();
		for(String w: dict.getWordList()){
			if (this.editDistance(w) < 3){
				result.add(w);
			}
		}
		return result;
	}
	
	public void printClosest(){
		for (String w: this.FindClosestWords()){
			System.out.print(w+", ");
		}
		System.out.print("\n");
	}

	public ArrayList<String> FindClosestWords() {
		return naiveFindClosestWords();
	}
}