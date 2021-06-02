import java.util.Scanner;

public class Boj1107 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] broken = new boolean[10];
        for(int i = 0; i < m; i++) {
            int button = sc.nextInt();
            broken[button] = true;
        }

        int count = Math.abs(n - 100);
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak) {
                int min = Math.abs(n - i) + len;
                count = Math.min(min, count);
            }
        }

        System.out.println(count);

        sc.close();
    }

}
