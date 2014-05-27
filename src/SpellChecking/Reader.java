package SpellChecking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader extends TXTReader{

	public Reader(String p) {
		super(p);
	}

	@Override
	public void read(Dictionary frequency) {
		try {
			File f = new File(this.getPath());
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while((line = br.readLine()) != null){
				line = line.toLowerCase();
				Pattern regex = Pattern.compile("[a-z]+\'?[a-z]*");
				Matcher regexMatcher = regex.matcher(line);
				while (regexMatcher.find()) {
				    frequency.increment(regexMatcher.group());
				} 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}		
	}	
}