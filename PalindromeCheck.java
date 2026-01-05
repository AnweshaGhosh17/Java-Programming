import java.util.Scanner;
public class PalindromeCheck {

    public static boolean isPalindromeLogic1(String text) {
        int start = 0;
        int end = 0;
        try {
            while (true) {
                text.charAt(end);
                end++;
            }
        } catch (Exception e) {
        }
        end--;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    public static char[] reverseUsingCharAt(String text) {
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (Exception e) {
        }
        char[] reverse = new char[length];
        for (int i = 0; i < length; i++) {
            reverse[i] = text.charAt(length - i - 1);
        }
        return reverse;
    }
    public static boolean isPalindromeLogic3(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseUsingCharAt(text);
        int length = original.length;
        for (int i = 0; i < length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a text:");
        String text = input.nextLine();
        boolean result1 = isPalindromeLogic1(text);
        boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean result3 = isPalindromeLogic3(text);
        System.out.println("Logic 1 (Iterative) => " + (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 2 (Recursive) => " + (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Logic 3 (Reverse Array) => " + (result3 ? "Palindrome" : "Not Palindrome"));
    }
}
