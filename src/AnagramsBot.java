import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AnagramsBot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input;
        do {
            System.out.println("Enter your 6 letters from your Anagrams game(1 string, no spaces):");
            input = s.nextLine();
            input = input.toUpperCase();
            if (input.length() != 6 || input.contains(" ")) {
                System.out.println("Please enter valid input.");
            }
        } while (input.length() != 6 || input.contains(" "));
        String[] finalLetters = new String[6];
        for (int i = 0; i < 6; i++) {
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
        ArrayList<String> lettersNew = new ArrayList<>();
        ArrayList<String> finalWords = new ArrayList<>();

        for (int p = 0; p < finalLetters.length; p++) {
            lettersNew.add(finalLetters[p]);
        }

        int count1 = 0;
        for (int i = 0; i < validWords.size(); i++) {
            for (int j = 0; j < validWords.get(i).length(); j++) {
                for (int k = 0; k < lettersNew.size(); k++) {
                    if (validWords.get(i).substring(j, j + 1).equals(lettersNew.get(k))) {
                        lettersNew.remove(k);
                        count1++;
                        break;
                    }
                }
            }
            for (int l = 0; l < lettersNew.size(); l++){
                lettersNew.remove(l);
            }
            for (int p = 0; p < finalLetters.length; p++) {
                lettersNew.add(finalLetters[p]);
            }
            if (count1 == validWords.get(i).length()){
                finalWords.add(validWords.get(i));
            }
            count1 = 0;
        }
        ArrayList<String> size3 = new ArrayList<>();
        ArrayList<String> size4 = new ArrayList<>();
        ArrayList<String> size5 = new ArrayList<>();
        ArrayList<String> size6 = new ArrayList<>();
        for(int x = 0; x < finalWords.size(); x++) {
           if (finalWords.get(x).length() == 3) {
               size3.add(finalWords.get(x));
           } else if (finalWords.get(x).length() == 4) {
               size4.add(finalWords.get(x));
           } else if (finalWords.get(x).length() == 5) {
               size5.add(finalWords.get(x));
           } else {
               size6.add(finalWords.get(x));
           }
        }
        for (int z = 0; z < finalWords.size(); z++) {
            if (z < size6.size()) {
                System.out.println(size6.get(z));
            } else if (z < size6.size() + size5.size()) {
                System.out.println(size5.get(z - size6.size()));
            } else if (z < size4.size() + size5.size() + size6.size()){
                System.out.println(size4.get(z - size6.size() - size5.size()));
            } else {
                System.out.println(size3.get(z - size6.size() - size5.size() - size4.size()));
            }
        }
    }
}
