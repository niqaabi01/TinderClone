public class Main 
{
    public static void main(String[] args)
    { 
        //String name, int age ,String gender,String location ,String bio
        Person personObj = new Person("Asive", 20, "F", "CPT", "Feeling happy");
      //  System.out.println(personObj);
        DatabaseUser  data =new DatabaseUser();
        Profile[] profile1 = data.getProfileArray();
        System.out.println(profile1[0].getPerson());
        System.out.println(profile1[2].getPerson());
        


        



    }
}