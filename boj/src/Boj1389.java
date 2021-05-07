import java.io.*;
import java.util.*;

public class Boj1389 {
    
    static int n, m;
    static int ad[][];
    static boolean visit[];
    static int count[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        ad = new int[n + 1][n + 1];
        int sum[] = new int[n + 1];
        count = new int[n + 1][n + 1];
        int indexValue = Integer.MAX_VALUE;
        int index = 0;
 
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            ad[s1][s2] = ad[s2][s1] = 1;
        }
 
        for(int i = 1; i <= n; i++) {
            visit = new boolean[n+1];
            bfs(i);
        }
 
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i] += count[i][j];
            }
        }
 
        for(int i = 1; i <= n; i++) {
            if(sum[i] < indexValue) {
                indexValue = sum[i];
                index = i;
            }
        }
 
        System.out.print(index);
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        visit[start] = true;

        while(!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 1; i <= n; i++) {
                if (!visit[i] && ad[cur][i] == 1) {
                    que.offer(i);
                    visit[i] = true;
                    count[start][i] = count[start][cur] + 1;
                }
            }

        }
    }

}
