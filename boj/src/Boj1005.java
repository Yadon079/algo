import java.util.*;

public class Boj1005 {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n, k, w, t = sc.nextInt();
		int[] time, result, indegree;
		
		while(t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			
			time = new int[n + 1];
			indegree = new int[n + 1];
			result = new int[n + 1];
			
			for(int i = 1; i < time.length; i++) {
                time[i] = sc.nextInt();
            }
			
			LinkedList<Integer>[] link = new LinkedList[n+1];

            for(int i = 1; i < n + 1; i++) {
                link[i] = new LinkedList<>();
            }
            
			for(int i = 0; i < k; i++) {
				int from = sc.nextInt();
                int to = sc.nextInt();
				
				link[from].add(to);
				indegree[to]++;
			}
			
			w = sc.nextInt();
			
			Queue<Integer> queue = new LinkedList<>();

			for(int i = 1; i < n + 1; i++) {
				if(indegree[i] == 0) {
					queue.add(i);
					result[i] = time[i];
				}
			}
			
			while(!queue.isEmpty()) {
				int from = queue.poll();

				for(int to : link[from]) {
					result[to] = Math.max(result[to], result[from] + time[to]);
					
					if(--indegree[to] == 0) {
                        queue.add(to);
                    }
				}
			}

			System.out.println(result[w]);
		}

        sc.close();
	}

}
