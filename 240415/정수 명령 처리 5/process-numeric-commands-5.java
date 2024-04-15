import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> numbers = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_back")) {
                int number = Integer.parseInt(st.nextToken());
                numbers.add(number);

            } else if (command.equals("pop_back")) {
                numbers.remove(numbers.size() - 1);

            } else if (command.equals("size")) {
                sb.append(numbers.size()).append("\n");

            } else if (command.equals("get")) {
                int number = Integer.parseInt(st.nextToken());
                sb.append(numbers.get(number - 1)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}