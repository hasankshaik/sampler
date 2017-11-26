import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber {
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        int[] ints={1,2,3,5,2,4,1,7,9,5};
//        Arrays.stream(ints).distinct().forEach(System.out::print);
        Arrays.stream(ints).filter(s-> set.add(s)==false).forEach(System.out::print);

    }
}
