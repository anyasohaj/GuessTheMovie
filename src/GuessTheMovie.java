import java.io.File;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Character.isLetter;
import static java.lang.Character.toUpperCase;

public class GuessTheMovie {


    public static void main(String[] args) throws Exception {


        //Read in the file, count the lines and declare a String-array for them

        File file = new File("movies.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner titleScanner = new Scanner(file);
        String[] titles = new String[countLines(fileScanner)];

        //Put the movies in the array

        for (int i = 0; i < titles.length; i++) {
            titles[i] = titleScanner.nextLine();
        }

        // Initialize variables for Start

        String movie = pickNext(titles);
        movie = movie.toUpperCase();
        Game game = new Game(movie);
        String actualState = "";
        actualState = game.adjustForStart(movie).toString();
        Game.badLetterCounter = 0;
        boolean isWin = false;


        while ((!isWin)&&(Game.badLetterCounter<10)) {
            System.out.println(actualState);
            System.out.println("You've guessed " + Game.badLetterCounter + " wrong letters: " + Game.wrongLetters );
            System.out.println("Guess a letter:");
            Scanner scanner = new Scanner(System.in);
            char guess = scanner.next(".").charAt(0);
            if (isLetter(guess)){
            guess = toUpperCase(guess);
            actualState = game.adjust(actualState, guess);
            if (actualState.equals(movie)){
                isWin = true;
            }
        }else{
                System.out.println("You have to guess a LETTER!");
            }
        }

        if (game.badLetterCounter >=10) {
            System.out.println("You've lost. The solution was: " + movie );
        } else { System.out.println(actualState );
                System.out.println(" YOU WIN!!!!!!!");

        }
    }


    public static int countLines(Scanner s) {
        int counter = 0;
        while (s.hasNextLine()) {
            s.nextLine();
            counter++;
        }
        return counter;
    }


    public static String pickNext(String[] list){
        int randomNumber = new Random().nextInt(list.length);
        return list[randomNumber];
    }


}



