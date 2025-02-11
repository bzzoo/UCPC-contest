package basic_practice.force_recursion;

import java.util.Scanner;

public class 별찍기11_2448 {

    static char[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        map = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2*N-1; j++) {
                map[i][j] = ' ';
            }
        }
        drawPattern(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    static void drawPattern(int x, int y, int size) {
        if (size == 3) {
            map[x][y] = '*';
            map[x + 1][y - 1] = '*';
            map[x + 1][y + 1] = '*';
            map[x + 2][y - 2] = '*';
            map[x + 2][y - 1] = '*';
            map[x + 2][y] = '*';
            map[x + 2][y + 1] = '*';
            map[x + 2][y + 2] = '*';
            return;
        }

        int newSize = size / 2;
        drawPattern(x, y, newSize);
        drawPattern(x + newSize, y - newSize, newSize);
        drawPattern(x + newSize, y + newSize, newSize);
    }
}
