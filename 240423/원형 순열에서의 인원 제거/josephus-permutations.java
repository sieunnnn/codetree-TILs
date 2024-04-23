import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }

        int cnt = 1;
        while(!queue.isEmpty()) {
            cnt++;
            int current = queue.poll();
            queue.add(current);
            
            if (cnt == K) {
                sb.append(queue.poll()).append(" ");
                cnt = 1; // 초기화
            }
        }

        System.out.println(sb.toString());
    }
}