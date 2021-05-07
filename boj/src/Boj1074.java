import java.util.Scanner;

public class Boj1074 {
    
    static int n;
    static int r;
    static int c;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        count((int) Math.pow(2, n), 0, 0);

        sc.close();
    }

    static void count(int n, int y, int x) {
        if(x == c && y == r) {
            System.out.println(cnt);
            System.exit(0);
        }

        if(x <= c && c < (x + n) && y <= r && r < (y + n)) {
            int q = n / 2;
            count(q, y, x);
            count(q, y, x + q);
            count(q, y + q, x);
            count(q, y + q, x + q);
        } else {
            cnt += n * n;
        }
    }

}
