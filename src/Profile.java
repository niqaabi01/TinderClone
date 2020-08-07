public class Profile
{
    private Person person;
    private Images image;

    public Profile(Person person, Images image)
    {
        this.person = person;
        this.image = image;
    }

    public Person getPerson()
    {
        return this.person;
    }
    public Images getImage()
    {
        return this.image;
    }
}