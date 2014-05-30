package SpellChecking;

/*
 * This is the main class
 */
public class MainChecker {
	
	public static void main(String[] argv){
		Reader dict = new Reader("data/wordsEn.txt");
		Reader reader = new Reader("data/big.txt");
		Dictionary frequency = new Dictionary();
		reader.read(frequency);
		dict.read(frequency);
		SimpleChecker sc = new SimpleChecker(frequency);
		System.out.println(sc.check("whos are yoo?"));
	}
}