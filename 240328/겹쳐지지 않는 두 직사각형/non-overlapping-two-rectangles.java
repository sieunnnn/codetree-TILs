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
    static List<int[]> boxes = new ArrayList<>();

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
        
        for (int i = 0; i < boxes.size(); i++) {
            int[] box1 = boxes.get(i);
            for (int j = i + 1; j < boxes.size(); j++) {
                int[] box2 = boxes.get(j);
                if(checkOverlap(box1, box2)) {
                    max = Math.max(max, box1[4] + box2[4]);
                }
            }
        }
        
        System.out.println(max);
    }

    public static void makeBox() {
        for (int i = 0; i < n; i++) { // x1
            for (int j = 0; j < m; j++) { // y1
                for (int k = i; k < n; k++) { // x2
                    for (int s = j; s < m; s++) { // y2
                        getSum(i, j, k, s);
                    }
                }
            }
        }
    }

    public static void getSum(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                sum += graph[i][j];
            }
        }
        boxes.add(new int[]{y1, x1, y2, x2, sum}); 
    }

    public static boolean checkOverlap(int[] box1, int[] box2) {
        for (int i = box1[1]; i <= box1[3]; i++) {
            for (int j = box1[0]; j <= box1[2]; j++) {
                if(i >= box2[1] && i <= box2[3] && j >= box2[0] && j <= box2[2]) {
                    return false;
                }
            }
        }
        return true;
    }
}