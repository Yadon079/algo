import java.io.*;

public class Boj11279_1 {
    
    public static int [] heap = new int[100001];
    public static int size = 0;
    public static StringBuilder sb = new StringBuilder();
 
    public static void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }
    
    public static void push(int x) {
        heap[++size] = x;
        
        for(int i = size; i > 1; i /= 2) {
            if(heap[i / 2] < heap[i]) {
                swap(i / 2, i);
            } else {
                break;
            }
        }
    }
 
    public static void pop() {
        sb.append(heap[1]+"\n");
        heap[1] = heap[size];
        heap[size--] = 0;
        
        for(int i = 1; i * 2 <= size; ) {
            if(heap[i] > heap[i * 2] && heap[i] > heap[i * 2 + 1]) {
                break;
            } else if(heap[i * 2] > heap[i * 2 + 1]) {
                swap(i, i * 2);
                i = i * 2;
            } else {
                swap(i, i * 2 + 1);
                i = i * 2 + 1;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if(k == 0) {
                if(size == 0) {
                    sb.append(0 + "\n");
                } else {
                    pop();
                }
            } else {
                push(k);
            }
        }
        
        System.out.print(sb.toString());
        
        br.close();
    }

}
