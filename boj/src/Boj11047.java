import java.io.*;
import java.util.*;

public class Boj11047 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];

        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        greedy(n, k, coin);

        br.close();
    }

    private static void greedy(int n, int k, int[] coin) {
        int cnt = 0;

        for(int i = n - 1; i >= 0; i--) {
            if(k == 0) {
                break;
            } else if(k / coin[i] != 0) {
                cnt += k / coin[i];
                k %= coin[i];
            }
        }

        System.out.println(cnt);
    }

}
