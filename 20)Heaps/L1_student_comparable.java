import java.util.*;
class Student implements Comparable<Student>{
    String name;
    int rank;
    public Student(String name,int rank){
        this.name = name;
        this.rank = rank;
    }
    @Override
    public int compareTo(Student s2){
        return this.rank - s2.rank;
        //return this.name.compareTo(s2.name);//to compare names lexicographically
    }
}
public class L1_student_comparable {
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        PriorityQueue<Student> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("a", 2));
        pq.add(new Student("Z", 6));
        pq.add(new Student("c", 5));
        pq.add(new Student("x", 4));
        pq.add(new Student("y", 3));
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.poll();//pq.remove()
        }
        // System.out.println("reverse order");
        // pq1.add(new Student("a", 2));
        // pq1.add(new Student("Z", 6));
        // pq1.add(new Student("c", 5));
        // pq1.add(new Student("x", 4));
        // pq1.add(new Student("y", 3));
        // while(!pq1.isEmpty()){
        //     System.out.println(pq1.peek().name + "->" + pq1.peek().rank);
        //     pq1.poll();//pq.remove()
        // }
    }
}