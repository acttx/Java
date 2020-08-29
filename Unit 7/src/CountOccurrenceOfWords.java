import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountOccurrenceOfWords {
	 public static void main(String[] args) throws FileNotFoundException{
		 Scanner s = new Scanner(System.in);
		 
		 Map<String, Integer> map = new TreeMap<String, Integer>();
		 
		//name of text file: text
		 System.out.println("Enter the name of text file: "); 
		 String textFile = s.next();
		 Scanner f = new Scanner(new File(textFile));
		 
		 while(f.hasNextLine()) {
			 String line = f.nextLine();
			 //remove punctuation from text files
			 String[] words = line.split("\\P{L}+");
			 
			 for(int i = 0; i < words.length; i++) {
				 String key = words[i].toLowerCase();
				 if(key.length() > 0) {
					 if(!map.containsKey(key)) {
						 map.put(key, 1);
					 }else {
						 int value = map.get(key);
						 value++;
						 map.put(key,value);
					 }  
				 }
			 }
		 }
		 
		 Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		 int occurrence = 0;
		 for(Map.Entry<String, Integer> entry: entrySet) {
			 if(occurrence < entry.getValue()) {
				 occurrence = entry.getValue();
			 }
		 }
		 
		 System.out.print("Words that appear " +occurrence+ " times: ");
		 for (Map.Entry<String, Integer> entry: entrySet) {
			 if(entry.getValue() == occurrence)
				 System.out.print(entry.getKey() + " ");
		 }
		 
		 s.close();
		 f.close();
	 }
}
	 