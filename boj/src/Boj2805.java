import java.util.Arrays;
import java.util.Scanner;

public class Boj2805 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
        Arrays.sort(arr);
        
        long max = arr[n - 1];
        long min = 1;
        long mid = 0;

        while(max >= min) {

            mid = (max + min) / 2;

            long sum = 0;

            for(int tree : arr) {

                if(tree > mid) {
                    sum += tree - mid;
                }

            }

            if(sum >= m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(max);

    }

}
