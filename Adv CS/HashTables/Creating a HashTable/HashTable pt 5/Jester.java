

import java.util.*; 
import java.io.*; 
/**
 * Write a description of class tester here.
 *
 * @Krista R
 * @12/3/19
 */
public class Jester
{
    public static void main(String[] args){
        try{
            System.out.println("Type of hashing used – Quadratic Probing ");
            System.out.println("Hash function used – Integer value \n ");
            
            ArrayList<String> largeSet = new ArrayList<String>();
            ArrayList<String> successSearch = new ArrayList<String>();
            ArrayList<String> unsuccessSearch = new ArrayList<String>();
            
            Scanner a = new Scanner(new File("Large Data Set.txt"));
            Scanner b = new Scanner(new File("Successful Search.txt"));
            Scanner c = new Scanner(new File("Unsuccessful Search.txt"));
            
            while(a.hasNextLine()){
                largeSet.add(a.nextLine());
            }
            while(b.hasNextLine()){
                successSearch.add(b.nextLine());
            }
            while(c.hasNextLine()){
                unsuccessSearch.add(c.nextLine());
            }
            //1
            double[] loads = {0.1, 0.5, 0.8,0.9, 1};
            
            
            //load factor 0.1
            System.out.println("    Load Factor: 0.1");
            System.out.println("        Num of Records Added: 500,000");
            System.out.println("        Size: 4999999  ");
            HashTable one = new HashTable(4999999);
            long start = System.currentTimeMillis();
            for(int j = 0; j<largeSet.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                Car auto = new Car((largeSet.get(j).substring(0, 17)), (largeSet.get(j).substring(18, 22)), (largeSet.get(j).substring(23, 67)), largeSet.get(j).substring(67));
                one.put(id, auto);
            }
            long stop = System.currentTimeMillis(); 
            System.out.println("        Total Time: " + (stop-start) + " milliseconds");
            System.out.println("        Avg Insertion Time: " + ((stop-start)/500000.0 ) + " milliseconds");
            System.out.println("        Avg Collisions per Insertion: " + (one.getCollisions()/500000.0) );
            System.out.println("        Collisions v. Insertions - " + (one.getCollisions()/500000.0)*100 + "%  ");
            System.out.println("        Total Collisions: " + one.getCollisions());
            System.out.println("            -Successful Search-  ");
            long startSuccSearch = System.currentTimeMillis();
            for(int j = 0; j<successSearch.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                one.get(id);
            }
            long stopSuccSearch = System.currentTimeMillis(); 
            System.out.println("        Avg time needed to find table entry: " + ((stopSuccSearch-startSuccSearch)/10000.0) + " milliseconds");
            System.out.println("        Avg # of probes needed to find table entry: " + (one.getNumProbes()/10000.0));
            one.setNumProbes(0);
            System.out.println("            -Unsuccessful Search-  ");
            long startUnsuccSearch = System.currentTimeMillis();
            for(int j = 0; j<unsuccessSearch.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                one.get(id);
            }
            long stopUnsuccSearch = System.currentTimeMillis();
             System.out.println("        Avg time to determine entry is not in table: " + ((stopSuccSearch-startSuccSearch)/10000.0) + " milliseconds");
            System.out.println("        Avg # of probes to determine entry is not in table: " +  (one.getNumProbes()/10000.0) + " \n\n");
            one.setCollisions(0);
            
            
            
            
            
            //load factor 0.5
            System.out.println("    Load Factor: 0.5");
            System.out.println("        Number of Records Added: 500,000");
            System.out.println("        Table Size: 1000003  ");
            one = new HashTable(1000003);
            start = System.currentTimeMillis();
            for(int j = 0; j<largeSet.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                Car auto = new Car((largeSet.get(j).substring(0, 17)), (largeSet.get(j).substring(18, 22)), (largeSet.get(j).substring(23, 67)), largeSet.get(j).substring(67));
                one.put(id, auto);
            }
            stop = System.currentTimeMillis(); 
            System.out.println("        Total Time: " + (stop-start) + " milliseconds");
            System.out.println("        Avg Insertion Time: " + ((stop-start)/500000.0 ) + " milliseconds");
            System.out.println("        Avg Collisions per Insertion: " + (one.getCollisions()/500000.0) );
            System.out.println("        Collisions v. Insertions - " + (one.getCollisions()/500000.0)*100 + "%  ");
            System.out.println("        Total Collisions: " + one.getCollisions());
            System.out.println("            -Successful Search-  ");
            
            startSuccSearch = System.currentTimeMillis();
            for(int j = 0; j<successSearch.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                one.get(id);
            }
            stopSuccSearch = System.currentTimeMillis(); 
            System.out.println("        Avg time needed to find table entry: " + ((stopSuccSearch-startSuccSearch)/10000.0) + " milliseconds");
            System.out.println("        Avg # of probes needed to find table entry: " + (one.getNumProbes()/10000.0));
            one.setNumProbes(0);
            System.out.println("            -Unsuccessful Search-  ");
            
            startUnsuccSearch = System.currentTimeMillis();
            for(int j = 0; j<unsuccessSearch.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                one.get(id);
            }
            stopUnsuccSearch = System.currentTimeMillis();
             System.out.println("        Avg time to determine entry is not in table: " + ((stopSuccSearch-startSuccSearch)/10000.0) + " milliseconds");
            System.out.println("        Avg # of probes to determine entry is not in table: " +  (one.getNumProbes()/10000.0) + " \n\n");
            one.setCollisions(0);
            
            
             
            //load factor 0.8
            System.out.println("    Load Factor: 0.8");
            System.out.println("        Number of Records Added: 500,000");
            System.out.println("        Table Size: 624997  ");
            one = new HashTable(624997);
            start = System.currentTimeMillis();
            for(int j = 0; j<largeSet.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                Car auto = new Car((largeSet.get(j).substring(0, 17)), (largeSet.get(j).substring(18, 22)), (largeSet.get(j).substring(23, 67)), largeSet.get(j).substring(67));
                one.put(id, auto);
            }
            stop = System.currentTimeMillis(); 
            System.out.println("        Total Time: " + (stop-start) + " milliseconds");
            System.out.println("        Avg Insertion Time: " + ((stop-start)/500000.0 ) + " milliseconds");
            System.out.println("        Avg Collisions per Insertion: " + (one.getCollisions()/500000.0) );
            System.out.println("        Collisions v. Insertions - " + (one.getCollisions()/500000.0)*100 + "%  ");
            System.out.println("        Total Collisions: " + one.getCollisions());
            System.out.println("            -Successful Search-  ");
            
            startSuccSearch = System.currentTimeMillis();
            for(int j = 0; j<successSearch.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                one.get(id);
            }
            stopSuccSearch = System.currentTimeMillis(); 
            System.out.println("        Avg time needed to find table entry: " + ((stopSuccSearch-startSuccSearch)/10000.0)+ " milliseconds");
            System.out.println("        Avg # of probes needed to find table entry: " + (one.getNumProbes()/10000.0));
            one.setNumProbes(0);
            System.out.println("            -Unsuccessful Search-  ");
            
            startUnsuccSearch = System.currentTimeMillis();
            for(int j = 0; j<unsuccessSearch.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                one.get(id);
            }
            stopUnsuccSearch = System.currentTimeMillis();
             System.out.println("        Avg time to determine entry is not in table: " + ((stopSuccSearch-startSuccSearch)/10000.0) + " milliseconds");
            System.out.println("        Avg # of probes to determine entry is not in table: " +  (one.getNumProbes()/10000.0) + " \n\n");
            one.setCollisions(0);
            
            
            
            
            //load factor 0.9
            System.out.println("    Load Factor: 0.9");
            System.out.println("        Number of Records Added: 500,000");
            System.out.println("        Table Size: 555557  ");
            one = new HashTable(555557);
            start = System.currentTimeMillis();
            for(int j = 0; j<largeSet.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                Car auto = new Car((largeSet.get(j).substring(0, 17)), (largeSet.get(j).substring(18, 22)), (largeSet.get(j).substring(23, 67)), largeSet.get(j).substring(67));
                one.put(id, auto);
            }
            stop = System.currentTimeMillis(); 
            System.out.println("        Total Time: " + (stop-start) + " milliseconds");
            System.out.println("        Avg Insertion Time: " + ((stop-start)/500000.0 ) + " milliseconds");
            System.out.println("        Avg Collisions per Insertion: " + (one.getCollisions()/500000.0) );
            System.out.println("        Collisions v. Insertions - " + (one.getCollisions()/500000.0)*100 + "%  ");
            System.out.println("        Total Collisions: " + one.getCollisions());
            System.out.println("            -Successful Search-  ");
            
            startSuccSearch = System.currentTimeMillis();
            for(int j = 0; j<successSearch.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                one.get(id);
            }
            stopSuccSearch = System.currentTimeMillis(); 
            System.out.println("        Avg time needed to find table entry: " + ((stopSuccSearch-startSuccSearch)/10000.0)+ " milliseconds");
            System.out.println("        Avg # of probes needed to find table entry: " + (one.getNumProbes()/10000.0));
            one.setNumProbes(0);
            System.out.println("            -Unsuccessful Search-  ");
            
            startUnsuccSearch = System.currentTimeMillis();
            for(int j = 0; j<unsuccessSearch.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                one.get(id);
            }
            stopUnsuccSearch = System.currentTimeMillis();
             System.out.println("        Avg time to determine entry is not in table: " + ((stopSuccSearch-startSuccSearch)/10000.0) + " milliseconds");
            System.out.println("        Avg # of probes to determine entry is not in table: " +  (one.getNumProbes()/10000.0) + " \n\n");
            one.setCollisions(0);
            
            
            
            
            //load factor 1
            System.out.println("    Load Factor: 1");
            System.out.println("        Number of Records Added: 500,000");
            System.out.println("        Table Size: 500009  ");
            one = new HashTable(500009);
            start = System.currentTimeMillis();
            for(int j = 0; j<largeSet.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                Car auto = new Car((largeSet.get(j).substring(0, 17)), (largeSet.get(j).substring(18, 22)), (largeSet.get(j).substring(23, 67)), largeSet.get(j).substring(67));
                one.put(id, auto);
            }
            stop = System.currentTimeMillis();
            System.out.println("        Total Time: " + (stop-start) + " milliseconds");
            System.out.println("        Avg Insertion Time: " + ((stop-start)/500000.0 ) + " milliseconds");
            System.out.println("        Avg Collisions per Insertion: " + (one.getCollisions()/500000.0) );
            System.out.println("        Collisions v. Insertions - " + (one.getCollisions()/500000.0)*100 + "%  ");
            System.out.println("        Total Collisions: " + one.getCollisions());
            System.out.println("            -Successful Search-  ");
            
            startSuccSearch = System.currentTimeMillis();
            for(int j = 0; j<successSearch.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                one.get(id);
            }
            stopSuccSearch = System.currentTimeMillis(); 
            System.out.println("        Avg time needed to find table entry: " + ((stopSuccSearch-startSuccSearch)/10000.0)+ " milliseconds");
            System.out.println("        Avg # of probes needed to find table entry: " + (one.getNumProbes()/10000.0));
            one.setNumProbes(0);
            System.out.println("            -Unsuccessful Search-  ");
            
            startUnsuccSearch = System.currentTimeMillis();
            for(int j = 0; j<unsuccessSearch.size();j++){
                VIN id = new VIN(largeSet.get(j).substring(0, 17));
                one.get(id);
            }
            stopUnsuccSearch = System.currentTimeMillis();
             System.out.println("        Avg time to determine entry is not in table: " + ((stopSuccSearch-startSuccSearch)/10000.0) + " milliseconds");
            System.out.println("        Avg # of probes to determine entry is not in table: " +  (one.getNumProbes()/10000.0) + " \n\n");
            one.setCollisions(0);
            
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        
        
        
        
       
    }
}
