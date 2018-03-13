public class Main {

    public static void main(String[] args) {

        Game game = new Game("movies.txt");

        System.out.println("Welcome in GUESS THE MOVIE!!!");
        System.out.println("You have to guess a movie name given a number of letters in it - pretty much like hangman!");
        System.out.println("You've got 10 trials. If you don't guess in 10 trials you loose, otherwise you win!");
        System.out.println("Let's start it!");

        while(!game.gameEnded()) {
            System.out.println("You are guessing: " + game.getHiddenMovieTitle());
            System.out.println("You have guessed " + game.getWrongLetters().length()/2  + " wrong letters: " + game.getWrongLetters());
            game.guessLetter();
        }

        if(game.gameWon()) {
            System.out.println("The title is: " + game.getHiddenMovieTitle());
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println(" Sorry! Not this time! Too much lost point! Please try again!");
        }


    }


}
