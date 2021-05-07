import java.util.Scanner;

public class Boj2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();

        int gcd = getGCD(Math.max(a, b), Math.min(a, b));
        int lcm = getLCM(a, b, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    /**
     * 유클리드 호제법을 이용한 최대 공약수
     * 1. 입력받은 두 수 중 큰 수를 a, 작은 수를 b라고 한다.
     * 2. a를 b로 나눈 값의 나머지를 tmp에 저장한다.
     * 3. tmp가 0이라면 최대 공약수는 b가 된다.
     * 4. tmp가 0이 아니라면 a 값은 b가 되고 b 값은 tmp가 된다.
     * 5. 위 과정을 반복한다.
     */
    public static int getGCD(int a, int b) {
        while(b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    // 최대 공약수를 이용한 최소 공배수
    public static int getLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
