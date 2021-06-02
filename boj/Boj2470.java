import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj2470 {
    
    static int n;
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        int min = arr.get(0) + arr.get(arr.size() - 1);

        int s = 0;
        int e = arr.size() - 1;

        int minI = s;
        int maxI = e;

        while(s < e) {
            int sum = arr.get(s) + arr.get(e);

            if(Math.abs(sum) < Math.abs(min)) {
                minI = s;
                maxI = e;
                min = sum;
            }

            if(sum < 0) {
                s++;
            } else {
                e--;
            }
        }

        System.out.println(arr.get(minI) + " " + arr.get(maxI));

        br.close();
    }

}
