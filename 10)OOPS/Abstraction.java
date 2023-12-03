abstract class Animal{
    String color;
    Animal(){
        System.out.println("animal class is called");
    }
    void eat(){
        System.out.println("animal eats");
    }
    abstract void walk();//throws error in child class if this function is not impleted
}
class Horse extends Animal{
    Horse(){
        System.out.println("Horse is called");
    }
    void change_color(){
        color = "dark brown";
    }
    void walk(){
        System.out.println("walks on four legs");
    }
}
class Mushtag extends Horse{
    Mushtag(){
        System.out.println("Mushtag class is called");
    }
}
public class Abstraction {
    public static void main(String[] args) {
        Mushtag m1 = new Mushtag();
        
    }
}
