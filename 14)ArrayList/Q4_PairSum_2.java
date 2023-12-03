//Find if any pair in a Sorted & Rotated ArrayList has a target sum

import java.util.ArrayList;

public class Q4_PairSum_2 {
    //brute force is same as normal twosum question
    public static ArrayList bruteForce(ArrayList<Integer>arr,int target){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0,-1);
        result.add(1,-1);
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.size();j++){
                if((arr.get(i)+arr.get(j)) == target){
                    result.set(0,i);
                    result.set(1,j);
                    return result;
                }
            }
        }
        return result;
    }
    public static ArrayList twoPointer(ArrayList<Integer>arr,int target){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0,-1);
        result.add(1,-1);
        int n = arr.size();
        int bp = -1;//bp is breaking point in rotated sorted array
        for(int i=0;i < n;i++){
            if(arr.get(i) > arr.get(i+1)){
                bp = i;
                break;
            }
        }
        int i = bp+1;//least valued element in the array
        int j=bp;//highest valued element in the arry
        while(i!=j){
            if(arr.get(i) + arr.get(j) == target){
                result.set(0,i);
                result.set(1,j);
                return result;
            }
            else if(arr.get(i) + arr.get(j) < target){
                i = (i+1) % n; //special formulae for rotated sorted array
            }
            //else if(arr.get(i)+arr.get(j) > target){
            else{
                j = (n+j-1) % n; //special formulae for rotated sorted array
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);list.add(15);list.add(6);list.add(8);list.add(9);list.add(10);
        System.out.println(list);
        System.out.print("Brute Force"+" -> ");
        System.out.println(bruteForce(list, 16));
        System.out.print("2Pointer"+" -> ");
        System.out.println(twoPointer(list, 16));
    }
}
