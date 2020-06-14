import java.util.*;
import java.io.*;
/**
 * 
 *
 * @Krista R
 * @12-29-19
 */
public class Open
{
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(new File("source.dat"));
            while(input.hasNextLine()){
                String next = input.nextLine();
                while(!(next.equals("0"))){
                    
                    HashMap h = new HashMap();
                    
                    ArrayList<String> projects = new ArrayList();
                    ArrayList<String> blockList = new ArrayList();
                    ArrayList<String> users = new ArrayList();
                    
                    
                    
                    
                    //get all names once and list of projects
                    while(!(next.equals("1"))){
                        if(next.charAt(0)>= 65 && next.charAt(0)<= 90){
                            projects.add(next);
                        }
                        if(next.charAt(0)>= 97 && next.charAt(0)<= 122){
                            
                            
                                //if not on block list
                                if(!(blockList.contains(next))){
                                    if(!(users.contains(next)) ){
                                        users.add(next);
                                    }
                                
                                    
                                    //if student already signed up
                                    if(h.containsKey(next)){
                                        //if signed up on different or same project
                                        
                                        if( h.get(next).equals( projects.get(projects.size()-1)) ){
                                            //vibe (same project)
                                        }
                                        else{
                                            h.remove(next);
                                            blockList.add(next);
                                            users.remove(next);
                                        }
                                    }
                                    else{
                                        h.put(next, projects.get(projects.size()-1) );
                                    }
                                    
                                    
                                    
                                    
                                }
                                   
                            
                        }    
                        next = input.nextLine();
                    }
                    
                    
                    
                    ArrayList a = new ArrayList();
                    ArrayList b = new ArrayList();
                    //give outputs
                    //for each project
                    for(int j = 0;j<projects.size();j++){
                        String project = projects.get(j);
                        int signups = 0;
                        //see how many students in each project
                        for(int k = 0;k<users.size(); k++){
                            if(h.containsKey(users.get(k))){
                                if(h.get(users.get(k)).equals( projects.get(j) ) ){
                                    signups++;
                                    h.remove(users.get(k));
                                }
                            }
                            
                            
                            
                            
                        }
                        a.add(project);
                        b.add(signups);
                        
                        
                    }
                    
                    int lorge = 0;
                    int index = 0;
                    while(a.size()>0){
                        //find largest num signups
                        lorge = (int)Collections.max(b);
                        index = b.indexOf(Collections.max(b));
                        //alphabeticallize other possible largert signups
                        for(int i = 0;i< a.size();i++ ){
                            int temp = (int)b.get(index);
                            
                            if(( (int)(b.get(i)) >= lorge) ){
                                if((((String)a.get(i) ).compareTo((String)a.get(index)) ) <1){
                                    index = i;
                                }
                            }
                            
                        }
                        
                        System.out.println(a.get(index) + " " + b.get(index));
                        a.remove(index);
                        b.remove(index);
                    }
                    
                    
                    
                    next = input.nextLine();
                    System.out.println();
                }
                
                
                
                
            }
            
            
            
        }
        catch(Exception E){
            
        }
        
        
        
    }

    
}
