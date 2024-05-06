import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] dots;
    static int[] ids;

    static int n, m;
    static int min = Integer.MAX_VALUE;

    static List<Integer> maxes = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dots = new int[n][2];
        ids = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(Arrays.deepToString(dots));

        for (int i = 0; i < n; i++) {
            solve(i, 0);
        }

        findMax();

        System.out.println(min);
    }

    public static void solve(int start, int depth) {
        if (depth == m) {
            // System.out.println(Arrays.toString(ids));
            int id1 = ids[0];
            int id2 = ids[1];
            int x1 = dots[id1][0];
            int x2 = dots[id2][0];
            int y1 = dots[id1][1];
            int y2 = dots[id2][1];
            caculate(x1, x2, y1, y2);

            return;
        }

        for (int i = start; i < n; i++) {
            ids[depth] = i;
            solve(i + 1, depth + 1);
        }
    }

    public static void caculate(int x1, int x2, int y1, int y2) {
        int result = (int)(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        // System.out.println(result);
        maxes.add(result);
    }

    public static void findMax() {
        for (int max : maxes) {
            // System.out.println(max);
            min = Math.min(max, min);
        }
    }
}