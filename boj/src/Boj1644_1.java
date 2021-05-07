import java.util.*;
import java.io.*;

public class Boj1644_1 {

    static int n;
    static boolean prime[];
    static ArrayList<Integer>prime_list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prime = new boolean[n+1];

        isPrime();

        for(int i = 2; i <= n; i++) {
            if(!prime[i]) {
                prime_list.add(i);
            }
        } 
        
        int start =0,end=0,sum=0,cnt=0;
        while(true) {
            if(sum == n) {
                cnt++;
                sum -= prime_list.get(start);
                start++;
            } else if(sum > n) {
                sum -= prime_list.get(start);
                start++;
            } else if(end == prime_list.size()) {
                break;
            } else {
                sum += prime_list.get(end);
                end++;
            }
        }

        System.out.println(cnt);
    }
    
    public static void isPrime() {
        for(int i = 2; i <= n;i++) {
            for(int j = i * 2; j <= n; j += i) {
                prime[j] = true;
            }
        }
    }
    
}
