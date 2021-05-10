import java.util.*;
import static java.util.stream.Collectors.*;

class hashspy {

    // HashMap
    public int solution1(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 1) + 1);
        }

        for(int i : hm.values()) {
            answer *= i;
        }

        return answer-1;
    }

    // Stream
    public int solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }

}