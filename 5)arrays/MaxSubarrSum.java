public class MaxSubarrSum {
    public static void sumsubarr(int arr[]) {
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){

            for(int j=i;j<arr.length;j++){
                currsum=0;
                for(int k=i;k<=j;k++){//for(int k=i;k<=j;k++)
                    System.out.print(arr[k]+" ");        
                    currsum+=arr[k];

                }
                System.out.println("sum of currentsum is: " +currsum);
                if(maxsum<currsum){
                    maxsum=currsum;
                }
            } 
        }System.out.println("maximum sum of subarray is"+maxsum);

    }
    public static void prefix(int arr[]){
        int maxsum=Integer.MIN_VALUE;
        int currsum=0;
        int prefix[]= new int[arr.length];
        prefix[0]=arr[0];//first element of the summed array
        System.out.print("prefix array\t");
        System.out.print(prefix[0]+" ");
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];//recursive formula
            System.out.print(prefix[i]+" "); 
        }
        for(int i=0;i<arr.length;i++){
            int start =i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                currsum=start==0?prefix[end] : prefix[end]-prefix[start-1];
                if(maxsum<currsum){
                    maxsum=currsum;
                }
                
            } 
        }
        System.out.println();
        System.out.println("maximum sum of subarray(prefix method) is"+maxsum);
    }
    public static void kadanes_algo(int arr[]) {
        int maxsum= Integer.MIN_VALUE;
        int currentsum=0;
        boolean bool=false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //Loop through the array  
        for (int i = 0; i < arr.length; i++) {    
            if(arr[i] <min){  
               min = arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }
        if(max>0){
            bool = true;
        }
        if(bool==true){
            for(int i=0;i<arr.length;i++){
                currentsum+=arr[i];
                if(currentsum<0){
                    currentsum=0;
                }
                maxsum=Math.max(currentsum,maxsum);//this line simply means if(currentsusm>maxsum){maxsum=currsum;}
            }
            System.out.println("maxsum of subarray using kadanes algorithm is: "+maxsum);
        }
        else{
            System.out.println("maxsum of subarray using kadanes algorithm is: "+max);
        }
        
    }
    public static void main(String[] args) {
        int arr[]={-1,-2,-3,-4};
        //method 1
        System.out.println("Brute Force method:");
        sumsubarr(arr);
        System.out.print("\n\n");
        //method 2
        System.out.println("prefix method:");
        prefix(arr);
        System.out.print("\n\n");
        //method 3
        System.out.println("kadane's algorithm");
        kadanes_algo(arr);
        System.out.print("\n\n");
    }
}
