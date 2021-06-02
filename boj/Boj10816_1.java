import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10816_1 {
    
    static int card[];

    // 배열 card에서 num이 처음으로 나타나는 인덱스
    public static int lower_bound(int num) {
        int start = 0;
        int end = card.length - 1;
        int mid;

        while(start < end) {
            mid = (start + end) / 2;
            
            if(card[mid] >= num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    // 배열 card에서 num보다 큰 값이 처음으로 나타나는 인덱스
    public static int upper_bound(int num) {
        int start = 0;
        int end = card.length - 1;
        int mid;

        while(start < end) {
            mid = (start + end) / 2;

            if(card[mid] > num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // 상한값이 배열보다 클 때
        if(card[end] == num) {
            end++;
        }

        return end;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        card = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int low = lower_bound(num);
            int up = upper_bound(num);

            bw.append((up - low) + " ");
        }

        bw.flush();
        bw.close();
    }

}
