import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static LinkedList<Integer> numbers = new LinkedList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if(command.equals("push_front")) {
                int value = Integer.parseInt(st.nextToken());
                numbers.addFirst(value);

            } else if(command.equals("push_back")) {
                int value = Integer.parseInt(st.nextToken());
                numbers.addLast(value);
            
            } else if(command.equals("pop_front")) {
                System.out.println(numbers.pollFirst());
            
            } else if(command.equals("pop_back")) {
                System.out.println(numbers.pollLast());
            
            } else if(command.equals("size")) {
                System.out.println(numbers.size());
            
            } else if(command.equals("empty")) {
                int answer = numbers.isEmpty() ? 1 : 0;
                System.out.println(answer);
            
            } else if(command.equals("front")) {
                System.out.println(numbers.peekFirst());
            
            } else if(command.equals("back")) {
                System.out.println(numbers.peekLast());
            }
        }
    }
}