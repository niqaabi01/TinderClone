public class ProfileSorter{
    private static DatabaseUser dataObj1 = new DatabaseUser();
    private static Profile[] allProfile = dataObj1.getProfileArray();
    private static Profile[] filteredProfiles = new Profile[4];

    ProfileSorter (){}

    public static void GetFemaleProfiles(String userPreference) {
        //Keep ladies only
				int j = 0;
				for (int i = 0; i < allProfile.length; i++) {
					if (allProfile[i].getPerson().getGender().equals("Female")) {
						filteredProfiles[j] = allProfile[i];
						j++;
						break;  
                }
        }
    }
}
