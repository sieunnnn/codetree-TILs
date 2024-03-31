import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int a1;
    static int a2;
    static int cnt = 10;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        a2 = Integer.parseInt(st.nextToken());
        
        sb.append(a1).append(" ").append(a2).append(" ");
        solve(a1, a2, cnt);
        System.out.println(sb.toString());
    }

    public static void solve(int n1, int n2, int cnt) {
        if (cnt == 2) {
            return;
        }

        int n3 = n2 + 2 * (n1);
        sb.append(n2 + 2 * (n1)).append(" ");
        cnt --;
        solve(n2, n3, cnt);
    }
}