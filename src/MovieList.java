import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class MovieList {
    /**
     * Class representing a list of movies.
     */
    private ArrayList<String> movies;

    /**
     * Class constructor that stores the movie titles contained a file in an {@link ArrayList}
     *
     * @param pathname          Path to a file containing the movie's titles
     */

    public MovieList(String pathname){
        movies = new ArrayList<String>();
        File file = new File(pathname);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            movies.add(line);
        }

    }
    /**
     * Method generates a random title of movie
     *
     * @return random movie title from the list
     */
    public String getRandomTitleMovie(){
        int numberOfTitleMovies = movies.size();
        int randomNumberIndex = (int) (Math.random() * numberOfTitleMovies);
        String randomTitleMovie = movies.get(randomNumberIndex);
        return randomTitleMovie;
    }


}
