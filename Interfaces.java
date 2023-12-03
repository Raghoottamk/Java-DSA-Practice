interface chessPlayer{
    void moves();
}
class Queen implements chessPlayer{
    public void moves(){//public keyword is mandatory as abstract methods of interfaces are public by default
        System.out.println("up,down,left,right,diagonal(in all 4 directions)");
    }
}
class Rook implements chessPlayer{
    public void moves(){
        System.out.println("up,down,left,right");
    }
}
interface Herbivore{
    void veg();
}
interface Carnivore{
    void nonveg();
}
//multiple inheritance can be achieved only using interfaces
class Bear implements Herbivore,Carnivore{
    public void veg(){
        System.out.println("eats veg");
    }
    public void nonveg(){
        System.out.println("eats non-veg");
    }
}
public class Interfaces {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves(); 
    }
}
