import java.io.*;
import java.util.*;

public class Boj15953 {
    
    static int T;
    static int[] c2017 = {500, 300, 200, 50, 30, 10};
    static int[] c2018 = {512, 256, 128, 64, 32};
    static int[] n2017 = {1, 2, 3, 4, 5, 6};
    static int[] n2018 = {1, 2, 4, 8, 16};
    static int a, b;
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            int money = 0;
            int temp = 0;
            
            if (a != 0) {
                for (int i = 0; i < 6; i++) {
                    if (temp + n2017[i] >= a) {
                        money += c2017[i];
                        break;
                    }

                    temp += n2017[i];
                }    
            }
            
            temp = 0;
            
            if(b != 0) {
                for (int i = 0; i < 5; i++) {
                    if (temp + n2018[i] >= b) {
                        money += c2018[i];
                        break;
                    }
                    
                    temp += n2018[i];
                }    
            }

            System.out.println(money * 10000);
        }

        br.close();
    }

}
