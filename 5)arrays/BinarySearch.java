public class BinarySearch {
    public static int binarysearch(int arr[],int key) {
        int start=0, end = (arr.length)-1;
        int count =0;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){
                return mid;
                //System.out.println("the key is at index:"+mid);
            }
            if(arr[mid]<key){
                start=mid+1;
            }
            else {
                //if(arr[mid]>key)
                end=mid-1;   
            }
            count+=1;
        }
        //System.out.println("no of time loop ran in binary search is:"+count);
        return -1; 
    }
    public static int linearsearch(int arr[], int key) {
        int count=0;
        for(int i =0;i<=arr.length;i++){
            if(arr[i]==key){
                return i;
                //System.out.println("the key is in index:"+i);
            }
            count+=1; 
        }
        System.out.println("no of time loop ran in linear search is:"+count);
        return -1;
    }
    public static void main(String[] args) {
        
        int arr[]={2,6,7,10,12,13,14,16,18,20};
        int key = 10;
        System.out.println("binary search");
        System.out.println("key is at index:"+binarysearch(arr,key));
        binarysearch(arr,key);
        System.out.println();
        System.out.println("linear search");
        System.out.println("key is at index:"+linearsearch(arr,key));
        //linearsearch(arr,key);
    }
}
