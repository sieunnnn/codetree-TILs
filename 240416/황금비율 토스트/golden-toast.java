import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Character> alphabets = new LinkedList<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        for (char ch : input.toCharArray()) {
            alphabets.add(ch);
        }

        ListIterator<Character> iterator = alphabets.listIterator(alphabets.size());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("L")) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                }
            } else if (command.equals("R")) {
                if (iterator.hasNext()) {
                    iterator.next();
                }
            } else if (command.equals("D")) {
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
            } else if (command.equals("P")) {
                char newChar = st.nextToken().charAt(0);
                iterator.add(newChar);
            }
        }

        for (char c : alphabets) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}