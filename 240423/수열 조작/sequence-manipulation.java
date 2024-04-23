import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }
        
        while(deque.size() != 1) {
            deque.pollFirst();
            int temp = deque.pollFirst();
            deque.addLast(temp);
        }

        System.out.println(deque.pollFirst());
    }
}