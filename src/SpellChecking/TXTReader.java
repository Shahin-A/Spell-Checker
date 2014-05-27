package SpellChecking;


/*
 * This is an abstract class that reads a text file and updates the frequency of English words. 
 */
public abstract class TXTReader{
	
	String path;
	
	public TXTReader(String p){
		path = p;
	}
	
	public String getPath(){
		return path;
	}
	
	public abstract void read(Frequency frequency);
	
}