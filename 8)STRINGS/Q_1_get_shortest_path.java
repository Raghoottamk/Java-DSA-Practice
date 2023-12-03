import java.util.*;
public class Q_1_get_shortest_path {
    public static float Get_Shortest_Path(String path) {
        int x =0,y=0;
        for(int i=0;i<path.length();i++){
            
            char ch = path.charAt(i);
            //north
            if(ch == 'N'){
                y++;
            }
            //south
            else if(ch == 'S'){
                y--;
            }
            //west
            else if(ch == 'W'){
                x--;
            }
            //east
            else{
                x++;
            }
        }
        int x2 = x*x;
        int y2 = y*y;   
        return (float)(Math.sqrt(x2+y2));
    }
    public static void main(String[] args) {
        String path = "EWNSNSENSENENE";
        System.out.println(Get_Shortest_Path(path));
    }
}
