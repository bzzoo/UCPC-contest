import java.util.Scanner;

public class 단어뒤집기_9093 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < T; i++) {
            String sentence = scanner.nextLine();
            String[] words = sentence.split(" ");

            for (int j = 0; j < words.length; j++) {
                words[j] = reverseString(words[j]);
            }

            System.out.println(String.join(" ", words));
        }

        scanner.close();
    }

    public static String reverseString(String word) {
        char[] chars = word.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}