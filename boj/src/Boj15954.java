import java.io.*;
import java.util.*;

public class Boj15954 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
 
        double ans = Double.MAX_VALUE;
        double ret = 0;
 
        for (int i = K; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                double m = mean(arr, j, i);
                ret = standard_Deviation(arr, m, j, i);
                ans = Math.min(ans, ret);
            }
        }
 
        bw.write(String.format("%.11f", ans) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static double mean(int[] arr, int start, int K) {
        double sum = 0.0;

        for (int i = 0; i < K; i++) {
            sum += arr[start + i];
        }

        return sum / K;
    }
    
    public static double standard_Deviation(int[] arr, double m, int start, int K) {
        double sum = 0.0;

        for (int i = 0; i < K; i++) {
            sum += Math.pow(arr[start + i] - m, 2);
        }

        return Math.sqrt(sum / K);
    }
    
}
