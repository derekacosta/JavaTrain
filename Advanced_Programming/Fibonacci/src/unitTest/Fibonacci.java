package unitTest;

public class Fibonacci {

	// Recursively Calculate Fibonacci Numbers
	static int calculate1(int index) {
		// Edge Conditions
		if (index == 0) return 1;
		if (index == 1) return 1;
		
		// F(n) = F(n-1) + F(n-2)
		return calculate1(index - 1) + calculate1(index - 2);
	}

	static int calculate2(int index) {
		// Edge Conditions
		int last = 1, current = 1;

		// Progressively Calculate F(n) = F(n-1) + F(n-2)
		for (int i = 2; i <= index; i++) {
			// Update the last two elements
			current = current + last;
			last = current;
		}
		return current;
	}
	
}
