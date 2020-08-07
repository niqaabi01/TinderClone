public class Person
{
    private String name;
    private int age;
    private String gender;
    private String location;
    private String bio;

    Person(String name, int age ,String gender,String location ,String bio){
        this.name =name;
        this.age = age;
        this.age =age;
        this.gender = gender;
        this.location =  location;
        this.bio = bio;
    }
    
    
    public String getName()
    {
        return name;
    }
        
    public void setName(String name)
    {
        this.name = name; 
    }
    
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age =age;
    }
    
    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getLocation()
    {
        return location;    
    }
    public void setLocation(String location)
    {
        this.location = location;
    }

    public void setBio(String bio)
    {
        this.bio = bio;
    }
    //hobbie and stuff
    public String getBio()
    {
        return this.bio;
    }
    

    @Override
    public String toString() {
        return "Hi I am " + name +", "+age+ " ("+gender+")" +"\n"+ bio +"\n"+ location;
    }
}