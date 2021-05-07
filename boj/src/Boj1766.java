import java.util.*;

public class Boj1766 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] indegree = new int[N + 1];

        ArrayList<Integer>[] list = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            indegree[y]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int current = q.poll();
            System.out.print(current + " ");
            
            for(int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                indegree[next]--;
                
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }

        sc.close();
    }

}
