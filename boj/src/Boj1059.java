import java.util.*;

public class Boj1059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int n = sc.nextInt();

        sc.close();

        // 집합 s에 포함된 모든 정수는 1보다 크고 1000보다 작다.
        int start = 1;
        int end = 1000;
        int cnt = 0;

        //  for(int i = 0; i < arr.length; i++)
        for (int i : arr) {
            if (i < n) {
                start = i + 1;
            } else {
                end = Math.min(end, i);
            }
        }

        /**
         * 다른 곳에서 변수가 초기화 되었을 경우
         * 초기화 식 생략 가능
         */
        for(; start <= n; start++) {
            for(int i = Math.max(start + 1, n); i < end; i++) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
