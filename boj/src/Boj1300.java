import java.io.*;

public class Boj1300 {
    
	static long N, K, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		K = Long.parseLong(br.readLine());

		long left = 1;
		long right = K;

		System.out.println(biSearch(left, right));

        br.close();
	}

	static long biSearch(long left, long right) {
		int cnt = 0;
		long mid = (left + right) / 2;
        
		if(left > right) {
            return result;
        }
        
		for(int i = 1; i <= N; i++) {
			cnt += Math.min(mid / i, N);
		}

		if(K <= cnt) {
			result = mid;
			return biSearch(left, mid - 1);
		} else {
			return biSearch(mid + 1, right);
		}
	}
    
}