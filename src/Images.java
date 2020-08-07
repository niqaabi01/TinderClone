import java.util.*;

public class Images
{
    private String url;
    private String description;
    private String title;
    ArrayList<String> tags = new ArrayList<>();



    public Images(String url, String description, String title, ArrayList<String> tags)
    {
        this.url = url;
        this.description = description;
        this.title = title;
        this.tags = tags;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
    
    public String getUrl(String url)
    {
        return this.url;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getDescription(String description)
    {
        return this.description;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return this.title;
    }
    
    public void setTags(ArrayList<String> tags)
    {
        this.tags = tags;
    }
    
    public ArrayList<String> setTags()
    {
        return this.tags;
    }
    

    @Override
    public String toString() {
        return "Check me out @ "+ url+"\n" + "Caption :" + description +"\n"+ tags.toString() ;
    }
}