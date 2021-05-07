import java.io.*;
import java.util.*;

public class Boj12015_1 {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> list = new ArrayList<>();
        list.add(0);
       
    	for(int i = 0; i < n; i++) {
        	int value = Integer.parseInt(st.nextToken());	
            
        	if(value > list.get(list.size() - 1)) {
                list.add( value );
            } else {				
            	int left = 0; 
            	int right = list.size() - 1;
                
            	while(left < right) {
                	int mid = (left + right) / 2;
                    
                	if(value <= list.get(mid)) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
            	}
                
            	list.set(right, value);
        	}
    	}

    	System.out.println(list.size() - 1);
        
        br.close();
	}
    
}
