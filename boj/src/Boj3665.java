import java.io.*;
import java.util.*;

public class Boj3665 {
    
    static final int NONE = 0;
    static final int IMPOSSIBLE = 1;
    static final int NOT_DETERMINED = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] indegree = new int[n + 1];
            int[][] graph = new int[n + 1][n + 1];
            int[] t = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++) {
                t[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    graph[t[i]][t[j]] = 1;
                    indegree[t[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(graph[a][b] == 1) {
                    graph[a][b] = 0;
                    graph[b][a] = 1;
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    graph[b][a] = 0;
                    graph[a][b] = 1;
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            int[] rankings = new int[n];

            for(int i = 1; i <= n; i++) {
                if(indegree[i] == 0) {
                    queue.add(i);
                }
            }

            int ans = NONE;

            for(int i = 0; i < n; i++) {
                if(queue.isEmpty()) {
                    ans = IMPOSSIBLE;
                    break;
                }

                if(queue.size() > 1) {
                    ans = NOT_DETERMINED;
                    break;
                }

                int u = queue.poll();
                rankings[i] = u;

                for(int j = 1; j < n + 1; j++) {
                    if(graph[u][j] == 1) {
                        indegree[j]--;

                        if(indegree[j] == 0) {
                            queue.add(j);
                        }

                    }
                }
            }

            if(ans == NONE) {
                for(int x : rankings) {
                    bw.write(x + " ");
                }

                bw.write("\n");
            } else if(ans == IMPOSSIBLE) {
                bw.write("IMPOSSIBLE\n");
            } else if(ans == NOT_DETERMINED) {
                bw.write("?\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
