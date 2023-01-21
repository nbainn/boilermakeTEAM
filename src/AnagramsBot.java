import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramsBot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input;
        do {
            System.out.println("Enter your 7 letters from your Anagrams game(1 string, no spaces):");
            input = s.nextLine();
            input = input.toUpperCase();
            if (input.length() != 7 || input.contains(" ")) {
                System.out.println("Please enter valid input.");
            }
        } while (input.length() != 7 || input.contains(" "));
        String[] finalLetters = new String[7];
        for (int i = 0; i < 7; i++) {
            finalLetters[i] = String.valueOf(input.charAt(i));
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

        ArrayList<String> finalWords = new ArrayList<>();
        String[] letters = finalLetters;
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < validWords.size(); i++) {
            for (int j = 0; j < validWords.get(i).length(); j++) {
                for (int k = 0; k < 7; k++) {
                    if (validWords.get(i).substring(j, j+1).equals(letters[k])) {
                        letters[k] = null;
                        count1++;
                        break;
                    }
                }
            }
            for (int w = 0; w < 7; w++) {
                if (letters[w] != null) {
                    count++;
                }
            }
            if (count == 0 || count1 == validWords.get(i).length()){
                finalWords.add(validWords.get(i));
            }
            count1 = 0;
            count = 0;
            letters = finalLetters;
        }
        for(int k = 0; k < finalWords.size(); k++) {
            System.out.println(finalWords.get(k));
        }
    }
}
