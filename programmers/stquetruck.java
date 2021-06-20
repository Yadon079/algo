import java.util.*;
import java.io.*;

public class stquetruck {
  
  public int solution1(int bridge_length, int weight, int[] truck_weights) {

    int answer = 0;
    Queue<Integer> que = new LinkedList<>();

    int max = 0;

    for(int w : truck_weights) {

      while(true) {
        if(que.isEmpty()) {
          que.offer(w);
          max += w;
          answer++;
          break;
        } else if(que.size() == bridge_length) {
          max -= que.poll();
        } else {
          if(max + w > weight) {
            que.offer(0);
            answer++;
          } else {
            que.offer(w);
            max += w;
            answer++;
            break;
          }
        }
      }
    }

    return answer + bridge_length;
  }

  public int solution2(int bridge_length, int weight, int[] truck_weights) {
    Queue<Truck_solution2> waitQ = new LinkedList<>();
    Queue<Truck_solution2> moveQ = new LinkedList<>();

    for (int t : truck_weights) {
      waitQ.offer(new Truck_solution2(t));
    }

    int answer = 0;
    int curWeight = 0;

    while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
      answer++;

      if (moveQ.isEmpty()) {
        Truck_solution2 t = waitQ.poll();
        curWeight += t.weight;
        moveQ.offer(t);
        continue;
      }

      for (Truck_solution2 t : moveQ) {
        t.moving();
      }

      if (moveQ.peek().move > bridge_length) {
        Truck_solution2 t = moveQ.poll();
        curWeight -= t.weight;
      }

      if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
        Truck_solution2 t = waitQ.poll();
        curWeight += t.weight;
        moveQ.offer(t);
      }
    }

    return answer;
  }

  class Truck_solution2 {
    int weight;
    int move;

    public Truck_solution2(int weight) {
        this.weight = weight;
        this.move = 1;
    }

    public void moving() {
        move++;
    }
  }
}