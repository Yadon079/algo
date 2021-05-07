import java.util.LinkedList;
import java.util.Scanner;

public class Boj1966 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int tc = sc.nextInt();

        for(int t = 0; t < tc; t++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            
            LinkedList<int[]> q = new LinkedList<>();
            
            // 초기위치, 중요도
            for(int i = 0; i < n; i++) {
                q.offer(new int[] { i, sc.nextInt() });
            }

            int cnt = 0;

            // 하나의 케이스에 대한 반복문
            while(!q.isEmpty()) {

                int[] front = q.poll(); // 첫 원소
                boolean isMax = true;   // front가 가장 큰 원소인가?

                // 남은 원소들과 중요도 비교
                for(int i = 0; i < q.size(); i++) {

                    if(front[1] < q.get(i)[1]) {

                        q.offer(front);

                        for(int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(isMax == false) {
                    continue;
                }

                cnt++;

                if(front[0] == m) {
                    break;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
        sc.close();
    }

}
