package SpellChecking;

/*
 * This is the main class
 */
public class MainChecker {
	
	public static void main(String[] argv){
		System.out.println("Starting the Program!");
		Reader dict = new Reader("data/wordsEn.txt");
		Reader reader = new Reader("data/big.txt");
		Frequency frequency = new Frequency();
		reader.read(frequency);
		dict.read(frequency);
		frequency.print();
	}
}