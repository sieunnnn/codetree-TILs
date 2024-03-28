import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static int[][] graph;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeBox();
        
        if (max == Integer.MIN_VALUE) {
            System.out.print(-1);
        } else {
            System.out.println(max);
        }
    }

    public static void makeBox() {
        for (int i = 0; i < n; i++) { // y1
            for (int j = 0; j < m; j++) { // x1
                for (int k = i; k < n; k++) { // y2
                    for (int s = j; s < m; s++) { // x2
                        if(checkValues(j, i, s, k)) {
                            int width = s - j + 1;
                            int height = k - i + 1;
                            max = Math.max(max, width * height);
                        }
                    }
                }
            }
        }
    }

    public static boolean checkValues(int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            for(int j = x1; j <= x2; j++) {
                if(graph[i][j] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}