import java.util.*;
public class matrix {
    
    public static void main(String[] args) {
        //declaring the size and type of 2D matrix
        int matrix[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        int n = matrix.length;//no. of rows
        int m = matrix[0].length;//no.of columns
        //to take input for each element of matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt(); 
            }
        }
        //output
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println(matrix[i][j]+" ");
            }
            System.out.println();
        }
        /*boolean matrix1
        to search for the key using nested for loops*/
        boolean result = matrix1(matrix,5);
        System.out.println(result);
    }
    /*boolean matrix1
    to search for the key using nested for loops*/
    public static boolean matrix1(int arr[][],int key) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(key==arr[i][j]){
                    System.out.println(arr[i][j]+" is the index of the required key");
                    return true;
                }
            }
        }
        System.out.println("key not found this 2D array");
        return false;
    }
}