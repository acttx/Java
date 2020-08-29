import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class UtilitiesTester {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the name of text file: ");
		String txtFile = s.next();
		
		System.out.println("Enter the trigger word: ");
		String trigger = s.next();
		
		List<String> list = Utilities.readAFile(txtFile);
		ListIterator<String> listIter = list.listIterator();
		
		String previous;
		String current;
		int i = 0;
		
		while(listIter.hasNext()) { 
			current = listIter.next();								//Gets the next word
			
			if(i > 0) {
				if(current.equalsIgnoreCase(trigger)) {				//if current == trigger word,
					listIter.previous();							//move back once,
					previous = listIter.previous();					//store word.
			
					if(previous == "\n") {							
						previous = listIter.previous();				
						listIter.next(); 							//extra move to get past trigger word when newline in play 
					}												
					listIter.set(previous.replaceAll(".", "*"));	
					listIter.next(); 								//move twice to get past trigger word
					listIter.next();
				}			
			}
			i++;
		}
		Utilities.printAList(list);
		s.close();
	}
}
