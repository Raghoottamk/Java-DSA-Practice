import java.util.*;

public class multidimensional_ArrayList {
    public static void main(String[] args) {
        //declaring multidimensional arraylist
        ArrayList<ArrayList> mainlist = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);list1.add(2);list1.add(3);
        list2.add(4);list2.add(5);list2.add(6);

        //Adding the secondary arraylists to the main multidimensional arrayList
        mainlist.add(list1);
        mainlist.add(list2);
        for(int i=0;i<mainlist.size();i++){
            ArrayList<Integer> currlist = mainlist.get(i);
            for(int j=0;j<currlist.size();j++){
                System.out.print(currlist.get(j) + " ");
            }
            System.out.println();
        }
        System.out.println(mainlist);
    }
}
