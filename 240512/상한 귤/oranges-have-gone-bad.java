import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int n, k;
    static int[][] graph;
    static int[][] result;
    static boolean[][] visited;
    static List<int[]> startNodes = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        result = new int[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 2) {
                    startNodes.add(new int[]{i, j});
                    result[i][j] = 0;
                    visited[i][j] = true;

                } else if (graph[i][j] == 1) {
                    result[i][j] = -2;

                } else {
                    result[i][j] = -1;
                }
            }
        }

        for (int[] node : startNodes) {
            solve(node[0], node[1]);
        }
        
        printResult();
    }

    public static void solve(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] node : startNodes) {
            queue.offer(new int[]{node[0], node[1]});
        }

        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            int y = currentNode[0];
            int x = currentNode[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < n && graph[ny][nx] == 1 && result[ny][nx] == -2) {
                    queue.offer(new int[]{ny, nx});
                    result[ny][nx] = result[y][x] + 1;
                }
            }
        }
    }

    public static void printResult() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}