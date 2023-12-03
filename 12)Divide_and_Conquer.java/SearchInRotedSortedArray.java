public class SearchInRotedSortedArray {
    public static int search(int arr[],int target,int i, int j) {
        if(i>j) return -1;//target does not exist in the array
        int mid = i+(j-i)/2;
        //base case for binary search:
        if(arr[mid] == target) return mid;
        //target lies on line 1: 
        if(arr[i] < arr[mid]){
            //case a: lies left side of mid
            if(arr[i] <= target && target<= arr[mid]){
                return search(arr, target,i,mid);
            }
            //case b: lies right side of mid
            else{
                return search(arr,target,mid,j);
            }
        }
        //target lies on line 2
        else{
            //case a:right side of L2
            if(arr[mid] <= target && target <=arr[j]){
                return search(arr, target, mid, j);
            }
            else{//case b:left side of L2
                return search(arr, target, i,mid);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,0,1,2,3};
        System.out.println(search(arr, 2, 0, arr.length-1));
    }
}
