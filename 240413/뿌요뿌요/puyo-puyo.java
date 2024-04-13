import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int cnt;
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int blocksize = solve(j, i);
                    max = Math.max(max, blocksize);
                    if (blocksize >= 4) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt + " " + max);
    }

    public static int solve(int x, int y) {
        visited[y][x] = true;
        int blocksize = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[ny][nx] && graph[ny][nx] == graph[y][x]) {
                    blocksize += solve(nx, ny);
                }
            }
        }

        return blocksize;
    }
}