import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Using a Loop
    public static boolean isPalindromeUsingLoop(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Using StringBuilder
    public static boolean isPalindromeUsingStringBuilder(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Approach 3: Using Recursion
    public static boolean isPalindromeUsingRecursion(String str) {
        if (str.length() <= 1) {
            return true;
        }
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        if (first != last) {
            return false;
        }
        return isPalindromeUsingRecursion(str.substring(1, str.length() - 1));
    }
	
	// Approach 4: Using Java Streams and Lambda
	public static boolean isPalindromeUsingStreams(String str) {
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return new StringBuilder(cleanedStr).reverse().toString().equals(cleanedStr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        // Call each method and print the result
        System.out.println("Is \"" + input + "\" a palindrome (Loop)? " + isPalindromeUsingLoop(input));
        System.out.println("Is \"" + input + "\" a palindrome (StringBuilder)? " + isPalindromeUsingStringBuilder(input));
        System.out.println("Is \"" + input + "\" a palindrome (Recursion)? " + isPalindromeUsingRecursion(input));
        System.out.println("Is \"" + input + "\" a palindrome (Streams)? " + isPalindromeUsingStreams(input));
    }
}
