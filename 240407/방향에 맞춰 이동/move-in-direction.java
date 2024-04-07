import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dx = {-1, 1, 0, 0}; // 좌 우 위 아래
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int x = 0;
    static int y = 0;
      
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String direction = st.nextToken();
            int times = Integer.parseInt(st.nextToken());
            
            if (direction.equals("W")) {
                x += dx[0] * times;

            } else if (direction.equals("E")) {
                x += dx[1] * times;

            } else if (direction.equals("N")) {
                y += dy[2] * times;

            } else {
                y += dy[3] * times;
            }
        }

        System.out.println(x + " " + y);
    }
}