package stringCollection;

public class finalexample3 {
	public static void StringExample() {
		String a = new String("A");
		String b = new String("A");
		if (a == b) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
		
		if(a.equals(b)) {
			System.out.println("Equals to TRUE");	
		}else {
			System.out.println("Equals to False");
		}
	}

	public static void StringBufferExample() {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("A");
		if (a == b) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

	public static void StringBuilderExample() {
		StringBuilder a = new StringBuilder("A");
		StringBuilder b = new StringBuilder("A");
		if (a == b) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

	public static void main(String[] args) {
		StringExample();
		StringBufferExample();
		StringBuilderExample();
	}

}
