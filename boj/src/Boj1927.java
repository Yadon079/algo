import java.io.*;
import java.util.*;

public class Boj1927 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> que = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int val = 0;

        for(int i = 0; i < n; i++) {
            val = Integer.parseInt(br.readLine());

            if(val != 0) {
                que.add(val);
            } else if(que.isEmpty()) {
                bw.write("0\n");
            } else {
                bw.write(que.poll() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
