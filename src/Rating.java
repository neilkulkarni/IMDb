import java.util.ArrayList;


public class Rating 
{
	private long userID;
	private long movieID;

	private int stars;

	
	public Rating (long users, long movies, int stars)
	{
		userID = users;		
		movieID = movies;
		this.stars = stars;
	}
	

	public String toString ()
	{
		String output = "";
		
		output += stars + " | ";
		
		output += userID + " | ";
		
		output += movieID;
		
		return output;
	}
	
	
	public int getStars ()
	{
		return stars;
	}
	
	public long getUserID ()
	{
		return userID;
	}
	
	public long getMovieID ()
	{
		return movieID;
	}
}
