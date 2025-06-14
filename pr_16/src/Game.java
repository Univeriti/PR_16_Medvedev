import java.util.Scanner;
public class Game {
    public static void play() {
        Scanner sc = new Scanner(System.in);
        int n = Config.size;
        char[][] b = new char[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) b[i][j] = ' ';
        boolean turn = true;
        int m = 0;
        while (true) {
            print(b);
            System.out.println("Хід: " + (turn ? Config.player1 : Config.player2));
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            sc.nextLine();
            if (x < 0 || y < 0 || x >= n || y >= n || b[x][y] != ' ') continue;
            b[x][y] = turn ? 'X' : 'O';
            m++;
            if (win(b, turn ? 'X' : 'O')) {
                print(b);
                System.out.println("Переможець: " + (turn ? Config.player1 : Config.player2));
                Stats.save(turn ? Config.player1 : Config.player2);
                break;
            }
            if (m == n * n) {
                print(b);
                System.out.println("Нічия");
                Stats.save("Нічия");
                break;
            }
            turn = !turn;
        }
    }

    static void print(char[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.print(b[i][j]);
                if (j < b.length - 1) System.out.print("|");
            }
            System.out.println();
        }
    }

    static boolean win(char[][] b, char s) {
        int n = b.length;
        for (int i = 0; i < n; i++) {
            boolean r = true, c = true;
            for (int j = 0; j < n; j++) {
                if (b[i][j] != s) r = false;
                if (b[j][i] != s) c = false;
            }
            if (r || c) return true;
        }
        boolean d1 = true, d2 = true;
        for (int i = 0; i < n; i++) {
            if (b[i][i] != s) d1 = false;
            if (b[i][n - i - 1] != s) d2 = false;
        }
        return d1 || d2;
    }
}
