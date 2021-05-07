import java.util.Arrays;
import java.util.Scanner;

public class Boj1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[k];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
        Arrays.sort(arr);

        long max = arr[k - 1]; // 제일 긴 랜선
        long min = 1; // 랜선 길이는 자연수
        long mid = 0;

        while(max >= min) {
            mid = (max + min) / 2;

            long cnt = 0;

            for(int i = 0; i < arr.length; i++) {
                cnt += arr[i] / mid;
            }

            if(cnt >= n) {
                min = mid + 1;
            } else if(cnt < n) {
                max = mid - 1;
            }
        }

        System.out.println(max);
    }
}
