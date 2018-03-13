import java.util.Scanner;

public class Game {
    /**
     * Class that represents a "Guess The Movie" Game:
     * The rules are simple, the computer randomly chosen a movie title and shows the player
     * how many letters it's made up of. The goal is to try to figure out the movie by guessing one letter at a time.
     * If a letter is indeed in the title the computer will reveal its correct position in the word, if not, the player loses a point.
     * If the player loses 10 points the game is over.
     */

    private String movieToGuess;
    private int pointsLost;
    private String rightLetters;
    private String wrongLetters;
    private boolean gameWon;

    /**
     * Class constructor that initializes a {@link MovieList} object from a file cointaining the movie titles
     */


    public Game(String pathname){
        MovieList movieList = new MovieList(pathname);
        movieToGuess = movieList.getRandomTitleMovie();
        pointsLost = 0;
        rightLetters = "";
        wrongLetters = "";
        gameWon = false;
    }

    /**
     * Method that returns the movie's title to be guess
     *
     * @return the title movie to be guess
     */
    public String getMovieTitle() {
        return movieToGuess;
    }
    /**
     * Method that returns the hidden title (replace each letter by "_")
     *
     * @return {@link String} with the movie title with the letter not guessed
     */
    public String getHiddenMovieTitle() {
        if(rightLetters == "") {
            return movieToGuess.replaceAll("[a-zA-Z]", "_ ");

        } else {
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + rightLetters + "]]", "_ ");
        }

    }
    /**
     * Method that returns letters guessed that are not in the title movie
     */
    public String getWrongLetters() {
        return wrongLetters;
    }

    /**
     * Method that retunrs letters guessed that are in the title movie
     */
    public String getRightLetters() {
        return rightLetters;
    }

    /**
     * Method that returns true if the game was won or false otherwise
     *
     * @return true if the game was won or false otherwise
     */
    public boolean gameWon() {
        return gameWon;
    }
    /**
     * Method that returns if the game was won and false otherwise.
     */
    public boolean gameEnded() {
        if(pointsLost >= 10) {

            return true;
        }
        if(!getHiddenMovieTitle().contains("_")) {

            gameWon = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that (1) asks the player to input a letter; (2) check if it's a letter or if the letter is already
     * in the title or return the letter
     *
     * @return not gueses letter
     */
    private String inputLetter() {

        System.out.println("Guess the letter: ");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine();

        if(!letter.matches("[a-z]")) {
            System.out.println("It's not a letter!");
            return  inputLetter();
        } else if (wrongLetters.contains(letter) || rightLetters.contains(letter)) {
            System.out.println("You already guessed the letter!");
            return inputLetter();
        } else {
            return letter;
        }

    }
    /**
     * Method that ask the player for a letter not guessed and if it's correct adds it to the rightLetters if not increasing
     * the pointLost
     */

    public void guessLetter() {
        String guessLetter = inputLetter();

        if(movieToGuess.contains(guessLetter)) {
            rightLetters += " " + guessLetter;
            //System.out.println(rightLetters);
        } else {
            pointsLost++;
            wrongLetters += " " + guessLetter;
            System.out.println(pointsLost);
        }
    }



}
