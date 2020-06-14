
public class Student implements Comparable<Student>
{
    private String name;
    private int studentID;
    public Student()
    {
        name = "bobert";
        studentID = 123456;
    }
    public Student(String name, int StudentID)
    {
        this.name = name;
        this.studentID = StudentID;
    }
    
    public String getName(){
        return name;
    }
    public int getID(){
        return studentID;
    }
    
    public String toString(){
        return "" + studentID + ": " + name + "";
    }
    public boolean equals(Student a){
        if(studentID == a.getID()){
            return true;
        }
        else{
            return false;
        }
    }
    
    /*
    public int compareTo(Student a){
        if(this.studentID> a.getID()){
            return 1;
        }
        else if(this.studentID< a.getID()){
            return -1;
        }
        else{
            return 0;
        }
    }
    */
    
    public int compareTo(Student a){
        if(this.name.compareTo(a.getName()) >0 ){
            return 1;
        }
        else if(this.name.compareTo(a.getName()) <0 ){
            return -1;
        }
        else{
            return 0;
        }
    }
    
}
