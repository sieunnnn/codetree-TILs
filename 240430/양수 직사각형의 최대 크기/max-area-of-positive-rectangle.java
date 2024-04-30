import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] graph;
    static int max_size = -1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        initGraph();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] > 0) {
                    findMaxSize(i, j);
                }
            }
        }

        System.out.println(max_size == -1 ? -1 : max_size);
    }

    public static void initGraph() throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void findMaxSize(int startY, int startX) {
        int minWidth = Integer.MAX_VALUE;

        for (int i = startY; i < n && graph[i][startX] > 0; i++) {
            int width = 0;

            while (startX + width < m && graph[i][startX + width] > 0) {
                width++;
            }

            minWidth = Math.min(minWidth, width);
            int size = minWidth * (i - startY + 1);
            max_size = Math.max(max_size, size);
        }
    }
}