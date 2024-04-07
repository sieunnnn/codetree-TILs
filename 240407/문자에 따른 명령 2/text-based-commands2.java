import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {1, 0, -1, 0}; // 우 아래 좌 위
    static int[] dy = {0, -1, 0, 1};
    static int currentDir = 3;
    static String[] command;
    static int x = 0;
    static int y = 0;
      
    public static void main(String[] args) throws IOException {
        command = br.readLine().split("");

        for(int i = 0; i < command.length; i++) {
            if (command[i].equals("L")) {
                currentDir = (currentDir - 1 + 4) % 4;

            } else if (command[i].equals("R")) {
                currentDir = (currentDir + 1) % 4;

            } else if (command[i].equals("F")) {
                x += dx[currentDir];
                y += dy[currentDir];
            }
        }

        System.out.println(x + " " + y);
    }
}