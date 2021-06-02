import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1260 {

    static ArrayList<Integer>[] list;
    static int n, m, v;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        list = new ArrayList[n + 1];

        for(int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i < n + 1; i++) {
            Collections.sort(list[i]);
        }

        check = new boolean[n + 1];
        dfs(v);
        System.out.println();

        check = new boolean[n + 1];
        bfs(v);
        System.out.println();

        sc.close();
    }

    private static void dfs(int num) {
        if(check[num]) {
            return;
        }

        check[num] = true;
        System.out.print(num + " ");

        for (int i : list[num]) {
            if(!check[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int num) {
        Queue<Integer> que = new LinkedList<>();
        que.add(num);
        
        check[num] = true;

        while(!que.isEmpty()) {
            int x = que.poll();
            System.out.print(x + " ");

            for (int i : list[x]) {
                if(!check[i]) {
                    check[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
