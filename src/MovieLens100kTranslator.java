import java.util.ArrayList;


public class MovieLens100kTranslator 
{
	public User lineToUser (String line)
	{
		
		String[] data = line.split("\\|");
		
		int userID = Integer.parseInt(data[0]);
		
		int age = 0;
		
		if (data[1].length() > 0)
		{
			age = Integer.parseInt(data[1]);
		}
		
		char gender = 'U';
		
		if (data[2].length() > 0)
		{
			gender = data[2].charAt(0);
		}
		
		return new User (userID, age, gender, data[3], data[4]);
	}
	
	
	public Movie lineToMovie (String line)
	{
		String[] data = line.split("\\|");
		
		String title = data[1];
		
		int movieID = Integer.parseInt(data[0]);
		
		int[] num = new int[19];
		
		for (int i = 5; i < 24;i++) 
		{
			int x = Integer.parseInt(data[i]);
			
			num[i-5] = x;
		}
		
		return new Movie(movieID, title, data[2]);
	}
	
	
	public Rating lineToRating (String line) //, ArrayList<User> users, ArrayList<Movie> movies)
	{
		String[] data = line.split("\t");
		
		int uID = Integer.parseInt(data[0]);
		int mID = Integer.parseInt(data[1]);
		int stars = Integer.parseInt(data[2]);
		
		/*
		User user = null;
		Movie movie = null;
		
		for (User u : users)
		{
			if (u.getUserID() == uID)
			{
				user = u;
				break;
			}
		}
		
		for (Movie m : movies)
		{
			if (m.getMovieID() == mID)
			{
				movie = m;
				break;
			}
		}
		*/
		
		Rating out = new Rating (uID, mID, stars);
		
		return out;
	}
}
