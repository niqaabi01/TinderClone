import java.io.*;
import java.util.*;

public class DatabaseUser
{
    //attributes
    private String filePathToCSV = "C:\\Users\\saani\\Documents\\Tinder\\bin\\users.csv";//users.csv
    private Images image;
    private Person person;
    private int numberOfFemales, numberOfMales, numberOfNON_Binary_Individuals;
    private Profile[] profile;

    //constructor   
    
    DatabaseUser() {}

    public int countLinesInCSV(String filename)
    {
        int i = 0;
        try 
        {
            BufferedReader csvReader = new BufferedReader(new FileReader(filePathToCSV));
            String row = null;
            while((row = csvReader.readLine()) != null)
            {
                i++;
            }
            csvReader.close();
        }
        catch(Exception e) 
        {
            System.out.println("Error: " + e.toString());
        }

        // System.out.println("Number of Profiles in the file: " +i);
        return i;
    }

    // public void printArray(Driver[] drivers) {
    //     System.out.print("[ ");
    //     for(Driver d: drivers) {
    //         System.out.print(d);
    //         System.out.print(",");
    //         System.out.println("");
    //     }
    //     System.out.print(" ]");
    // }
    //methods
    public Profile[] getProfileArray()
    {
        /**
         * read data from csv
         * create person object using last 5 columns
         * create image object using first last remaining columns
         * add the person and image created to a
         */
        
        try
        {
            BufferedReader csvReader = new BufferedReader(new FileReader(filePathToCSV));
            String row = null;
            int i=0; 
            this.profile = new Profile[countLinesInCSV(filePathToCSV)-1];
            while((row = csvReader.readLine()) != null)
            {
                if(i > 0)
                {
                    String[] data = row.split(",");
                    person = new Person(data[0].trim(),Integer.parseInt( data[1].trim()), data[2].trim(), data[3].trim(), data[4].trim());
                    ArrayList<String> tags = new ArrayList<String>();
                    tags.add(data[8].trim());
                    tags.add(data[9].trim()  );
                    tags.add(data[10].trim());
                    
                    image = new Images( data[5].trim(), data[6].trim(), data[7].trim(),tags);
                    Profile profile = new Profile(person, image);

                    this.profile[i-1] = profile;
                }
                i++;
    
            }
            csvReader.close();
        }
        
        catch(Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return this.profile;

    }
    

    public void TinderSwipeSave(Profile profile) throws IOException {
        try{
        File file =new File("Matches.csv");
        //  creates new files
        file.createNewFile();
        // creates a file write object without overiding previously stored data
        Writer writer = new FileWriter(file, true);
        writer.write("\n");
        writer.write(profile+"\n");
        
        writer.flush();
        writer.close();
        
    }catch (IOException e) {
        System.out.println("Error");
        e.printStackTrace();
    }
}
}