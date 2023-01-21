import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramsBot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your 7 letters from your Anagrams game(1 string, no spaces):");
        String input = s.nextLine();
        String[] letters = new String[7];
        for (int i = 0; i < 7; i++) {
            letters[i] = String.valueOf(input.charAt(i));
        }
        ArrayList<String> validWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            validWords = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                validWords.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
