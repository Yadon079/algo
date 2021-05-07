import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int T = 2147000000;
        int H = -1;

        int[][] map = new int[n][m];
        int max = -1;
        int min = T;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;

                if(now > max) max = now;
                if(now < min) min = now;
            }
        }

        for(int i = max; i >= min; i--) {
            int t = 0;
            int bag = b;
            int target = i;
            boolean isCompute = true;

            for(int y = 0; y < n; y++) {
                for(int x = 0; x < m; x++) {
                    if(map[y][x] == target) continue;
                    else {
                        int diff = Math.abs(target - map[y][x]);

                        if(target > map[y][x]) {
                            bag -= diff;
                            t += diff;
                        } else {
                            bag += diff;
                            t += (diff * 2);
                        }
                    }
                }
            }

            if(bag < 0) continue;

            if(isCompute && t < T) {
                T = t;
                H = target;
            }
        }

        System.out.println(T + " " + H);

        br.close();
    }
}