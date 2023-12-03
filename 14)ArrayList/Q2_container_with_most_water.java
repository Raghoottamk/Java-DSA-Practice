import java.util.ArrayList;

public class Q2_container_with_most_water{
    public static int bruteForce(ArrayList<Integer> arr){
        int maxWater = Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.size();j++){
                int height = Math.min(arr.get(i),arr.get(j));
                maxWater = Math.max(maxWater,(j-i)*(height));
            }
        }
        return maxWater;
    }
    public static int twoPointer(ArrayList<Integer> arr){
        int i=0,j=arr.size()-1;
        int maxWater = Integer.MIN_VALUE;
        while(i<=j){
            int height = Math.min(arr.get(i),arr.get(j));
            maxWater = Math.max(maxWater,(j-i)*(height));
            if(arr.get(i)<arr.get(j)){
                i++;
            }
            else{
                j--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(8);list.add(6);list.add(2);list.add(5);list.add(4);list.add(8);list.add(3);list.add(7);
        System.out.println(bruteForce(list));
        System.out.println("2 pointer");
        System.out.println(twoPointer(list));
    }
}