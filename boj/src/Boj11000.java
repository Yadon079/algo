import java.io.*;
import java.util.*;

public class Boj11000 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(times, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int start = times[i][0];
            int end = times[i][1];
            
            if (!que.isEmpty() && que.peek() <= start) {
                que.poll();
            }

            que.offer(end);
        }

        System.out.println(que.size());
        
        br.close();
    }

}
