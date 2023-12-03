//two sum in leetCode
//Find if any pair in a sorted ArrayList has a target sum
import java.util.ArrayList;

public class Q3_PairSum_1 {
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
        int i=0,j=arr.size()-1;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0,-1);
        result.add(1,-1);
        while(i<=j){
            if(arr.get(i)+arr.get(j)==target){
                result.set(0,i);
                result.set(1,j);
                return result;
            }
            else if(arr.get(i)+arr.get(j) < target){
                i++;
            }
            //else if(arr.get(i)+arr.get(j) > target){ j-- }
            else{
                j--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);
        System.out.println(list);
        System.out.print("Brute Force"+" -> ");
        System.out.println(bruteForce(list, 5));
        System.out.print("2Pointer"+" -> ");
        System.out.println(twoPointer(list, 20));
    }
}
