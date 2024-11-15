import java.util.Scanner;
public class VowelCounts {

    public static boolean isVowel(char character) {
        boolean isVowel;
        if (character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U') {
            isVowel = true;
        } else {
            isVowel = false;
        }
        return isVowel;
    }

    public static int countVowels(String phrase) {
        int howManyVowels = 0;
        for (int i = 0; i < (phrase.length()); i++) {
            if (isVowel(phrase.charAt(i)) == true) {
                howManyVowels++;
            }
        }
        return howManyVowels;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Type in a phrase: ");
        String phrase = in.nextLine().toUpperCase();
        int howManyVowels = countVowels(phrase);
        System.out.println("There are " + howManyVowels + " vowels in this phrase.");
    }
}
