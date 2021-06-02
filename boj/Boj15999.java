import java.io.*;
import java.util.*;

public class Boj15999 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int div = 1000000007;
        char[][] map = new char[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }

        int cnt = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i + 1 < n && map[i][j] != map[i + 1][j]) {
                    continue;
                }

                if(i - 1 >= 0 && map[i][j] != map[i - 1][j]) {
                    continue;
                }

                if(j + 1 < m && map[i][j] != map[i][j + 1]) {
                    continue;
                }

                if(j - 1 >= 0 && map[i][j] != map[i][j - 1]) {
                    continue;
                }

                cnt = (cnt * 2) % div;
            }
        }

        System.out.println(cnt);
        br.close();
    }

}
