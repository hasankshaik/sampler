import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DuplicateInString {
    public static void main(String[] args) {

    }

    public void findDuplicate(String s) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        Stream.of(s.toCharArray()).forEach(c -> {
            if (stringIntegerMap.containsKey(c)) {
                stringIntegerMap.put(c.toString(), stringIntegerMap.get(c) + 1);
            } else {
                stringIntegerMap.put(c.toString(), 1);
            }
        });

    }
}
