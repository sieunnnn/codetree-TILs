import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int min_length = Integer.MAX_VALUE;
    static String str;

    public static void main(String[] args) throws IOException {
        str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            str = shiftStr(str);
            findMinLength(str);
        }

        System.out.println(min_length);
    }

    public static String shiftStr(String str) {
        int len = str.length();
        return str.charAt(len - 1) + str.substring(0, len - 1);
    }


    public static void findMinLength(String str) {
        // System.out.println(str);
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