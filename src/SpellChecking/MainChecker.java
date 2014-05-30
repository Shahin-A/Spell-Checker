package SpellChecking;

/*
 * This is the main class
 */
public class MainChecker {
	
	public static void main(String[] argv){
		System.out.println("Starting the Program!");
		Reader dict = new Reader("data/wordsEn.txt");
		Reader reader = new Reader("data/big.txt");
		Dictionary frequency = new Dictionary();
		reader.read(frequency);
		dict.read(frequency);
		frequency.print();
		Word word1 = new Word("reason", frequency);
		word1.printClosest();
	}
}