import java.util.*;

public class stquestockprice {

  public int[] solution1(int[] prices) {
    int len = prices.length;
    int[] answer = new int[len];
    int i, j;

    for (i = 0; i < len; i++) {
      for (j = i + 1; j < len; j++) {
        answer[i]++;

        if (prices[i] > prices[j])
          break;
      }
    }

    return answer;
  }

  public int[] solution2(int[] prices) {
    int[] ans = new int[prices.length];
    Stack<Integer> stack = new Stack();

    for (int i = 0; i < prices.length; i++) {
      while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
        ans[stack.peek()] = i - stack.peek();
        stack.pop();
      }
      
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      ans[stack.peek()] = prices.length - stack.peek() - 1;
      stack.pop();
    }

    return ans;
  }
}
