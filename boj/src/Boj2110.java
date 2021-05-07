import java.util.*;

public class Boj2110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[n - 1] - arr[0];
        int d = 0;
        int ans = 0;

        while(min <= max) {
            int mid = (min + max) / 2;
            int start = arr[0];
            int cnt = 1;

            for(int i = 0; i < n; i++) {
                d = arr[i] - start;

                if(d >= mid) {
                    cnt++;
                    start = arr[i];
                }
            }

            if(cnt >= c) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(ans);
        sc.close();
    }

}