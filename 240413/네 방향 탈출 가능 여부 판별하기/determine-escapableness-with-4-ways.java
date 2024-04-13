import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
               graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (graph[0][0] == 1) {
            int answer = solve(0, 0);
            System.out.println(answer);
        } else {
            System.out.println(0); 
        }
    }

    public static int solve(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == m - 1 && current[1] == n - 1) {
                return 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (!visited[ny][nx] && graph[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return 0;
    }
}