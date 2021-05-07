import java.io.*;
import java.util.*;

public class Boj15998 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
 
        long a, b;
        long minB = (long) 10e18;
        long balance = 0;

        boolean valid = true;
        long M = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
 
            if (balance + a < 0) {
                long temp = b - a - balance;

                if (b != 0 && b < minB) {
                    minB = b;
                }
 
                if (M == 0) {
                    M = temp;
                } else {
                    M = GCD(M, temp);

                    if (M <= minB && minB != (long) 10e18) {
                        valid = false;
                        break;
                    }
                }

            } else {
                if (balance + a != b) {
                    valid = false;
                    break;
                }
            }

            balance = b;
        }
 
        if (valid && M != 0) {
            bw.write(M + "\n");
        } else if (valid && M == 0) {
            bw.write("1\n");
        } else {
            bw.write("-1\n");
        }
 
        bw.flush();
        bw.close();
        br.close();
    }
 
    public static long GCD(long a, long b) {
        while (b > 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }

        return a;
    }
    
}
