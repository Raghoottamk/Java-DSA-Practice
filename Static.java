class Student{
    String name;
    int roll;
    static String schoolname;
    //setter
    void setName(String name){
        this.name = name;
    }
    void getname(){
        System.out.println(this.name);
    }
}
public class Static {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.name = "raghu";
        s1.roll = 25;
        s1.schoolname = "Daffodils";
        System.out.println(s1.name+" "+ s1.roll+" "+s1.schoolname);
        System.out.println(s2.name+" "+ s2.roll+" "+s2.schoolname);//prints same schoolname of s1 as static keyword is used for schoolname
    } 
}
