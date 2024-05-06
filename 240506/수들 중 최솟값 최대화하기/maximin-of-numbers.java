import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<Integer> numbers = new ArrayList<>();
    static boolean[] visited;
    static int[][] graph;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0);
        System.out.println(max);
    }

    public static void solve(int row) {
        if (row == n) {
            int min = findMin();
            max = Math.max(max, min);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers.add(graph[row][i]);

                solve(row + 1);
                visited[i] = false;
                numbers.remove(numbers.size() - 1);
            }
        }
    }

    private static int findMin() {
        int min = Integer.MAX_VALUE;
        
        for (int number : numbers) {
            // System.out.println(number);
            min = Math.min(min, number);
        }
        
        return min;
    }
}