class Pen{
    //Topic:Introduction to OOPS
    /*Noun = class. here Pen
      adjective = attributes. here color and thick
      verb = methods. here set_color and set_thick
    */
    String color ;//String color = "navy blue"
    Integer thick =10;
    void set_color(String newcolor){
        color = newcolor;
    }
    void set_thick(Integer newthick){
        thick = newthick;
    }
}
class Bankaccount{
    //Topic:Access modifiers
    public String username;
    private String password;
    public String set_password(String pwd){
        password = pwd;
        return password;
    }
}
class Pen1{
    //Topic:Getters and Putters
    private String color = "yellow";
    private Integer thick = 10;

    String get_color(){
        return this.color;//return color //is even correct
    }
    Integer get_thick(){
        return this.thick;//return thick //is even corre
    }
    //methods get_color,get_thick are called getters as it returns the value of the Attribute
    Integer set_thick(Integer thick){
        this.thick = thick;
        /*this is a keyword used to refer the class it is helpful in avoiding confusion here this.thick refers to Attribute thick and thick refers to argument of the method*/
        return thick;
    }
    //method like set_thick are called setters as it sets the value of the Attribute
}
class Student{
    //Topic: constructor
    String name;
    Integer rollno;
    String password;
    int[] marks = new int[3];
    //constructor method
    //constructor overloading
    Student(){
        System.out.println("non-parameterized constructor");
    }
    Student(Integer rollno){
        this.rollno = rollno;
        System.out.println(this.rollno);
    }
    Student(String name){
        this.name = name;
        System.out.println("constructor method is used");
    }
    //copy constructor
    Student(Student s){
        this.name = s.name;
        this.rollno = s.rollno;
        this.password = s.password;
        //Shallow copy
        s.password = "xyz";
        // this.marks = s.marks;

        //deep copy
        this.marks[0] = s.marks[0] = 100;
        this.marks[1] = s.marks[1] = 90; 
        this.marks[2] = s.marks[2] = 80;  
    }
}


public class Oops_intro {
    public static void main(String[] args) {
        // //class Pen
        // Pen p1 = new Pen();//creating an object named p1 which follows the blueprint of class Pen
        // System.out.println(p1.color);//returns 'null' if attributes are not equated to any value
        // p1.color = "yellow";
        // System.out.println(p1.color);
        // p1.color = "green";
        // System.out.println(p1.color);
        // p1.set_color("Bhagawa");
        // System.out.println(p1.color);
        // p1.set_thick(10);
        // System.out.println(p1.thick);


        // //class Bankaccount 
        // Bankaccount myacc = new Bankaccount();
        // myacc.username = "raghu";
        // /*throws error 
        // myacc.password = "raghu123";//private access modifier
        // */
        // myacc.set_password("raghu");
        // System.out.println(myacc.username);
        // //System.out.println(myacc.password);//throws error
        // System.out.println(myacc.set_password("raghu123"));

        //class Pen1
        // Pen1 mypen = new Pen1();
        // System.out.println(mypen.get_color());
        // System.out.println(mypen.get_thick());
        // System.out.println(mypen.set_thick(25));

        //class constructor
        Student s1 = new Student();
        // Student s2 = new Student(25);
        // Student s3 = new Student("raghu");
        //throws error: Student s4 = new Student("raghu",25); //as there are no constructor created by me in class student
        s1.name = "raghu";
        s1.rollno = 12;
        Student s4 = new Student(s1);//copy
        //shallow copy
        //changes dont reflect
        s1.password = "raghu123";//prints xyz as it was set in copy constructor
        s4.password = "raghu456";
        System.out.println(s1.password);
        System.out.println(s4.password);
        //deep copy as array access the refrences the following code replaces the old values of array
        //changes do reflect
        s1.marks[0] =70;
        s1.marks[1] =80;
        s1.marks[2] =60;
        
        for(int i =0;i<3;i++){
            System.out.println(s1.marks[i]);//prints 70,80,60
        }
        for(int i=0;i<3;i++){
            System.out.println(s4.marks[i]);
        }
    }
}

