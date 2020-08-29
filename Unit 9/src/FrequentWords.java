
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FrequentWords {

	public static void main(String[] args) throws FileNotFoundException {

		String filename = "SophieSallyJack.txt";
		if (args.length == 1) {
			filename = args[0];
		}
		Map<String, Integer> wordFrequency = new TreeMap<>();

		List<String> incoming = Utilities.readAFile(filename);
		
		// TODO replace the following loop with a single statement using streams
		// that populates wordFrequency
		wordFrequency = incoming.stream()
				.filter(word -> !word.trim().isEmpty())
				.map(String::toLowerCase)
				.collect(Collectors.toMap(word -> word, word -> 1, (a, b) -> a + b, TreeMap::new));

		// TODO add a single statement that uses streams to determine maxCnt
		Integer maxCnt = wordFrequency.values().stream()
				.max(Comparator.naturalOrder())
				.get();
		System.out.print("Words that appear " + maxCnt + " times:");
		
		// TODO replace the following loop with a single statement using streams
		// that prints the most frequent words in the document
		wordFrequency.entrySet().stream()
			.filter(s -> s.getValue() == maxCnt)
			.forEach(s -> System.out.print(" " + s.getKey()));
	}
}
