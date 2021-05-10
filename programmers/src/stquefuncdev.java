import java.util.*;

public class stquefuncdev {
    
    // Stack
    public int [] solution1(int[] progresses, int[] speeds) {
        int[] answer = {};

        Stack<Integer> st = new Stack<Integer>();

	    for(int i = progresses.length - 1; i >= 0; i--) {
            st.add((100 - progresses[i]) / speeds[i] 
                + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));    
        }
		
	    List<Integer> s = new ArrayList<Integer>();

	    while(!st.isEmpty()) {
		    int cnt = 1;
		    int top = st.pop();

		    while(!st.isEmpty() && st.peek() <= top) {
			    cnt++;
			    st.pop();
		    }

		    s.add(cnt);
	    }

	    answer = new int[s.size()];

	    for(int i = 0; i < answer.length; i++) {
		    answer[i] = s.get(i);
	    }

        return answer;
    }

    // Queue
    public int [] solution2(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> que = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            que.add((100 - progresses[i]) / speeds[i] 
                + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0));    
        }
   
        List<Integer> s = new ArrayList<Integer>();

        while(!que.isEmpty()) {
            int cnt = 1;
            int num = que.poll();

            while(!que.isEmpty() && que.peek() <= num) {
                cnt++;
                que.poll();
            }

            s.add(cnt);
        }

        answer = new int[s.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = s.get(i);
        }

        return answer;
    }

    // Non-Stack & Non-Queue
    public int[] solution3(int[] progresses, int[] speeds) {
        int[] end = new int[100];
        int day = -1;

        for(int i = 0; i < progresses.length; i++) {
            while(progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }

            end[day]++;
        }
        
        return Arrays.stream(end).filter(i -> i != 0).toArray();
    }

}
