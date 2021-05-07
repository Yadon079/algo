import java.io.*;
import java.util.*;

public class Boj1450 {
    
    static int n, c, index;
    static int[] arr;
    static ArrayList<Integer> aSum, bSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        aSum = new ArrayList<>();
        bSum = new ArrayList<>();

        aBrute(0, 0);
        bBrute(n / 2, 0);

        Collections.sort(bSum);
        int ans = 0;

        for(int i = 0; i < aSum.size(); i++) {
            index = -1;
            binary(0, bSum.size() - 1, aSum.get(i));
            ans += index + 1;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    static void aBrute(int i, int sum) {
        if(sum > c) {
            return;
        }

        if(i == n / 2) {
            aSum.add(sum);
            return;
        }

        aBrute(i + 1, sum + arr[i]);
        aBrute(i + 1, sum);
    }

    static void bBrute(int i, int sum) {
        if(sum > c) {
            return;
        }

        if(i == n) {
            bSum.add(sum);
            return;
        }

        bBrute(i + 1, sum + arr[i]);
        bBrute(i + 1, sum);
    }

    static void binary(int start, int end, int val) {
        if(start > end) {
            return;
        }

        int mid = (start + end) / 2;

        if(bSum.get(mid) + val <= c) {
            index = mid;
            binary(mid + 1, end, val);
        } else {
            binary(start, mid - 1, val);
        }
    }

}
