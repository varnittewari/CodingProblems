import java.util.LinkedList;

public class twitter16{

    static LinkedList<Integer> lis = new LinkedList<Integer>();
    public static void main (String[] args){
        record(4);
        record(1);
        record(8);
        record(6);
        System.out.println(getLast(3));
        record(10);
        System.out.println(getLast(5));
        record(7);
        System.out.println(getLast(1));
    }
    
    public static void record(int recId){
        lis.add(recId);
    }

    public static int getLast(int i){
        return lis.get(lis.size()-i);
    }
}