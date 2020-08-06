import java.io.*;
import java.util.*;

public class DatabaseUser
{
    //attributes
    private String filePathToCSV = "C:\\Users\\saani\\Documents\\Tinder\\users.csv";//users.csv
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

        System.out.println("Number of Profiles in the file: " + (i+1));
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
    public void getProfileArray()
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
                System.out.println(row);
                if(i > 0)
                {
                    String[] data = row.split(",");
                    person = new Person(data[0].trim(),Integer.parseInt( data[1].trim()), data[2].trim(), data[3].trim(), data[4].trim());
                    System.out.println(person);
                    ArrayList<String> tags = new ArrayList<String>();
                    tags.add(data[8].trim());
                    tags.add(data[9].trim());
                    tags.add(data[10].trim());
                    
                    image = new Images( data[5].trim(), data[6].trim(), data[7].trim(),tags);
                    System.out.println(image);
                    Profile profile = new Profile(person, image);

                    if(data[2].trim().equals("Male")) {
                        this.numberOfFemales++;
                    }
                    if(data[2].trim().equals("Female")) {
                        this.numberOfMales++;
                    }
                    if(data[2].trim().equals("Non-Binary")) {
                        this.numberOfNON_Binary_Individuals++;
                    }
                    this.profile[i-1] = profile;
                }
                i++;
    
            }
            csvReader.close();
        }
        
        catch(Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    // public Driver[] getArrayByVehicleType(String vehicleType) {

    //     Driver[] Xdrivers = new Driver[this.numberOfX];
    //     Driver[] XLdrivers = new Driver[this.numberOfXL];

    //     int xindex = 0;
    //     int xlindex = 0;
    //     for(int i=0; i<this.drivers.length; i++) {
    //         if(this.drivers[i].getCar().getVehicleType().equals("X")) {
    //             Xdrivers[xindex] = this.drivers[i];
    //             xindex++;
    //         }
    //         if(this.drivers[i].getCar().getVehicleType().equals("XL")) {
    //             XLdrivers[xlindex] = this.drivers[i];
    //             xlindex++;
    //         }
    //     }

    //     if(vehicleType.equals("X")) {
    //         return Xdrivers;
    //     }

    //     return XLdrivers;

    //     // Driver[] drivers = 


    //     // for
    // }
}