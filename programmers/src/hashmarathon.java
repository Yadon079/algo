import java.util.*;

public class hashmarathon {

    // non hash
    public String solution1(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;

        for(i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        return participant[i];
    }

    // hash
    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hMap = new HashMap<>();

        for(String player : participant) {
            hMap.put(player, hMap.getOrDefault(player, 0) + 1);
        }

        for(String player : completion) {
            hMap.put(player, hMap.get(player) - 1);
        }

        for(String key : hMap.keySet()) {
            if(hMap.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }

}
