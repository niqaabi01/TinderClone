import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;



public class TinderApp
{
	private static DatabaseUser dataObj = new DatabaseUser();
	private static Profile[] allProfile = dataObj.getProfileArray();
	private static ArrayList<Profile> filteredProfiles = new ArrayList<>();
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		String userPreference;// variable to store user preference
		System.out.println("Are you interested in Male(M) or Female(F) or Non-Binary(NB)");
		userPreference = input.nextLine().toUpperCase();// get user preference
		
		filterProfiles(userPreference);  
		
		int index = 0;
		String swipeOption = "";
		System.out.println(filteredProfiles.get(index));// print the very first profile

		//Traverse through the list of all the profiles

		while(true)
		{
            System.out.println("Swipe Left(L) or Right(R) or Exit(Q)");
			swipeOption = input.nextLine().toUpperCase();//get user swipeOption
		
			if(swipeOption.equals("L"))
			{
				if(index < (filteredProfiles.size()-1)){
					index++;
					System.out.println(filteredProfiles.get(index));//display the next profile
				}
				else if(index == (filteredProfiles.size()-1)){
					System.out.println( "OH no!!!"+ " \n"+"No More matches available ");
					break;
				}
				
			}
			else if(swipeOption.equals("R"))
			{
				dataObj.TinderSwipeSave(filteredProfiles.get(index));
				System.out.println("Profile saved");
				if(index < (filteredProfiles.size()-1)){
					index++;
					System.out.println(filteredProfiles.get(index));//display the next profile
				}
				else if(index == (filteredProfiles.size()-1)){
					System.out.println( "OH no!!!"+ " \n"+"No More matches available ");
					System.out.println("Maybe your love is waiting on you to broaden your search.......");
					break;
				}

			}
			else if(swipeOption.equals("Q"))
			{
				System.out.println("Thank you for using TinderClone"+"\nGood Bye");
				break;
			}
        }
	}
	/**
	 * This method filters the profiles based on the gender preference of the user
	 * @param userPreference
	 */
	static void filterProfiles(String userPreference)
	{
		switch (userPreference)
		{
			case "F":
				//Keep ladies only
				int j = 0;
				for(int i = 0; i < allProfile.length; i++)
				{
					if(allProfile[i].getPerson().getGender().equals("Female"))
					{
						filteredProfiles.add(allProfile[i]);
						j++;
					}
				}
				break;
			case "M":
				// Keep only guys
				int p = 0;
				for(int i = 0; i < allProfile.length; i++)
				{
					if(allProfile[i].getPerson().getGender().equals("Male"))
					{
						filteredProfiles.add(allProfile[i]);
						p++;
					}
				}
				break;
			case "NB":
				// Keep the list as is
				for (int i = 0; i < allProfile.length; i++)
					filteredProfiles.add(allProfile[i]);
				break;
		}
//		switch (userPreference)
//		{
//			case "F":
//				//Keep ladies only
//				filteredProfiles = dataObj.getFemales();
//				break;
//			case "M":
//				// Keep only guys
//				filteredProfiles = dataObj.getMales();
//				break;
//			case "NB":
//				// Keep the list as is
//				filteredProfiles = allProfile;
//				break;
//		}
	}
}



