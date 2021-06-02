import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1920 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arrn = new int[n];

        for(int i = 0; i < arrn.length; i++) {
            arrn[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());

        int[] arrm = new int[m];

        for(int i = 0; i < arrm.length; i++) {
            arrm[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < arrm.length; i++) {
            
            int cnt = 0;
            for(int j = 0; j < arrn.length; j++) {
                
                if(arrm[i] == arrn[j]) {
                    cnt++;
                    break;
                }
            }

            System.out.println(cnt);
        }
    }
}