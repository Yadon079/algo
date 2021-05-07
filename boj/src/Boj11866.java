import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11866 {

    /**
     * 덱을 활용한 코드
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1; i < n + 1; i++) {
            dq.add(i);
        }

        StringBuilder sb = new StringBuilder("<");

        while(!dq.isEmpty()) {
            for(int i = 0; i < k - 1; i++) {
                dq.addLast(dq.removeFirst());
            }

            sb.append(dq.removeFirst() + ", ");
        }

        System.out.println(sb.toString().substring(0, sb.length() - 2) + ">");

    }

    // 큐를 활용한 코드
    // public static void main(String[] args) throws IOException {   
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     Queue<Integer> que = new LinkedList<>();

    //     StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    //     int n = Integer.parseInt(st.nextToken());
    //     int k = Integer.parseInt(st.nextToken());

    //     for(int i = 1; i < n + 1; i++) {
    //         que.offer(i);
    //     }

    //     StringBuilder sb = new StringBuilder("<");

    //     while(!que.isEmpty()) {
    //         for(int i = 1; i < k + 1; i++) {
    //             if(i != k) {
    //                 que.offer(que.poll());
    //             } else {
    //                 sb.append(que.poll());
    //                 sb.append(", ");
    //             }
    //         }
    //     }

    //     System.out.println(sb.toString().substring(0, sb.length() - 2) + ">");
    // }
    
}
