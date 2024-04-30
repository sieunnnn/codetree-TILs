import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] graph;
    static int max_size = -1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        initGraph();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] < 0) {
                    break;
                }
                
                for (int k = i; k < n; k++) {
                    for (int s = j; s < m; s++) {
                        if (graph[k][s] < 0) {
                            break;
                        }
                        findMaxSize(i, j, k, s);
                    }
                }
            }
        }

        System.out.println(max_size);
    }

    public static void initGraph() throws IOException {
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void findMaxSize(int y1, int x1, int y2, int x2) {
        boolean checkSize = true;
        int size = 0;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (graph[i][j] < 0) {
                    checkSize = false;
                }
            }
        }
        
        if (checkSize) {
            size = (x2 - x1 + 1) * (y2 - y1 + 1);
            max_size = Math.max(max_size, size);
        }
    }
}