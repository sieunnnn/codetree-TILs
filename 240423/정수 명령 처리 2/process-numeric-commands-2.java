import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            
            } else if (command.equals("pop")) {
                sb.append(queue.poll()).append("\n");
            
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");

            } else if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }

            } else if (command.equals("front")) {
                sb.append(queue.peek()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}