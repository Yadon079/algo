import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj10816 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // map에 해당 key가 존재하면 key의 value를 1증가, 없으면 map에 추가
        for(int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            
            if(map.containsKey(card)) {
                map.replace(card, map.get(card) + 1);
            } else {
                map.put(card, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // map에 존재하는 key면 value를 sb에 추가, 존재하지 않으면 0을 추가
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(map.containsKey(num)) {
                int cnt = map.get(num);

                sb.append(cnt);
                sb.append(" ");
            } else {
                sb.append(0);
                sb.append(" ");
            }
        }

        System.out.println(sb);

    }

    /*
    * 시간초과
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] card = new int[n];

        for(int i = 0; i < card.length; i++) {
            card[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] num = new int[m];

        for(int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        sc.close();
        Arrays.sort(card);

        int[] cnt = new int[m];

        for(int i = 0; i < num.length; i++) {
            for(int j = 0; j < card.length; j++) {
                if(num[i] == card[j]) {
                    cnt[i] += 1;
                }
            }
        }

        for(int i = 0; i < cnt.length; i++) {
            System.out.print(cnt[i] + " ");
        }
        

    }
    */

}
