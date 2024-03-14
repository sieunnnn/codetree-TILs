import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static int[][] graph;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];

        for(int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkNumber();

        System.out.println(cnt);
    }

    public static void checkNumber() {
        for(int i = 0; i < n; i ++) {
            int cntRow = 1;
            int cntCol = 1;

            for(int j = 1; j < n; j ++) {
                if (graph[i][j] == graph[i][j -1]) {
                    cntRow ++;
                }

                if (graph[j][i] == graph[j - 1][i]) {
                    cntCol ++;
                }
            }

            if (cntRow >= m) {
                cnt ++;
                cntRow = 1;
            }

            if (cntCol >= m) {
                cnt ++;
                cntCol = 1;
            }
        }
    }
}