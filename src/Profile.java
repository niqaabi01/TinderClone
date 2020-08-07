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
   
    public String toString() {
        return person+"\n"+image;
    }
}


// Mike, 25, Male, PE, Hi guys, imagePath,cool guy, living good life, self love, food lover 
// Gale, 26, Non-Binary, KZN, Hey guys, imagePath, cool being, happy vibes, Gods fave, happyChild
// Mbali, 24, Female, JHB, Hala, imagePath, cool kid, Skr skr, goals, happy lif