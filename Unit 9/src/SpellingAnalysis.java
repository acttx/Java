
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
public class SpellingAnalysis {


	public static void main(String[] args) throws IOException {
		Dictionary dict;
		WordFrequencyCounter spelledCorrectly = new WordFrequencyCounter();
		Set<String> misspelled = new TreeSet<>();
		String fileToRead = "BillOfRights.txt";
		if (args.length > 0)
			fileToRead = args[0];
		if (args.length == 2) {
			String dictFile = args[1];
			dict = new Dictionary(dictFile);
		} else {
			dict = new Dictionary();
		}

		List<String> incoming = Utilities.readAFile(fileToRead);

		// TODO replace the following loop with a single statement that uses streams
		incoming.stream()
		.filter(word -> !word.trim().isEmpty()) 
		.map(String::toLowerCase)
		.forEach(word -> {
			if(dict.contains(word)) {
				spelledCorrectly.add(word);
			}
			else if (!"".equals(word)) {
				misspelled.add(word);
			}
		});
		
				
				
//		for (String e : incoming) {
//			if (dict.contains(e.toLowerCase()))
//				spelledCorrectly.add(e.toLowerCase());
//			else if (!"".equals(e.toLowerCase().trim())) {
//				misspelled.add(e);
//			}
//		}

		System.out.println("most frequent words ");
		int highestFreq = spelledCorrectly.highestFrequency();
		System.out.println(spelledCorrectly.findByFrequency(highestFreq));

		// TODO replace the following loop with a single statement that uses streams
		IntStream.iterate(highestFreq, i -> i - 1)
				.limit(highestFreq)
				.forEach(i -> {
					List<String> freqWords = spelledCorrectly.findByFrequency(i).stream()
							.sorted((a, b) -> a.compareTo(b))
							.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
							if(!freqWords.isEmpty()) {
								System.out.println("\nfrequency " + i + "\n" + freqWords);
							}
				});
				
//		for (int i = highestFreq; i > 0; i--) {
//			List<String> freqWords = spelledCorrectly.findByFrequency(i);
//			if (!freqWords.isEmpty()) {
//				freqWords.sort((a, b) -> a.compareTo(b));
//				System.out.println("\nfrequency " + i + "\n" + freqWords);
//			}
//		}

		System.out.println("\nmisspelled words");
		System.out.println(misspelled);
	}

}