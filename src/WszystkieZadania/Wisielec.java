package WszystkieZadania;

import java.util.Random;
import java.util.Scanner;

public class Wisielec {
    public static final String[] words = {"młotek", "gra", "java", "woreczek"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int foults= 10;
        char c;
        Random random = new Random();
        int numerOfWord = random.nextInt(words.length);
        String word = words[numerOfWord];
        boolean[] guessed = new boolean[word.length()];
        System.out.println("+++++++++++GRA W WISIELCA+++++++++++");

        do {
            System.out.println("zgadujesz kolejne litery w słowie");
            System.out.println(guesserdWord(word, guessed));
            System.out.println();
            System.out.print("podaj litere ");
            c = sc.next().charAt(0);
            if (!tryLetter(word, guessed, c)){
                // rysowanie wisielca
                foults--;
                for (int i = 0; i < 10 - foults ; i++) {
                    System.out.print("X ");

                }
                System.out.println();
            }


        } while (foults > 0 && !isGuessed(guessed));
        if (foults == 0) {
            System.out.println("**************");
            System.out.println(" przegrałeś");
            System.out.println("**************");
        }else System.out.println("wygrałeś");



    }//end of main


    private static boolean isGuessed(boolean[] guess) {
        for (int i = 0; i < guess.length; i++) {

            if (guess[i] == false) return false;
        }return true;
    }


    private static boolean tryLetter(String word, boolean[] guess, char c) {
        boolean goal = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                guess[i] = true;
                goal = true;
            }

        }return goal;
    }


    private static String guesserdWord(String word, boolean[] guess) {
        StringBuilder s = new StringBuilder(word);
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == false) {
                s.replace(i, i + 1, ".");
            }

        }
        return s.toString();

    }

}
