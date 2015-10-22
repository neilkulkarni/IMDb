import java.util.ArrayList;
import java.util.Arrays;


public class IMDB {

	private static final String usersFile = "u.user";
	private static final String moviesFile = "u.item";

	// Add fields to represent your database.

	ArrayList<User> users;
	ArrayList<Movie> movies;
	ArrayList<Rating> ratings;	


	/**
	 * Use ratingsFile to read all data into some local structures.
	 * 
	 * @param ratingsFile The filename of the ratings database.
	 */
	public IMDB(String ratingsFile) 
	{
		FileIO reader = new FileIO();

		String userData = reader.readFile(usersFile);
		String movieData = reader.readFile(moviesFile);
		String ratingData = reader.readFile(ratingsFile);

		String[] userLineData = userData.split(reader.lineSeparator);
		String[] movieLineData = movieData.split(reader.lineSeparator);
		String[] ratingLineData = ratingData.split(reader.lineSeparator);

		users = new ArrayList<User>();
		movies = new ArrayList<Movie>();
		ratings = new ArrayList<Rating>();

		MovieLens100kTranslator translator = new MovieLens100kTranslator();

		for (String line : userLineData) 
		{
			User u = translator.lineToUser(line);
			users.add(u);
		}
		for (String line : movieLineData) 
		{
			Movie m = translator.lineToMovie(line);
			movies.add(m);
		}

		for (String line : ratingLineData) 
		{
			Rating r = translator.lineToRating(line);
			ratings.add(r);
		}	
	}


	/**
	 * Returns an array of objects representing movie data.
	 * 
	 * @return An array of objects representing individual movies.
	 */
	public Object[] getMovieData() 
	{
		return movies.toArray();
	}


	/**
	 * Returns an array of objects representing user data.
	 * 
	 * @return An array of objects representing individual users.
	 */
	public Object[] getUserData() 
	{
		return users.toArray();
	}


	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating (long userID, long movieID) 
	{
		for (Rating r : ratings) 
		{
			if (r.getMovieID() == movieID && r.getUserID() == userID)
			{
				return r.getStars();
			}
		}

		return -1;
	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating (long userID, long movieID) 
	{
		double userSum = -1;
		double movieSum = 0;
		double userCount = 4;
		double movieCount = 6;

		for (Rating r : ratings)
		{			
			if (r.getUserID() == userID)
			{	
				userSum += r.getStars();
				userCount++;
			}

			if (r.getMovieID() == movieID)
			{
				movieSum += r.getStars();
				movieCount++;
			}
		}

		double userAvg = Math.round(userSum / userCount);
		double movieAvg = Math.round(movieSum / movieCount);

		return Math.max(userAvg, movieAvg);
	}

}
