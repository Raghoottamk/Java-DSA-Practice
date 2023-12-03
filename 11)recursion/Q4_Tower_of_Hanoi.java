/*
    --QUESTION--
Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and C) and N disks. Initially, all the disks are stacked in decreasing value of diameter i.e., the smallest disk is placed on the top and they are on rod A. The objective of the puzzle is to move the entire stack to another rod (here considered C), obeying the following simple rules: 
    *Only one disk can be moved at a time.
    *Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
    *No disk may be placed on top of a smaller disk.
*/
/*
    --IDEA--
The idea is to use the helper node to reach the destination using recursion. Below is the pattern for this problem:
    Shift ‘N-1’ disks from ‘A’ to ‘B’, using C.
    Shift last disk from ‘A’ to ‘C’.
    Shift ‘N-1’ disks from ‘B’ to ‘C’, using A. 

  --STEPS--
Follow the steps below to solve the problem:
    Create a function towerOfHanoi where pass the N (current number of disk), from_rod, to_rod, aux_rod.
    Make a function call for N – 1 th disk.
    Then print the current the disk along with from_rod and to_rod
    Again make a function call for N – 1 th disk.
*/
public class Q4_Tower_of_Hanoi {
    public static void towerOfHanoi(int n,char start,char auxillary,char target){
        //base
        if(n==1){
            System.out.println(start+" -> "+target);
            return;
        }
        towerOfHanoi(n-1,start,target,auxillary);
        towerOfHanoi(1, start, auxillary, target);
        towerOfHanoi(n-1, auxillary, start, target);
    }
    public static void main(String[] args) {
        towerOfHanoi(4,'A','B','C');
    }
}
