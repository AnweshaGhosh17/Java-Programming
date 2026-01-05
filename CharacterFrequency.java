import java.util.Scanner;
public class CharacterFrequency {

    public static String[][] findFrequency(String text) {
        int[] freq = new int[256];
        int i = 0;
        try {
            while (true) {
                char ch = text.charAt(i);
                freq[(int) ch]++;
                i++;
            }
        } catch (Exception e) {
        }
        int length = i;
        boolean[] visited = new boolean[256];
        String[][] result = new String[length][2];
        int index = 0;
        for (int j = 0; j < length; j++) {
            char ch = text.charAt(j);
            if (!visited[(int) ch]) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[(int) ch]);
                visited[(int) ch] = true;
                index++;
            }
        }
        String[][] finalResult = new String[index][2];
        for (int k = 0; k < index; k++) {
            finalResult[k][0] = result[k][0];
            finalResult[k][1] = result[k][1];
        }
        return finalResult;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = input.nextLine();
        String[][] output = findFrequency(text);
        System.out.println("Character\tFrequency");
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "\t\t" + output[i][1]);
        }
    }
}
