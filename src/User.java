import java.util.ArrayList;


public class User 
{
	private long userID;
	private int age;
	private char gender;
	private String occupation;
	private String zipCode;
	
	public ArrayList<Rating> ratings;


	public User (long userID, int age, char gender, String occupation, String zipCode)
	{
		this.userID = userID;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.zipCode = zipCode;
	}
	
	public String toString ()
	{
		String output = "";
		
		output += ratings + " | ";
		
		output += userID + " | ";
		output += age + " | ";
		output += gender + " | ";
		output += occupation + " | ";
		output += zipCode;
		
		return output;
	}
	
	
	public void addUserRating (Rating r)
	{
		ratings.add(r);
	}
	
	public long getUserID ()
	{
		return userID;
	}
	
	public int getAge ()
	{
		return age;
	}
	
	public char getGender ()
	{
		return gender;
	}
	
	public String getOccupation ()
	{
		return occupation;
	}
	
	public String getZipCode ()
	{
		return zipCode;
	}
}
