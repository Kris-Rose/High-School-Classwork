//2
import java.io.*;
import java.util.*;
public class Cemetery
{
    private ArrayList<Tombstone> graves;
    
    public Cemetery(String fileName) throws IOException
    {
        try{
           Scanner graveyard = new Scanner(new File(fileName)); 
           Scanner line;
           String name = "";
           String burialDate = "";
           int age = 0;
           String address = "";
           String stringAge = "";
           while(graveyard.hasNext()){
               line = new Scanner(graveyard.nextLine());
               while(!line.hasNextInt() ){
                   name += line.next() + " ";
                }
               for(int i = 0; i<3; i++){
                   burialDate += line.next() + " ";
                }
               stringAge = graveyard.next();
               while(line.hasNext()){
                   address += line.next();
                }
               age = parseAge(stringAge);
               graves.add(new Tombstone(name, burialDate, age, address));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Ding dong you are wrong");
        }
        
        
    }
    
    public static int parseAge(String ageString)
	{
		if (ageString.contains("d")) { //age supplied in days
			ageString = ageString.replaceAll("d", "");
			return Integer.parseInt(ageString);
		}
		int result = 0;
		boolean done = true;

		try { result = Integer.parseInt(ageString); } //is the String a whole number of years?
		
		catch (NumberFormatException n) { done = false; }
		
		if (done) //successfully parsed as an int, return value
			return 365 * result; //ignoring leap years
		
		double ageDouble = 0;
		done = true;
		
		try { ageDouble = Double.parseDouble(ageString); } //is the String a floating point number of years?
		
		catch (NumberFormatException n) { done = false; }
		if (done) { //successfully parse as a double, String doesn't contain any text
			return (int)(ageDouble * 365); //ignoring leap years, using 30 for days in a month
		}
		if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
			ageString = ageString.replaceAll("w", "");
			return Integer.parseInt(ageString) * 7;
		}
		return 0;
	}
	public ArrayList<Tombstone> getGraves(){
	    return graves;
	   }
}
