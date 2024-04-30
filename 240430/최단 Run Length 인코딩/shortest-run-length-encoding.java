import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int min_length = Integer.MAX_VALUE;
    static String str;

    public static void main(String[] args) throws IOException {
        str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            String newStr = shiftStr();
            findMinLength(newStr);
        }

        System.out.println(min_length);
    }

    public static String shiftStr() {
        int lastIdx = str.length() - 1;
        String temp = str.substring(0, lastIdx - 1);

        return str.charAt(lastIdx) + temp;
    }

    public static void findMinLength(String str) {
        int cnt = 1;
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;

            } else {
                temp.append(str.charAt(i)).append(cnt);
                cnt = 1; // 초기화
            }
        }
        
        temp.append(str.charAt(str.length() - 1)).append(cnt);
        min_length = Math.min(min_length, temp.length());
    }
}