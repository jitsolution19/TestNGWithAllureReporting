package stringCollection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P01StringBufferReverse {
	public static void main(String[] args) {
		String input = "Jitendra loves Shivansh";
		StringBuffer practice = new StringBuffer(input);
		practice=practice.append("Adding Gupta");
		System.out.println(practice);
		System.out.println(practice.substring(3, 8));
		System.out.println(practice.codePointBefore(8));
		System.out.println(practice.reverse());
		List<StringBuffer> output = Stream.of(practice).map(x->x.append("Jitendra")).collect(Collectors.toList());
		System.out.println(output.toString());
	}

}
