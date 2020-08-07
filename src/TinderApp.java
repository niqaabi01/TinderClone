import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;



public class TinderApp {
	private static DatabaseUser dataObj = new DatabaseUser();
	private static Profile[] allProfile = dataObj.getProfileArray();
	private static Profile[] filteredProfiles = new Profile[4];
	private static ArrayList<String> Females= new ArrayList<>();
	private static ArrayList<String> Males= new ArrayList<>();
	


	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
        
		String userPreferrence;// variable to store user preferrence
		System.out.println("Are you interested in Male(M) or Female(F) or NonBinary(NB)");
		userPreferrence = input.nextLine().toUpperCase();// get user preferrence
		filterProfiles(userPreferrence);

		// String swipeOption = "";
		int index = 0;
		System.out.println(filteredProfiles[index]);// print the very first profile
        // String swipeOption = "";
        // Traverse through the list of filtered profiles
        String swipeOption = "";
		// while (swipeOption != null) {
        //     processUserSwipes(swipeOption, index);
        //     String option =input.nextLine();
        // }
        boolean Flag =true;
		while(Flag ==true){
            System.out.println("Swipe Left(L) or Right(R) or Exit(Q)");
		swipeOption = input.nextLine().toUpperCase();//get user swipeOption
		
		if(swipeOption.equals("L"))
		{
			index++;
			System.out.println(filteredProfiles[index]);//print out the next profile
		}
		else if(swipeOption.equals("R"))
		{
			dataObj.TinderSwipeSave(filteredProfiles[index]);
			System.out.println("Profile saved");

			System.out.println("");
			System.out.println("Viewing Next Profile...........");
			index++;
			System.out.println(filteredProfiles[index]);//print out the next profile
			// System.out.println("Swipe Left(L) or Right(R) or Exit(Q)");
			// swipeOption = input.nextLine().toUpperCase();//get user swipeOption
        }
        else if(swipeOption.equals("Q")){
            Flag= false;
            System.out.println("Thank you for using TinderClone"+"\n"+"Good Bye");
            break;
        }
        }
	}

	static void filterProfiles(String userPreferrence) {
		switch (userPreferrence) {
			case "F":
				//Keep ladies only
				int j = 0;
				for (int i = 0; i < allProfile.length; i++) {
					if (allProfile[i].getPerson().getGender().equals("Female")) {
						filteredProfiles[j] = allProfile[i];
						Females.add(String.valueOf(filteredProfiles[j] ));
						j++;
					}
				}
			case "M":
				// Keep only guys
				int p = 0;
				for (int i = 0; i < allProfile.length; i++) {
					if (allProfile[i].getPerson().getGender().equals("Male")) {
						filteredProfiles[p] = allProfile[i];
						Males.add(String.valueOf(filteredProfiles[p]));
						p++;
					}
				}
			case "NB":
				// Keep the list as is
				for (int i = 0; i < allProfile.length; i++)
					filteredProfiles[i] = allProfile[i];
		}
	}

	// static void processUserSwipes(String swipeOption, int index) throws IOException
	// {
	// 	System.out.println("Swipe Left(L) or Right(R) or Exit(Q)");
	// 	swipeOption = input.nextLine().toUpperCase();//get user swipeOption
		
	// 	if(swipeOption.equals("L"))
	// 	{
	// 		index++;
	// 		System.out.println(filteredProfiles[index].getPerson());//print out the next profile
	// 	}
	// 	else if(swipeOption.equals("R"))
	// 	{
	// 		dataObj.TinderSwipeSave(filteredProfiles[index]);
	// 		System.out.println("Profile saved");
	// 		System.out.println("Would you like to continue");
	// 		swipeOption = input.nextLine().toUpperCase();//get user swipeOption
    //     }
    //     else if(swipeOption.equals("Q"))//
	// }
}