import java.util.Scanner;
public class UniqueCharacters {

    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }
    public static char[] findUniqueCharacters(String text) {
        int length = getLength(text);
        char[] unique = new char[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[index] = current;
                index++;
            }
        }
        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = unique[i];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = input.nextLine();
        char[] uniqueChars = findUniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (int i = 0; i < getLength(new String(uniqueChars)); i++) {
            System.out.print(uniqueChars[i] + " ");
        }
    }
}
