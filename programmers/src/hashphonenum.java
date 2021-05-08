import java.util.*;

public class hashphonenum {
    
    // HashMap
    public boolean solution1(String[] phone_book) {
        boolean answer = true;

        HashMap<String, String> hm = new HashMap<>();
		
        // 중복제거
		for(String input : phone_book) {
			hm.put(input, input);
		}
		
		for(String target : phone_book) {
			// target을 분해하며 다른 곳에서 prefix 있는지 찾기 
			for(int i = 0; i < target.length(); i++) {

				if(hm.containsKey(target.substring(0, i))) {
					return false;
				} else if(hm.get(target.substring(0, i)) != null) {
					return false;
				}

			}
			
		}

        return answer;
    }


    // non-Hash
    public boolean solution2(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
    
}
