import java.util.Scanner;

public class Boj11050 {
    
    public static int factorial(int num) {
        int a = 1;

        for(int i = 1; i <= num; i++) {
            a *= i;
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();

        sc.close();
        
        int bi = (factorial(n)) / (factorial(n - k) * factorial(k));
        
        System.out.println(bi);
    }

}
