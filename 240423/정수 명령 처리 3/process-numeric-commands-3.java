import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
        
            } else if (command.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            
            } else if (command.equals("pop_front")) {
                sb.append(deque.pollFirst()).append("\n");
            
            } else if (command.equals("pop_back")) {
                sb.append(deque.pollLast()).append("\n");
            
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");

            } else if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }

            } else if (command.equals("front")) {
                sb.append(deque.peekFirst()).append("\n");
            
            } else if (command.equals("back")) {
                sb.append(deque.peekLast()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}