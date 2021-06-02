import java.util.Scanner;

public class Boj1806_1 {

    static int N, S, ans, sum;
    static int[] data;
    static int s, e;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        data = new int[N + 1];
        for(int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }

        ans = Integer.MAX_VALUE;
        s = 0;
        e = 0;

        while(e <= N && s <= N) {
            if (sum >= S && ans > e - s) {
                ans = e - s;
            }

            if (sum < S) {
                sum += data[e++];
            } else {
                sum -= data[s++];
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
        sc.close();
    }

}
