import java.util.*;
import javafx.util.Pair;
/*
Question-
Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
Example 1:
Input: path = "NES"
Output: false 
Explanation: Notice that the path doesn't cross any point more than once.

Example 2:
Input: path = "NESWW"
Output: true
Explanation: Notice that the path visits the origin twice.
 */
public class Q2_Path_crossing {
    
    public boolean isPathCrossing(String path) {
        Integer x = 0;
        Integer y = 0;
        Set<Pair<Integer,Integer>> set = new HashSet<>();
        set.add(new Pair(0,0));
        for(int i = 0;i < path.length();i++){
            if(path.charAt(i) == 'N'){
                y += 1;
            }
            else if(path.charAt(i) == 'S'){
                y -= 1;
            }
            else if(path.charAt(i) == 'E'){
                x += 1;
            }
            else{
                x -= 1;
            }
            Pair<Integer,Integer> pair = new Pair(x,y);
            if(set.contains(pair)){
                return true;
            } 
            set.add(pair);
        }
        return false;
    }
}