import java.util.ArrayList;


public class Movie 
{
	private long movieID;
	private String title;
	private String genre;
	
	private ArrayList<Rating> ratings;
	
	
	public Movie (long movieID, String title, String genre)
	{
		this.movieID = movieID;
		this.title = title;
		this.genre = genre;
	}
	
	
	public String toString ()
	{
		String output = "";
		
		output += movieID + " | ";		
		output += title + " | ";
		output += genre;
		
		return output;
	}
	
	
	public void addMovieRating (Rating r)
	{
		ratings.add(r);
	}
	
	public long getMovieID ()
	{
		return movieID;
	}
	
	public String getMovieTitle ()
	{
		return title;
	}
	
	public String getGenre ()
	{
		return genre;
	}
	
	public ArrayList<Rating> getRating ()
	{
		return ratings;
	}

                              
}
