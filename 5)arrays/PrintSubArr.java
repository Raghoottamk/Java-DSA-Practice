public class PrintSubArr {
    public static void subarr(int arr[]) {
        int totsubarr=0;
        for(int i=0;i<arr.length;i++){
            int start = i;//optional
            
            for(int j=0;j<arr.length;j++){
                int end=j;//optional
                for(int k=start;k<=end;k++){//for(int k=i;k<=j;k++)
                    System.out.print(arr[k]+" ");
                }
                totsubarr++;
                System.out.println();
            } 
            //System.out.println();
        }
        System.out.println(totsubarr);
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        subarr(arr);
    }
}
