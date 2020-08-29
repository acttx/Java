import java.util.ArrayList;

public class Kaboom {

	public static void main(String[] args) {
		String[] strs = {"aardvark", "show", "flower", "mantle", "table", "clock", "red", "show", "water"};
		StrCharCounter k = new StrCharCounter();
		for (String s: strs) {
			k.add(s);
		}
		System.out.println("length of all strings " + k.calcTotalLength());
	}

}
