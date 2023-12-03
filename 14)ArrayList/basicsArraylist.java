import java.util.*;
//import java.util.ArrayList;

public class basicsArraylist {
    public static void main(String[] args) {
        //Syntax
        //ArrayList<Class name> variable = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Float> list3 = new ArrayList<>();
        ArrayList<Boolean> list4 = new ArrayList<>();

        //Operation on arraylist
        //1- add
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        System.out.println(list1);
        // System.out.println(list2);

        // //2- get element
        // System.out.println(list1.get(2));

        // //3- remove 
        // list1.remove(2);
        // System.out.println(list1);

        // //4- set
        // list1.set(2,10);//it removes the prevoiusly existing element on that index
        // System.out.println(list1);
        // list1.add(2,2);//unlike set doesnot remove the previous element
        // System.out.println(list1);

        // //5- contains
        // System.out.println(list1.contains(4));

        //print elements of arraylist in reverse order
        System.out.println(list1);
        for(int i = list1.size()-1;i>=0;i--){
            System.out.print(list1.get(i)+" ");
        }

        //print the maximum valued element in an arraylist
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list1.size();i++){
            // if(max < list1.get(i)){
            //     max = list1.get(i);
            // }
            max = Math.max(max,list1.get(i));
        }
        System.out.println("max element = " + max);

        //Inbuilt sorting in ArrayList
        // assending order
        Collections.sort(list1);
        System.out.println(list1);
            //descending order
        Collections.sort(list1,Collections.reverseOrder());
        System.out.println(list1);
    }
}
