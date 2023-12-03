class Calculator{
    //Topic: method overloading
    int sum(int a,int b){
        return a+b;
    }
    float sum(float a,float b){
        return a+b;
    }
    int sum(int a,int b,int c){
        return a+b+c; 
    }

}
class Animal{
    //Topic: method overriding
    void eat(){
        System.out.println("eats");
    }
}
class Deer extends Animal{
    void eat(){
        System.out.println("eats grass");//overwrites eats from parent class
    }
}
public class Polymorphism {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        System.out.println(c1.sum(3,4));
        System.out.println(c1.sum((float)3.7,(float)4.6));
        System.out.println(c1.sum(3,4,6));

        //class Animal class deer
        Deer deer = new Deer();
        deer.eat();
    }
}
