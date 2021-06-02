import java.util.*;

public class stqueprinter {
    
    // Stack
    public int solution1(int[] priorities, int location) {
        int answer = 0;

        return answer;
    }

    // Queue
    public int solution2(int[] priorities, int location) {
        int answer = 0;
        int l = location;
        int size = priorities.length - 1;

        Queue<Integer> que = new LinkedList<Integer>();

        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        
        while(!que.isEmpty()) {
            int i = que.poll();

            if(i == priorities[size - answer]) {
                answer++;
                l--;

                if(l < 0) {
                    break;
                }
            } else {
                que.add(i);
                l--;

                if(l < 0) {
                    l = que.size() - 1;
                }
            }
        }

        return answer;
    }

    // Priority Queue
    public int solution3(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue priority = new PriorityQueue<>(Collections.reverseOrder());

        for(int task : priorities){
            priority.add(task);
            System.out.println(priority);
        }

        System.out.println(priority);

        while(!priority.isEmpty()){
            for(int i = 0; i < priorities.length; i++) {
                if(priorities[i] == (int)priority.peek()) {
                    if(i == location) {
                        return answer;
                    }

                    priority.poll();
                    answer++;
                }
            }
        }

        return answer;
    }

}
