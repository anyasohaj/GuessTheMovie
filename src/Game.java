import com.sun.corba.se.spi.ior.IdentifiableFactory;

public class Game {
    private String theMovie;
    public  static int badLetterCounter;
    public static String wrongLetters = " ";


    public Game(String theMovie) {
        this.theMovie = theMovie;

    }


    public StringBuilder adjustForStart(String m) {
        StringBuilder startState = new StringBuilder(m);
        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) == ' ') {
                startState.setCharAt(i, ' ');
            } else {
                startState.setCharAt(i, '_');
            }

        }
        return startState;

    }

    public String adjust(String actualState, char letter) {
        boolean isMatch = false;
        boolean duplicateRight = false;
        StringBuilder nextPhase = new StringBuilder(actualState);
        for (int i = 0; i < theMovie.length(); i++) {
            if (theMovie.charAt(i) == letter) {
                nextPhase.setCharAt(i, letter);
                if (actualState.equals(nextPhase.toString())){
                    duplicateRight = true;
                }
                isMatch = true;
            }

            }
            if (duplicateRight){
                System.out.println("You've guessed that before!");
    }


        if (!isMatch){
            boolean isTwice=false;
            for (int i=0; i<wrongLetters.length(); i++){
                if (wrongLetters.charAt(i)==letter) {
                    System.out.println("You've guessed that before.");
                   isTwice = true;
                }
                }
                if (!isTwice) {
                wrongLetters = wrongLetters + letter + " ";
                    badLetterCounter++;
                    }
        }
        return nextPhase.toString();

    }
}
