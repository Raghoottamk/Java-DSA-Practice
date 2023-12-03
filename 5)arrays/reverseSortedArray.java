public class reverseSortedArray {
    public static void reverse(int arr[]) {
        int start=0,end=arr.length-1;
        while(start<end){
            //classic swap method
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            end--;
            start++;
        }
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10,12};
        reverse(arr);
        //printing the reverse array
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }

    }
}
