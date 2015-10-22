import java.util.ArrayList;
import java.util.Arrays;


public class Main 
{
	public static void main(String[] args) 
	{
		FileIO reader = new FileIO ();
		MovieLens100kTranslator translator = new MovieLens100kTranslator();
		
		
		String genreData = reader.readFile("u.genre");
		String[] genreLineData = genreData.split(reader.lineSeparator);
		ArrayList<String> genres = new ArrayList<String> (Arrays.asList(genreLineData)); 
		
		
		String userData = reader.readFile("u.user");
		String[] userLineData = userData.split(reader.lineSeparator);
		ArrayList<User> users = new ArrayList<User> ();
		for (String s : userLineData)
		{
			users.add(translator.lineToUser(s));
		}
		for (User u : users)
		{
			System.out.println(u);
		}
		
		
		String movieData = reader.readFile("u.item");
		String[] movieLineData = movieData.split(reader.lineSeparator);
		ArrayList<Movie> movies = new ArrayList<Movie> ();
		for (String s : movieLineData)
		{
			movies.add(translator.lineToMovie(s));
		}
		for (Movie m : movies)
		{
			System.out.println(m);
		}
		
		
		String ratingData = reader.readFile("u.data");
		String[] ratingLineData = ratingData.split(reader.lineSeparator);
		ArrayList<Rating> ratings = new ArrayList<Rating> ();
		for (String s : ratingLineData)
		{
			ratings.add(translator.lineToRating(s));
		}
		for (Rating r : ratings)
		{
			System.out.println(r);
		}
	}
}
